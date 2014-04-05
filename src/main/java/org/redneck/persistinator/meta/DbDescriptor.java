/**
 * 
 */
package org.redneck.persistinator.meta;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import org.redneck.persistinator.log.SimpleLogger;
import org.redneck.persistinator.meta.userdef.CustomMethod;


/**
 * @author ran488
 * 
 */
public class DbDescriptor {
	/** User provided if we should limit describing certain schemas */
	private String schemaFilter = null;

	/** DB meta data descriptor object */
	private DatabaseMetaData dbmd;

	/** the described database object representation */
	private Database db = null;

	private String userName = null;

	private String dbUrl = null;

	private String password = null;

	/** Constructor */
	public DbDescriptor() {
		super();
		db = new Database();
	}

	/**
	 * Constructor in case you already have a database object (with custom
	 * methods)
	 */
	public DbDescriptor(Database dBase) {
		super();
		this.db = dBase;
	}

	/** Constructor */
	public DbDescriptor(String schemaFilter) {
		this();
		this.schemaFilter = schemaFilter;
	}

	/**
	 * Constructor in case you already have a database object (with custom
	 * methods)
	 */
	public DbDescriptor(String schemaFilter, Database dBase) {
		super();
		this.schemaFilter = schemaFilter;
		this.db = dBase;
	}

	/** One method to call them all! */
	public Database describe(String dbUrl, String userName, String password,
			String driverClassName) throws Exception {
		initDriver(driverClassName);
		this.userName = userName;
		this.password = password;
		this.dbUrl = dbUrl;

		this.describeDatabase();
		// temp disable for TeraData
		this.describeProcedures();
		this.describeTables();

		return this.db;
	}

	/**
	 * load JDBC driver and initialize JDBC connection
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void initDriver(String driverClassName)
			throws ClassNotFoundException {
		SimpleLogger.log("- Initializing DB Driver...");
		Class.forName(driverClassName);
	}

	private Connection getConnection(String dbUrl, String userName,
			String password) throws SQLException {
		Connection _conn = DriverManager.getConnection(dbUrl, userName,
				password);
		return _conn;
	}

	/** release connection, clean everything up before closing down */
	private void closeConnection(Connection _conn) {
		try {
			_conn.close();
		} catch (Exception e) {
		}
	}

	private void describeDatabase() throws SQLException {
		SimpleLogger.log("- Begin describing database...");
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			db.setDbProduct(dbmd.getDatabaseProductName());
			db.setDbProductVersion(dbmd.getDatabaseProductVersion());
			db.setCatalogTerm(dbmd.getCatalogTerm());
			db.setCatalogSeparator(dbmd.getCatalogSeparator());

			ResultSet catalogsRs;
			java.util.List<String> catalogs = new java.util.ArrayList<String>();
			catalogsRs = dbmd.getCatalogs();
			while (catalogsRs.next()) {
				String tmp = catalogsRs.getString("TABLE_CAT");
				catalogs.add(tmp);
			}
			db.setCatalogs(catalogs);
			SimpleLogger.log("    - " + catalogs.size() + " catalogs found.");

			ResultSet schemasRs;
			java.util.List<String> schemas = new java.util.ArrayList<String>();
			schemasRs = dbmd.getSchemas();
			while (schemasRs.next()) {
				String tmp = schemasRs.getString("TABLE_SCHEM");
				SimpleLogger.log("  --> Schema: " + tmp);
				boolean added = schemas.add(tmp);
			}
			db.setSchemas(schemas);
			SimpleLogger.log("    - " + schemas.size() + " schemas found.");
			SimpleLogger.log("- Done describing database.");
		} finally {
			this.closeConnection(_conn);
		}
	}

	/**
	 * @param _conn
	 * @throws SQLException
	 */
	private void describeTables() throws SQLException {
		SimpleLogger.log("- Begin describing tables...");
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet rs;
			java.util.List<Table> tables = new java.util.ArrayList<Table>();
			rs = dbmd.getTables(null, schemaFilter, null, null);
			while (rs.next()) {
				String tableSchema = rs.getString("TABLE_SCHEM");
				String tableName = rs.getString("TABLE_NAME");
				String tableType = rs.getString("TABLE_TYPE");

				// if one table fails, skip it and move on
				try {

					// String tableRemarks = rs.getString("REMARKS");
					SimpleLogger.log("  - Start Table: " + tableName);

					Table table = new Table(tableSchema, tableName, tableType,
							"");

					// see if current table exists and if it has custom methods
					// if so save them for later.
					java.util.List<CustomMethod> custMethods = null;
					if ((db != null) && (db.getTables() != null)
							&& (db.getTables().contains(table))) {
						SimpleLogger.log("   # Saving custom methods...");
						Table oldTable = db.getTables().get(
								db.getTables().indexOf(table));
						custMethods = oldTable.getCustomMethods();
						table.setCustomMethods(custMethods);
						SimpleLogger.log("   # Saved " + custMethods.size()
								+ " custom methods.");
					}

					descTableColumns(table);
					descExportedKeys(table);
					descImportedKeys(table);
					descPrimaryKeys(table);
					// descPrimaryIndexes(table);
					SimpleLogger.log("  - End Table: " + tableName);
					boolean ok = tables.add(table);
				} catch (Exception e) {
					e.printStackTrace();
					SimpleLogger.log("Error describing table " + tableSchema
							+ "." + tableName + ". Skipping....");
				}
			}
			db.setTables(tables);
			SimpleLogger.log("    - " + tables.size() + " tables found.");
			SimpleLogger.log("- Done describing tables.");
		} finally {
			this.closeConnection(_conn);
		}
	}

	/**
	 * FIXME: Need a procedure object to hold all this info
	 * 
	 * @param _conn
	 * @throws SQLException
	 */
	private void describeProcedures() throws SQLException {
		SimpleLogger.log("- Begin describing procedures...");

		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet procsRs;
			java.util.List<Procedure> procedures = new java.util.ArrayList<Procedure>();
			procsRs = dbmd.getProcedures(null, schemaFilter, null);
			while (procsRs.next()) {
				String procSchema = procsRs.getString("PROCEDURE_SCHEM");
				String procName = procsRs.getString("PROCEDURE_NAME");
				String procRemarks = procsRs.getString("REMARKS");
				short procType = procsRs.getShort("PROCEDURE_TYPE");
				Procedure proc = new Procedure(procSchema, procName,
						procRemarks, procType);
				descProcColumns(proc);
				SimpleLogger.log("  - Procedure: " + procName);
				boolean ok = procedures.add(proc);
			}
			db.setProcedures(procedures);
			SimpleLogger.log("    - " + procedures.size()
					+ " procedures found.");

			SimpleLogger.log("- Done describing procedures.");
		} finally {
			this.closeConnection(_conn);
		}
	}

	/**
	 * Each row in the ResultSet is a parameter description or column
	 * description with the following fields:
	 * 
	 * @param proc
	 * @throws SQLException
	 */
	private void descProcColumns(Procedure proc) throws SQLException {
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet colRs;
			java.util.List<ProcedureColumn> cols;

			cols = new java.util.ArrayList<ProcedureColumn>();
			colRs = dbmd.getProcedureColumns(null, proc.getProcSchema(),
					proc.getProcName(), null);
			while (colRs.next()) {
				String colName = colRs.getString("COLUMN_NAME");
				short colType = colRs.getShort("COLUMN_TYPE");
				int dataType = colRs.getInt("DATA_TYPE");
				String typeName = colRs.getString("TYPE_NAME");
				int precision = colRs.getInt("PRECISION");
				short scale = colRs.getShort("SCALE");
				short radix = colRs.getShort("RADIX");
				short nullable = colRs.getShort("NULLABLE");
				String remarks = colRs.getString("REMARKS");
				ProcedureColumn col = new ProcedureColumn(colName, colType,
						dataType, typeName, precision, scale, radix, nullable,
						remarks);
				// SimpleLogger.log(" - Procedure Column: " + colName);
				boolean ok = cols.add(col);
			}
			proc.setProcColumns(cols);
			SimpleLogger.log("    - " + cols.size() + " columns found for "
					+ proc.getProcName());
		} finally {
			this.closeConnection(_conn);
		}

	}

	/**
	 * 
	 * @param proc
	 * @throws SQLException
	 */
	private void descTableColumns(Table table) throws SQLException {
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet colRs;
			java.util.List<TableColumn> cols;

			cols = new java.util.ArrayList<TableColumn>();
			colRs = dbmd.getColumns(null, table.getTableSchema(),
					table.getTableName(), null);
			while (colRs.next()) {
				String colName = colRs.getString("COLUMN_NAME");//
				int dataType = colRs.getInt("DATA_TYPE");//
				String typeName = colRs.getString("TYPE_NAME");//
				int colSize = colRs.getInt("COLUMN_SIZE");
				int decimalDigits = colRs.getInt("DECIMAL_DIGITS");
				int radix = colRs.getInt("NUM_PREC_RADIX");//
				int ordinalPosition = colRs.getInt("ORDINAL_POSITION");//
				int charOctetLen = colRs.getInt("CHAR_OCTET_LENGTH");//
				short nullable = colRs.getShort("NULLABLE");//
				String remarks = colRs.getString("REMARKS");//
				// String colDefault = colRs.getString("COLUMN_DEF");//

				TableColumn col = new TableColumn(colName, dataType, typeName,
						colSize, decimalDigits, radix, ordinalPosition,
						charOctetLen, nullable, remarks, "");
				// SimpleLogger.log(" - Procedure Column: " + colName);
				boolean ok = cols.add(col);
			}
			table.setColumns(cols);
			SimpleLogger.log("    - " + cols.size() + " columns found for "
					+ table.getTableName());
		} finally {
			this.closeConnection(_conn);
		}

	}

	private void descExportedKeys(Table table) throws SQLException {
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet colRs;
			java.util.List<Key> keys;

			keys = new java.util.ArrayList<Key>();
			colRs = dbmd.getExportedKeys(null, table.getTableSchema(),
					table.getTableName());
			while (colRs.next()) {
				String pkTableSchema = colRs.getString("PKTABLE_SCHEM");//
				String pkTableName = colRs.getString("PKTABLE_NAME");//
				String pkColumnName = colRs.getString("PKCOLUMN_NAME");//
				String fkTableSchema = colRs.getString("FKTABLE_SCHEM");//
				String fkTableName = colRs.getString("FKTABLE_NAME");//
				String fkColumnName = colRs.getString("FKCOLUMN_NAME");//
				String fkName = colRs.getString("FK_NAME");//
				String pkName = colRs.getString("PK_NAME");//
				short updateRule = colRs.getShort("UPDATE_RULE");
				short deleteRule = colRs.getShort("DELETE_RULE");

				Key key = new Key(pkTableSchema, pkTableName, pkColumnName,
						fkTableSchema, fkTableName, fkColumnName, fkName,
						pkName, updateRule, deleteRule);
				boolean ok = keys.add(key);
			}
			table.setExportedKeys(keys);
			SimpleLogger.log("    - " + keys.size()
					+ " Exported Keys found for " + table.getTableName());
		} finally {
			this.closeConnection(_conn);
		}

	}

	private void descImportedKeys(Table table) throws SQLException {
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet colRs;
			java.util.List<Key> keys;

			keys = new java.util.ArrayList<Key>();
			colRs = dbmd.getImportedKeys(null, table.getTableSchema(),
					table.getTableName());
			while (colRs.next()) {
				String pkTableSchema = colRs.getString("PKTABLE_SCHEM");//
				String pkTableName = colRs.getString("PKTABLE_NAME");//
				String pkColumnName = colRs.getString("PKCOLUMN_NAME");//
				String fkTableSchema = colRs.getString("FKTABLE_SCHEM");//
				String fkTableName = colRs.getString("FKTABLE_NAME");//
				String fkColumnName = colRs.getString("FKCOLUMN_NAME");//
				String fkName = colRs.getString("FK_NAME");//
				String pkName = colRs.getString("PK_NAME");//
				short updateRule = colRs.getShort("UPDATE_RULE");
				short deleteRule = colRs.getShort("DELETE_RULE");

				Key key = new Key(pkTableSchema, pkTableName, pkColumnName,
						fkTableSchema, fkTableName, fkColumnName, fkName,
						pkName, updateRule, deleteRule);
				boolean ok = keys.add(key);
			}
			table.setImportedKeys(keys);
			SimpleLogger.log("    - " + keys.size()
					+ " Exported Keys found for " + table.getTableName());
		} finally {
			this.closeConnection(_conn);
		}

	}

	private void descPrimaryKeys(Table table) throws SQLException {
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet colRs;
			java.util.List<Key> keys;

			keys = new java.util.ArrayList<Key>();
			colRs = dbmd.getPrimaryKeys(null, table.getTableSchema(),
					table.getTableName());
			while (colRs.next()) {
				String pkTableSchema = colRs.getString("TABLE_SCHEM");//
				String pkTableName = colRs.getString("TABLE_NAME");//
				String pkColumnName = colRs.getString("COLUMN_NAME");//
				String pkName = colRs.getString("PK_NAME");//

				Key key = new Key();
				key.setPkTableSchema(pkTableSchema);
				key.setPkColumnName(pkColumnName);
				key.setPkName(pkName);
				key.setPkTableName(pkTableName);
				key.setColName(pkColumnName);

				// find column and pop needed stuff in key as well
				TableColumn tmp = table.getColumns().get(
						table.getColumns().indexOf(key));
				key.setDataType(tmp.getDataType());

				boolean ok = keys.add(key);
			}
			table.setPrimaryKeys(keys);
			SimpleLogger.log("    - " + keys.size()
					+ " Primary Keys found for " + table.getTableName());
		} finally {
			this.closeConnection(_conn);
		}

	}

	/**
	 * Added mostly for TeraData which does not have primary keys but has
	 * "primary indexes" -- no real good way to distinguish that info from the
	 * JDBC Meta Data structures, so we guess and take the first set of non-zero
	 * type indexs that are not nullable.
	 */
	private void descPrimaryIndexes(Table table) throws SQLException {
		Connection _conn = null;

		try {
			_conn = this.getConnection(dbUrl, userName, password);
			dbmd = _conn.getMetaData();

			ResultSet colRs;
			java.util.List<Index> keys;

			keys = new java.util.ArrayList<Index>();
			colRs = dbmd.getIndexInfo(null, table.getTableSchema(),
					table.getTableName(), true, false);

			int lastOridinalPosn = 0;

			while (colRs.next()) {
				// String pkTableSchema = colRs.getString("TABLE_SCHEM");//
				// String pkTableName = colRs.getString("TABLE_NAME");//
				// String pkColumnName = colRs.getString("COLUMN_NAME");//
				// String pkName = colRs.getString("PK_NAME");//

				String pkTableSchema = colRs.getString("TABLE_SCHEM");
				String pkTableName = colRs.getString("TABLE_NAME");
				boolean nonUnique = colRs.getBoolean("NON_UNIQUE");
				String idxQualifier = colRs.getString("INDEX_QUALIFIER");
				String idxName = colRs.getString("INDEX_NAME");
				short idxType = colRs.getShort("TYPE");
				short ordPosn = colRs.getShort("ORDINAL_POSITION");
				String pkColumnName = colRs.getString("COLUMN_NAME");//
				String filterCond = colRs.getString("FILTER_CONDITION");//

				SimpleLogger.log("    - Index: " + pkTableSchema + " / "
						+ pkTableName + " / " + nonUnique + " / "
						+ idxQualifier + " / " + idxName + " / " + idxType
						+ " / " + ordPosn + " / " + pkColumnName + " / "
						+ filterCond);

				if (idxType != 0) {
					Index idx = new Index();
					idx.setPkTableSchema(pkTableSchema);
					idx.setPkTableName(pkTableName);
					idx.setNonUnique(nonUnique);
					idx.setIdxQualifier(idxQualifier);
					idx.setIdxName(idxName);
					idx.setIdxType(idxType);
					idx.setOrdPosn(ordPosn);
					idx.setPkColumnName(pkColumnName);
					idx.setFilterCond(filterCond);

					idx.setColName(pkColumnName);

					// find column and pop needed stuff in key as well
					TableColumn tmp = table.getColumns().get(
							table.getColumns().indexOf(idx));
					idx.setDataType(tmp.getDataType());

					if (!keys.contains(idx) && (ordPosn > lastOridinalPosn)) {
						boolean ok = keys.add(idx);
						lastOridinalPosn = ordPosn;
					}

				}
			}
			table.setPrimaryIndexes(keys);
			SimpleLogger.log("    - " + keys.size()
					+ " Primary Indexes found for " + table.getTableName());

		} catch (SQLException e) {
			SimpleLogger
					.log("Error getting index, may be a view. Will try to continue...");
			e.printStackTrace();
		} finally {
			this.closeConnection(_conn);
		}

	}

	/**
	 * @return the schemaFilter
	 */
	public String getSchemaFilter() {
		return schemaFilter;
	}

	/**
	 * @param schemaFilter
	 *            the schemaFilter to set
	 */
	public void setSchemaFilter(String schemaFilter) {
		this.schemaFilter = schemaFilter;
	}

	/**
	 * @return the db
	 */
	public Database getDb() {
		return db;
	}

	/**
	 * @return the dbmd
	 */
	public DatabaseMetaData getDbmd() {
		return dbmd;
	}
}
