/*
 * ProjectInfo.java
 *
 * Created on December 5, 2006, 12:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.redneck.persistinator.gui;

import org.redneck.persistinator.meta.Database;

/**
 *
 * @author ran488
 */
public class ProjectInfo implements java.io.Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -1809862255522860513L;
    
    private String projectName;
    private String projectFileName;
    private String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
    private String jdbcUrl;
    private String userName;
    private String password;
    private String templateDir;
    private String basePackage;
    private String rootOutputDir;
    private String schemaFilter;
    
    private boolean described = false;
    
    
    //once database is described save it all for later
    private Database databaseMetaData = null;
    
    /** Creates a new instance of ProjectInfo */
    public ProjectInfo()
    {
        super();
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectFileName()
    {
        return projectFileName;
    }

    public void setProjectFileName(String projectFileName)
    {
        this.projectFileName = projectFileName;
    }

    public String getJdbcDriver()
    {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver)
    {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl()
    {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl)
    {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTemplateDir()
    {
        return templateDir;
    }

    public void setTemplateDir(String templateDir)
    {
        this.templateDir = templateDir;
    }

    public String getBasePackage()
    {
        return basePackage;
    }

    public void setBasePackage(String basePackage)
    {
        this.basePackage = basePackage;
    }

    public String getRootOutputDir()
    {
        return rootOutputDir;
    }

    public void setRootOutputDir(String rootOutputDir)
    {
        this.rootOutputDir = rootOutputDir;
    }

    /**
     * @return the databaseMetaData
     */
    public Database getDatabaseMetaData()
    {
        return databaseMetaData;
    }

    /**
     * @param databaseMetaData the databaseMetaData to set
     */
    public void setDatabaseMetaData(
            Database databaseMetaData)
    {
        this.databaseMetaData = databaseMetaData;
    }

    public String getSchemaFilter()
    {
        return schemaFilter;
    }

    public void setSchemaFilter(String schemaFilter)
    {
        this.schemaFilter = schemaFilter;
    }

    public boolean isDescribed()
    {
        return described;
    }

    public void setDescribed(boolean described)
    {
        this.described = described;
    }
    
}
