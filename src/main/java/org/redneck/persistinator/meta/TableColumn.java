/**
 * 
 */
package org.redneck.persistinator.meta;

import org.redneck.persistinator.util.Strings;

/**
 * @author ran488
 * 
 */
public class TableColumn extends AbstractColumn implements java.io.Serializable {
	private static final long serialVersionUID = -5996491840738114719L;
	private int colSize;
	private int decimalDigits;
	private int radix;
	private int ordinalPosition;
	private int charOctetLen;
	private String colDefault;

	public TableColumn() {
		super();
	}

	/**
	 * @param colName
	 * @param colType
	 * @param dataType
	 * @param typeName
	 * @param colSize
	 * @param decimalDigits
	 * @param radix
	 * @param ordinalPosition
	 * @param charOctetLen
	 * @param nullable
	 * @param remarks
	 * @param colDefault
	 */
	public TableColumn(String colName, int dataType, String typeName,
			int colSize, int decimalDigits, int radix, int ordinalPosition,
			int charOctetLen, short nullable, String remarks, String colDefault) {
		super();
		this.colName = colName;
		this.dataType = dataType;
		this.typeName = typeName;
		this.colSize = colSize;
		this.decimalDigits = decimalDigits;
		this.radix = radix;
		this.ordinalPosition = ordinalPosition;
		this.charOctetLen = charOctetLen;
		this.nullable = nullable;
		this.remarks = remarks;
		this.colDefault = colDefault;
	}

	/**
	 * @return the charOctetLen
	 */
	public int getCharOctetLen() {
		return charOctetLen;
	}

	/**
	 * @param charOctetLen
	 *            the charOctetLen to set
	 */
	public void setCharOctetLen(int charOctetLen) {
		this.charOctetLen = charOctetLen;
	}

	/**
	 * @return the colDefault
	 */
	public String getColDefault() {
		return colDefault;
	}

	/**
	 * @param colDefault
	 *            the colDefault to set
	 */
	public void setColDefault(String colDefault) {
		this.colDefault = colDefault;
	}

	/**
	 * @return the colSize
	 */
	public int getColSize() {
		return colSize;
	}

	/**
	 * @param colSize
	 *            the colSize to set
	 */
	public void setColSize(int colSize) {
		this.colSize = colSize;
	}

	/**
	 * @return the decimalDigits
	 */
	public int getDecimalDigits() {
		return decimalDigits;
	}

	/**
	 * @param decimalDigits
	 *            the decimalDigits to set
	 */
	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	/**
	 * @return the ordinalPosition
	 */
	public int getOrdinalPosition() {
		return ordinalPosition;
	}

	/**
	 * @param ordinalPosition
	 *            the ordinalPosition to set
	 */
	public void setOrdinalPosition(int ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	/**
	 * @return the radix
	 */
	public int getRadix() {
		return radix;
	}

	/**
	 * @param radix
	 *            the radix to set
	 */
	public void setRadix(int radix) {
		this.radix = radix;
	}

}
