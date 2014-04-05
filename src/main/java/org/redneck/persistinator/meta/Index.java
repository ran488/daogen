/*
 * Index.java
 *
 * Created on June 11, 2008, 3:26 PM
 *
 */

package org.redneck.persistinator.meta;

import org.redneck.persistinator.util.Strings;

/**
 * 
 * @author ran488
 */
public class Index extends TableColumn implements java.io.Serializable {

	private static final long serialVersionUID = 6534235898876724396L;

	private String pkTableSchema;
	private String pkTableName;
	private boolean nonUnique;
	private String idxQualifier;
	private String idxName;
	private short idxType;
	private short ordPosn;
	private String pkColumnName;
	private String filterCond;

	/** Creates a new instance of Index */
	public Index() {
		super();
	}

	public String getPkTableSchema() {
		return pkTableSchema;
	}

	public void setPkTableSchema(String pkTableSchema) {
		this.pkTableSchema = pkTableSchema;
	}

	public String getPkTableName() {
		return pkTableName;
	}

	public void setPkTableName(String pkTableName) {
		this.pkTableName = pkTableName;
	}

	public boolean isNonUnique() {
		return nonUnique;
	}

	public void setNonUnique(boolean nonUnique) {
		this.nonUnique = nonUnique;
	}

	public String getIdxQualifier() {
		return idxQualifier;
	}

	public void setIdxQualifier(String idxQualifier) {
		this.idxQualifier = idxQualifier;
	}

	public String getIdxName() {
		return idxName;
	}

	public void setIdxName(String idxName) {
		this.idxName = idxName;
	}

	public short getIdxType() {
		return idxType;
	}

	public void setIdxType(short idxType) {
		this.idxType = idxType;
	}

	public short getOrdPosn() {
		return ordPosn;
	}

	public void setOrdPosn(short ordPosn) {
		this.ordPosn = ordPosn;
	}

	public String getPkColumnName() {
		return pkColumnName;
	}

	public void setPkColumnName(String pkColumnName) {
		this.pkColumnName = pkColumnName;
	}

	public String getFilterCond() {
		return filterCond;
	}

	public void setFilterCond(String filterCond) {
		this.filterCond = filterCond;
	}

	/**
	 * @return the jFieldName
	 */
	public String getPkJFieldName() {
		return Strings.getJavaFieldName(this.getPkColumnName());
	}

	/**
	 * @return the jProperFieldName
	 */
	public String getPkJProperFieldName() {
		return Strings.getJavaProperFieldName(this.getPkColumnName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.redneck.persistinator.meta.AbstractColumn#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.redneck.persistinator.meta.AbstractColumn#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
