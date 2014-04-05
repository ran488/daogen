package org.redneck.persistinator.typemaps;

/**
 * <p>
 * 
 * <b>PGEN Project class</b>
 * </p>
 * <br>
 * SQL <> JDBC type mapping interface. Implementations to provide RDBMS-specific
 * mappings. JDBC types are those specified in java.sql.Types
 * <p>
 * 
 * @author Mike Finn
 * @created June 14, 2002
 * @version Internal: $Id: Sql2JdbcTypeMapper.java,v 1.1.1.1 2002/05/21 17:53:30
 *          mfinn Exp $
 * @version External: 0.1
 */
public interface Sql2JdbcTypeMapper {
	/**
	 * Get JDBC type that is mapped to given SQL type
	 * 
	 * @param sqlType
	 * @return
	 * @throws UnmappedSqlTypeException
	 * @see java.sql.Types
	 */
	public int getJdbcTypeFromSqlType(String sqlType) throws Exception;

	/**
	 * Gets the JdbcTypeFromSqlType attribute of the Sql2JdbcTypeMapper object
	 * 
	 * @param sqlType
	 *            Description of Parameter
	 * @param length
	 *            Description of Parameter
	 * @param scale
	 *            Number of decimal places (from DB)
	 * @return The JdbcTypeFromSqlType value
	 * @exception UnmappedSqlTypeException
	 *                Description of Exception
	 */
	public int getJdbcTypeFromSqlType(String sqlType, int length, int scale)
			throws Exception;
}
