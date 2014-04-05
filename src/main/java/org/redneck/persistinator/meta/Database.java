/**
 * 
 */
package org.redneck.persistinator.meta;

import org.redneck.persistinator.util.Strings;

/**
 * @author ran488
 *
 */
public class Database implements java.io.Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 9020411690578444361L;
    private String dbProduct;
    private String dbProductVersion;
    private String catalogTerm;
    private String catalogSeparator;
    private java.util.List<String> catalogs;
    private java.util.List<String> schemas;
    
    private java.util.List<Table> tables;
    private java.util.List<Procedure> procedures;
    

    
    /**
     * 
     */
    public Database()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the catalogs
     */
    public java.util.List<String> getCatalogs()
    {
        return catalogs;
    }

    /**
     * @param catalogs the catalogs to set
     */
    public void setCatalogs(java.util.List<String> catalogs)
    {
        this.catalogs = catalogs;
    }

    /**
     * @return the catalogSeparator
     */
    public String getCatalogSeparator()
    {
        return catalogSeparator;
    }

    /**
     * @param catalogSeparator the catalogSeparator to set
     */
    public void setCatalogSeparator(String catalogSeparator)
    {
        this.catalogSeparator = catalogSeparator;
    }

    /**
     * @return the catalogTerm
     */
    public String getCatalogTerm()
    {
        return catalogTerm;
    }

    /**
     * @param catalogTerm the catalogTerm to set
     */
    public void setCatalogTerm(String catalogTerm)
    {
        this.catalogTerm = catalogTerm;
    }

    /**
     * @return the dbProduct
     */
    public String getDbProduct()
    {
        return dbProduct;
    }

    /**
     * @param dbProduct the dbProduct to set
     */
    public void setDbProduct(String dbProduct)
    {
        this.dbProduct = dbProduct;
    }

    /**
     * @return the dbProductVersion
     */
    public String getDbProductVersion()
    {
        return dbProductVersion;
    }

    /**
     * @param dbProductVersion the dbProductVersion to set
     */
    public void setDbProductVersion(String dbProductVersion)
    {
        this.dbProductVersion = dbProductVersion;
    }

    /**
     * @return the procedures
     */
    public java.util.List<Procedure> getProcedures()
    {
        return procedures;
    }

    /**
     * @param procedures the procedures to set
     */
    public void setProcedures(java.util.List<Procedure> procedures)
    {
        this.procedures = procedures;
    }

    /**
     * @return the schemas
     */
    public java.util.List<String> getSchemas()
    {
        return schemas;
    }

    /**
     * @param schemas the schemas to set
     */
    public void setSchemas(java.util.List<String> schemas)
    {
        this.schemas = schemas;
    }

    /**
     * @return the tables
     */
    public java.util.List<Table> getTables()
    {
        return tables;
    }

    /**
     * @param tables the tables to set
     */
    public void setTables(java.util.List<Table> tables)
    {
        this.tables = tables;
    }

    /** Override toString() */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(this.dbProduct).append(" ");
        sb.append(this.dbProductVersion).append(" (");
        sb.append(this.tables.size()).append(" tables, ");
        sb.append(this.procedures.size()).append(" procedures)");
        
        //sb.append(Strings.toStringGenerator(this));
        //return sb.toString();
        
        return sb.toString();
    }

    
}
