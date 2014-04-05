/**
 *
 */
package org.redneck.persistinator.meta;

import org.redneck.persistinator.util.Strings;

/**
 * @author ran488
 * 
 */
public class Table extends AbstractTable implements java.io.Serializable {

	/**
     *
     */
	private static final long serialVersionUID = -7680172950733465301L;
	private String tableSchema;
	private String tableName;
	private String tableType;
	private String tableRemarks;
	private java.util.List<TableColumn> columns;
	private java.util.List<Key> primaryKeys;
	private java.util.List<Key> importedKeys;
	private java.util.List<Key> exportedKeys;
	private java.util.List<Index> primaryIndexes; // mostly for teradata

	/**
     *
     */
	public Table() {
		super();
		this.setTable(true);
	}

	/**
	 * @param tableSchema
	 * @param tableName
	 * @param tableType
	 * @param tableRemarks
	 */
	public Table(String tableSchema, String tableName, String tableType,
			String tableRemarks) {
		this();
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.tableType = tableType;
		this.tableRemarks = tableRemarks;
	}

	/**
	 * @return the columns
	 */
	public java.util.List<TableColumn> getColumns() {
		return columns;
	}

	/**
	 * @param columns
	 *            the columns to set
	 */
	public void setColumns(java.util.List<TableColumn> columns) {
		this.columns = columns;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the tableRemarks
	 */
	public String getTableRemarks() {
		return tableRemarks;
	}

	/**
	 * @param tableRemarks
	 *            the tableRemarks to set
	 */
	public void setTableRemarks(String tableRemarks) {
		this.tableRemarks = tableRemarks;
	}

	/**
	 * @return the tableSchema
	 */
	public String getTableSchema() {
		return tableSchema;
	}

	/**
	 * @param tableSchema
	 *            the tableSchema to set
	 */
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	/**
	 * @return the tableType
	 */
	public String getTableType() {
		return tableType;
	}

	/**
	 * @param tableType
	 *            the tableType to set
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	/** Override toString() */
	public String toString() {
		// StringBuffer sb = new StringBuffer("Table: ");
		// sb.append(Strings.toStringGenerator(this));
		// return sb.toString();
		return this.getTableSchema() + "." + this.getTableName();
	}

	/**
	 * @return the exportedKeys
	 */
	public java.util.List<Key> getExportedKeys() {
		return exportedKeys;
	}

	/**
	 * @param exportedKeys
	 *            the exportedKeys to set
	 */
	public void setExportedKeys(java.util.List<Key> exportedKeys) {
		this.exportedKeys = exportedKeys;
	}

	/**
	 * @return the importedKeys
	 */
	public java.util.List<Key> getImportedKeys() {
		return importedKeys;
	}

	/**
	 * @param importedKeys
	 *            the importedKeys to set
	 */
	public void setImportedKeys(java.util.List<Key> importedKeys) {
		this.importedKeys = importedKeys;
	}

	/**
	 * @return the jFieldName
	 */
	public String getJFieldName() {
		return Strings.getJavaFieldName(this.getTableName());
	}

	/**
	 * @return the jProperFieldName
	 */
	public String getJProperFieldName() {
		return Strings.getJavaProperFieldName(this.getTableName());
	}

	/**
	 * @return the primaryKeys
	 */
	public java.util.List<Key> getPrimaryKeys() {
		return primaryKeys;
	}

	/**
	 * @param primaryKeys
	 *            the primaryKeys to set
	 */
	public void setPrimaryKeys(java.util.List<Key> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public java.util.List<Index> getPrimaryIndexes() {
		return primaryIndexes;
	}

	public void setPrimaryIndexes(java.util.List<Index> primaryIndexes) {
		this.primaryIndexes = primaryIndexes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tableName == null) ? 0 : tableName.hashCode());
		result = prime * result
				+ ((tableType == null) ? 0 : tableType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Table)) {
			return false;
		}
		Table other = (Table) obj;
		if (tableName == null) {
			if (other.tableName != null) {
				return false;
			}
		} else if (!tableName.equals(other.tableName)) {
			return false;
		}
		if (tableType == null) {
			if (other.tableType != null) {
				return false;
			}
		} else if (!tableType.equals(other.tableType)) {
			return false;
		}
		return true;
	}

}
