package org.redneck.persistinator.typemaps;

import java.sql.Types;

/**
 * <p>
 * 
 * <b>PGEN Project class</b>
 * </p>
 * <br>
 * Helper functions to convert between int and String representation od JDBC
 * datatypes.
 * <p>
 * 
 * 
 * @author Mike Finn
 * @created June 14, 2002
 * @version Internal: $Id: JdbcTypesHelper.java,v 1.1.1.1 2002/05/21 17:53:30
 *          mfinn Exp $
 * @version External: 0.1
 * @see java.sql.Types
 */
public class JdbcTypesHelper {
	/**
	 * Description of the Method
	 * 
	 * @param typeId
	 *            Description of Parameter
	 * @return Description of the Returned Value
	 */
	public static String decodeJdbcType(int typeId) {
		switch (typeId) {
		case Types.ARRAY:
			return "ARRAY";
		case Types.BIGINT:
			return "BIGINT";
		case Types.BINARY:
			return "BINARY";
		case Types.BIT:
			return "BIT";
		case Types.BLOB:
			return "BLOB";
		case Types.CHAR:
			return "CHAR";
		case Types.CLOB:
			return "CLOB";
		case Types.DATE:
			return "DATE";
		case Types.DECIMAL:
			return "DECIMAL";
		case Types.DISTINCT:
			return "DISTINCT";
		case Types.DOUBLE:
			return "DOUBLE";
		case Types.FLOAT:
			return "FLOAT";
		case Types.INTEGER:
			return "INTEGER";
		case Types.JAVA_OBJECT:
			return "JAVA_OBJECT";
		case Types.LONGVARBINARY:
			return "LONGVARBINARY";
		case Types.LONGVARCHAR:
			return "LONGVARCHAR";
		case Types.NULL:
			return "NULL";
		case Types.NUMERIC:
			return "NUMERIC";
		case Types.OTHER:
			return "OTHER";
		case Types.REAL:
			return "REAL";
		case Types.REF:
			return "REF";
		case Types.SMALLINT:
			return "SMALLINT";
		case Types.STRUCT:
			return "STRUCT";
		case Types.TIME:
			return "TIME";
		case Types.TIMESTAMP:
			return "TIMESTAMP";
		case Types.TINYINT:
			return "TINYINT";
		case Types.VARBINARY:
			return "VARBINARY";
		case Types.VARCHAR:
			return "VARCHAR";
		default:
			return "";
		}
	}

	private static String getTypeMethodFrag(int typeId) {
		switch (typeId) {
		case Types.ARRAY:
			return "Array";
		case Types.BIGINT:
			return "Long";
		case Types.BINARY:
			return "Object";
		case Types.BIT:
			return "Int";
		case Types.BLOB:
			return "Blob";
		case Types.CHAR:
			return "String";
		case Types.CLOB:
			return "Clob";
		case Types.DATE:
			return "Date";
		case Types.DECIMAL:
			return "Object";
		case Types.DISTINCT:
			return "Object";
		case Types.DOUBLE:
			return "Double";
		case Types.FLOAT:
			return "Float";
		case Types.INTEGER:
			return "Int";
		case Types.JAVA_OBJECT:
			return "Object";
		case Types.LONGVARBINARY:
			return "Object";
		case Types.LONGVARCHAR:
			return "String";
		case Types.NULL:
			return "Object";
		case Types.NUMERIC:
			return "Float";
		case Types.OTHER:
			return "Object";
		case Types.REAL:
			return "Float";
		case Types.REF:
			return "Object";
		case Types.SMALLINT:
			return "Int";
		case Types.STRUCT:
			return "Object";
		case Types.TIME:
			return "Time";
		case Types.TIMESTAMP:
			return "Timestamp";
		case Types.TINYINT:
			return "Int";
		case Types.VARBINARY:
			return "Blob";
		case Types.VARCHAR:
			return "String";
		default:
			return "Object";
		}

	}
}