package org.redneck.persistinator.typemaps;

import java.sql.Types;

/**
 * <p>
 * 
 * <b>PGEN Project class</b>
 * </p>
 * <br>
 * SQL <> JDBC type mapping implementation for Oracle.
 * <p>
 * 
 * 
 * @author Mike Finn
 * @created June 14, 2002
 * @version Internal: $Id: Sql2JdbcTypeMapper_Oracle.java,v 1.1.1.1 2002/05/21
 *          17:53:30 mfinn Exp $
 * @version External: 0.1
 */
public class Sql2JdbcTypeMapper_Oracle implements Sql2JdbcTypeMapper {

	/**
	 * Types that are SQL length-independent
	 * 
	 * @param sqlType
	 * @return
	 * @exception UnmappedSqlTypeException
	 *                Description of Exception
	 * @throws Exception
	 */
	public int getJdbcTypeFromSqlType(String sqlType) throws Exception {
		if (sqlType.equals("BLOB")) {
			return Types.JAVA_OBJECT;
		} else if (sqlType.equals("CHAR")) {
			return Types.CHAR;
		} else if (sqlType.equals("CLOB")) {
			return Types.VARCHAR;
		} else if (sqlType.equals("DATE")) {
			// return Types.DATE;
			return Types.TIMESTAMP;
		} else if (sqlType.equals("NUMBER")) {
			return Types.NUMERIC;
		} else if (sqlType.equals("VARCHAR2")) {
			return Types.VARCHAR;
		} else if (sqlType.equals("LONG RAW")) {
			// not in documentation, but we have a few columns
			return Types.VARCHAR;
		} else if (sqlType.equals("LONG")) {
			return Types.LONGVARCHAR;
		} else if (sqlType.equals("SMALLINT")) {
			return Types.SMALLINT;
		}

		throw new Exception(sqlType + " not mapped.");
	}

	/**
	 * Types that are SQL length-dependent
	 * 
	 * @param sqlType
	 * @param length
	 *            Description of Parameter
	 * @return
	 * @exception UnmappedSqlTypeException
	 *                Description of Exception
	 * @throws Exception
	 */
	public int getJdbcTypeFromSqlType(String sqlType, int length, int scale)
			throws Exception {
		if (sqlType.equals("NUMBER")) {
			if (scale == 0) {
				if (length == 1) {
					return Types.BIT;
				}

				/*
				 * Anything between 1 and 18 will be integer else if ( length <
				 * 10 ) { return Types.NUMERIC; }
				 */
				else if (length < 19) {
					return Types.INTEGER;
				} else if (length < 38) {
					return Types.BIGINT;
				} else
					return Types.DOUBLE;
			} else {
				return Types.DOUBLE;
			}
		} else if (sqlType.equals("BLOB")) {
			return Types.JAVA_OBJECT;
		} else if (sqlType.equals("CHAR")) {
			return Types.CHAR;
		} else if (sqlType.equals("CLOB")) {
			return Types.JAVA_OBJECT;
		} else if (sqlType.equals("DATE")) {
			// return Types.DATE;
			return Types.TIMESTAMP;
		} else if (sqlType.equals("NUMBER")) {
			return Types.NUMERIC;
		} else if (sqlType.equals("VARCHAR2")) {
			return Types.VARCHAR;
		}
		throw new Exception(sqlType + " not mapped.");
	}
}
