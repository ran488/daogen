package org.redneck.persistinator.typemaps;

import java.sql.Types;
import java.util.HashMap;

/**
 * <p>
 * 
 * <b>PGEN Project class</b>
 * </p>
 * <br>
 * Maps JDBC and Java datatypes.
 * <p>
 * 
 * @author Mike Finn
 * @created June 14, 2002
 * @version Internal: $Id: Jdbc2JavaTypeMapper.java,v 1.1.1.1 2002/05/21
 *          17:53:30 mfinn Exp $
 * @version External: 0.1
 * @see java.sql.Types
 */
@SuppressWarnings("unchecked")
public class Jdbc2JavaTypeMapper {
	/**
	 * Description of the Field
	 */
	public final static String JAVA_BOOLEAN = "java.lang.Boolean";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_BYTE = "java.lang.Byte";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_SHORT = "java.lang.Short";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_INTEGER = "java.lang.Integer";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_LONG = "java.lang.Long";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_FLOAT = "java.lang.Float";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_BIGDECIMAL = "java.math.BigDecimal";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_DOUBLE = "java.lang.Double";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_CHARACTER = "java.lang.Character";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_STRING = "java.lang.String";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_DATE = "java.sql.Date";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_TIME = "java.sql.Time";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_TIMESTAMP = "java.sql.Timestamp";
	/**
	 * Description of the Field
	 */
	public final static String JAVA_OBJECT = "java.lang.Object";

	private static HashMap javaKeyedMap = null;
	private static HashMap jdbcKeyedMap = null;

	/**
	 * Gets the JdbcType attribute of the Jdbc2JavaTypeMapper class
	 * 
	 * @param javaType
	 *            Description of Parameter
	 * @return The JdbcType value
	 */
	public static int getJdbcType(String javaType) {
		return ((Integer) javaKeyedMap.get(javaType)).intValue();
	}

	/**
	 * Gets the JavaType attribute of the Jdbc2JavaTypeMapper class
	 * 
	 * @param jdbcType
	 *            Description of Parameter
	 * @return The JavaType value
	 */
	public static String getJavaType(int jdbcType) {
		String result = (String) jdbcKeyedMap.get(Integer.valueOf(jdbcType));

		if ((result == null) || (result.equals("")))
			result = JAVA_OBJECT;

		return result;
	}

	static {
		javaKeyedMap = new HashMap();
		jdbcKeyedMap = new HashMap();

		javaKeyedMap.put(JAVA_BOOLEAN, Types.BIT);
		javaKeyedMap.put(JAVA_BYTE, Types.NUMERIC);
		javaKeyedMap.put(JAVA_SHORT, Types.NUMERIC);
		javaKeyedMap.put(JAVA_INTEGER, Types.INTEGER);
		javaKeyedMap.put(JAVA_LONG, Types.BIGINT);
		javaKeyedMap.put(JAVA_FLOAT, Types.REAL);
		javaKeyedMap.put(JAVA_BIGDECIMAL, Types.DECIMAL);
		javaKeyedMap.put(JAVA_DOUBLE, Types.DOUBLE);
		javaKeyedMap.put(JAVA_CHARACTER, Types.CHAR);
		javaKeyedMap.put(JAVA_STRING, Types.VARCHAR);
		javaKeyedMap.put(JAVA_DATE, Types.DATE);
		javaKeyedMap.put(JAVA_TIME, Types.TIME);
		javaKeyedMap.put(JAVA_TIMESTAMP, Types.TIMESTAMP);
		javaKeyedMap.put(JAVA_OBJECT, Types.JAVA_OBJECT);
		javaKeyedMap.put(JAVA_STRING, Types.LONGVARCHAR);
		javaKeyedMap.put(JAVA_INTEGER, Types.SMALLINT);

		jdbcKeyedMap.put(Types.BIT, JAVA_BOOLEAN);
		jdbcKeyedMap.put(Types.NUMERIC, JAVA_BYTE);
		jdbcKeyedMap.put(Types.NUMERIC, JAVA_SHORT);
		jdbcKeyedMap.put(Types.INTEGER, JAVA_INTEGER);
		jdbcKeyedMap.put(Types.BIGINT, JAVA_LONG);
		jdbcKeyedMap.put(Types.REAL, JAVA_FLOAT);
		jdbcKeyedMap.put(Types.DECIMAL, JAVA_BIGDECIMAL);
		jdbcKeyedMap.put(Types.DOUBLE, JAVA_DOUBLE);
		jdbcKeyedMap.put(Types.CHAR, JAVA_STRING); // NOTE: Character > String
		jdbcKeyedMap.put(Types.VARCHAR, JAVA_STRING);
		jdbcKeyedMap.put(Types.DATE, JAVA_DATE);
		jdbcKeyedMap.put(Types.TIME, JAVA_TIME);
		jdbcKeyedMap.put(Types.TIMESTAMP, JAVA_TIMESTAMP);
		jdbcKeyedMap.put(Types.JAVA_OBJECT, JAVA_OBJECT);
		jdbcKeyedMap.put(Types.LONGVARCHAR, JAVA_STRING);
		jdbcKeyedMap.put(Types.SMALLINT, JAVA_INTEGER);

	}

}
