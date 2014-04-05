package org.redneck.persistinator.meta;

import org.redneck.persistinator.typemaps.Jdbc2JavaTypeMapper;
import org.redneck.persistinator.util.Strings;

/**
 * @author ran488
 * 
 */
public abstract class AbstractColumn implements java.io.Serializable {
	protected String colName;
	protected int dataType;
	protected String typeName;
	protected short nullable;
	protected String remarks;

	/**
	 * @return the colName
	 */
	public String getColName() {
		return colName;
	}

	/**
	 * @param colName
	 *            the colName to set
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}

	/**
     * 
     */
	public AbstractColumn() {
		super();
	}

	/**
	 * @return the jFieldName
	 */
	public String getJFieldName() {
		return Strings.getJavaFieldName(this.getColName());
	}

	/**
	 * @return the jProperFieldName
	 */
	public String getJProperFieldName() {
		return Strings.getJavaProperFieldName(this.getColName());
	}

	public String getJavaType() {
		return Jdbc2JavaTypeMapper.getJavaType(this.getDataType());
	}

	/**
	 * This is probably a big hack, but for now it seems to work. Basically take
	 * java.lang.String and make it String, so in DAO I can build out Velocity
	 * template as something like ps.set${field.psMethodNameFrag} ( ... ) to get
	 * ps.setString(...)
	 * 
	 * There may be types this does not work with. As I find them I will hack in
	 * some duct tape fixits in here.
	 * 
	 * @return
	 */
	public String getPsMethodNameFrag() {
		String fullType = this.getJavaType();
		if ((fullType == null) || (fullType.trim().equals("")))
			return "";

		if (fullType == "java.lang.Integer")
			return "Int";
		else
			return fullType.substring(fullType.lastIndexOf('.') + 1);
	}

	/**
	 * @return the dataType
	 */
	public int getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the nullable
	 */
	public short getNullable() {
		return nullable;
	}

	/**
	 * @param nullable
	 *            the nullable to set
	 */
	public void setNullable(short nullable) {
		this.nullable = nullable;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName
	 *            the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String toString() {
		return this.getColName() + "(" + this.getTypeName() + " -  "
				+ this.getDataType() + ")";
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
		result = prime * result + ((colName == null) ? 0 : colName.hashCode());
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
		if (!(obj instanceof AbstractColumn)) {
			return false;
		}
		AbstractColumn other = (AbstractColumn) obj;
		if (colName == null) {
			if (other.colName != null) {
				return false;
			}
		} else if (!colName.equals(other.colName)) {
			return false;
		}
		return true;
	}
}
