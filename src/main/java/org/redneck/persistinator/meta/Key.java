package org.redneck.persistinator.meta;

import org.redneck.persistinator.util.Strings;

/**
 * @author ran488
 * 
 */
public class Key extends TableColumn implements java.io.Serializable {

	private static final long serialVersionUID = -7146107287528064580L;
	private String pkTableSchema;
	private String pkTableName;
	private String pkColumnName;
	private String fkTableSchema;
	private String fkTableName;
	private String fkColumnName;
	private String fkName;
	private String pkName;
	private short updateRule;
	private short deleteRule;

	/**
	 * @param pkTableSchema
	 * @param pkTableName
	 * @param pkColumnName
	 * @param fkTableSchema
	 * @param fkTableName
	 * @param fkColumnName
	 * @param fkName
	 * @param pkName
	 * @param updateRule
	 * @param deleteRule
	 */
	public Key(String pkTableSchema, String pkTableName, String pkColumnName,
			String fkTableSchema, String fkTableName, String fkColumnName,
			String fkName, String pkName, short updateRule, short deleteRule) {
		super();
		this.pkTableSchema = pkTableSchema;
		this.pkTableName = pkTableName;
		this.pkColumnName = pkColumnName;
		this.fkTableSchema = fkTableSchema;
		this.fkTableName = fkTableName;
		this.fkColumnName = fkColumnName;
		this.fkName = fkName;
		this.pkName = pkName;
		this.updateRule = updateRule;
		this.deleteRule = deleteRule;
	}

	/**
     * 
     */
	public Key() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the deleteRule
	 */
	public short getDeleteRule() {
		return deleteRule;
	}

	/**
	 * @param deleteRule
	 *            the deleteRule to set
	 */
	public void setDeleteRule(short deleteRule) {
		this.deleteRule = deleteRule;
	}

	/**
	 * @return the fkColumnName
	 */
	public String getFkColumnName() {
		return fkColumnName;
	}

	/**
	 * @param fkColumnName
	 *            the fkColumnName to set
	 */
	public void setFkColumnName(String fkColumnName) {
		this.fkColumnName = fkColumnName;
	}

	/**
	 * @return the fkName
	 */
	public String getFkName() {
		return fkName;
	}

	/**
	 * @param fkName
	 *            the fkName to set
	 */
	public void setFkName(String fkName) {
		this.fkName = fkName;
	}

	/**
	 * @return the fkTableName
	 */
	public String getFkTableName() {
		return fkTableName;
	}

	/**
	 * @param fkTableName
	 *            the fkTableName to set
	 */
	public void setFkTableName(String fkTableName) {
		this.fkTableName = fkTableName;
	}

	/**
	 * @return the fkTableSchema
	 */
	public String getFkTableSchema() {
		return fkTableSchema;
	}

	/**
	 * @param fkTableSchema
	 *            the fkTableSchema to set
	 */
	public void setFkTableSchema(String fkTableSchema) {
		this.fkTableSchema = fkTableSchema;
	}

	/**
	 * @return the pkColumnName
	 */
	public String getPkColumnName() {
		return pkColumnName;
	}

	/**
	 * @param pkColumnName
	 *            the pkColumnName to set
	 */
	public void setPkColumnName(String pkColumnName) {
		this.pkColumnName = pkColumnName;
	}

	/**
	 * @return the pkName
	 */
	public String getPkName() {
		return pkName;
	}

	/**
	 * @param pkName
	 *            the pkName to set
	 */
	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	/**
	 * @return the pkTableName
	 */
	public String getPkTableName() {
		return pkTableName;
	}

	/**
	 * @param pkTableName
	 *            the pkTableName to set
	 */
	public void setPkTableName(String pkTableName) {
		this.pkTableName = pkTableName;
	}

	/**
	 * @return the pkTableSchema
	 */
	public String getPkTableSchema() {
		return pkTableSchema;
	}

	/**
	 * @param pkTableSchema
	 *            the pkTableSchema to set
	 */
	public void setPkTableSchema(String pkTableSchema) {
		this.pkTableSchema = pkTableSchema;
	}

	/**
	 * @return the updateRule
	 */
	public short getUpdateRule() {
		return updateRule;
	}

	/**
	 * @param updateRule
	 *            the updateRule to set
	 */
	public void setUpdateRule(short updateRule) {
		this.updateRule = updateRule;
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

	/**
	 * @return the jFieldName
	 */
	public String getFkJFieldName() {
		return Strings.getJavaFieldName(this.getFkColumnName());
	}

	/**
	 * @return the jProperFieldName
	 */
	public String getFkJProperFieldName() {
		return Strings.getJavaProperFieldName(this.getFkColumnName());
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
