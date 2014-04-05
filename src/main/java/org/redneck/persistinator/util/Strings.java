package org.redneck.persistinator.util;

import java.lang.reflect.Method;

/**
 * @author ran488
 * 
 */
public class Strings {

	/** Override toString() */
	public static String toStringGenerator(Object o) {
		StringBuffer sb = new StringBuffer();
		Object noArgs[] = {};

		Method[] f = o.getClass().getMethods();
		// SimpleLogger.log(f.length + " methods");
		for (int ii = 0; ii < f.length; ii++) {
			Method m = f[ii];

			if (m.getName().startsWith("get")) {
				if (ii > 0)
					sb.append(" , ");

				sb.append(m.getName());
				sb.append("()=");
				try {
					sb.append(m.invoke(o, noArgs));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return sb.toString();
	}

	/**
	 * return the field name for a given field F. Basically take an all caps
	 * with underscore ORACLE name and turn it into a Java friendly field name.
	 * 
	 * e.g. AUDIT_VIEW = auditView TELNO = telno TELEPHONE_NUMBER_AUDIT_TABLE =
	 * telephoneNumberAuditTable
	 * 
	 * @param f
	 * @return
	 */
	public static String getJavaFieldName(String f) {
		f = Strings.getJavaProperFieldName(f);
		if (f.equals(""))
			return "";

		f = f.substring(0, 1).toLowerCase() + f.substring(1);
		return f;
	}

	/**
	 * Same as getJavaFieldName but first letter is also capitalized, so you can
	 * use it to build get and set methods.
	 * 
	 * @param f
	 * @return
	 */
	public static String getJavaProperFieldName(String f) {
		if ((f == null) || (f.trim().equals("")))
			return "";

		f = org.apache.commons.lang.WordUtils.capitalizeFully(f, new char[] {
				'_', '.', ' ' });
		f = f.replaceAll("_", "");
		return f;
	}
}
