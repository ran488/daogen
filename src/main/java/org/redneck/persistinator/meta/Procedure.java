/**
 * 
 */
package org.redneck.persistinator.meta;

import org.redneck.persistinator.util.Strings;

/**
 * FIXME: in/out params, and stuff like that?
 * @author ran488
 *
 */
public class Procedure extends AbstractTable implements java.io.Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2651403594582023949L;
    private String procSchema;
    private String procName;
    private String procRemarks;
    private short procType;
    
    private java.util.List<ProcedureColumn> procColumns;
    
    /**
     * 
     */
    public Procedure()
    {
       super();
       this.setProcedure(true);
    }

    /**
     * @param procSchema
     * @param procName
     * @param procRemarks
     * @param procType
     */
    public Procedure(String procSchema, String procName, String procRemarks, short procType)
    {
        this();
        this.procSchema = procSchema;
        this.procName = procName;
        this.procRemarks = procRemarks;
        this.procType = procType;
    }

    /**
     * @return the procColumns
     */
    public java.util.List<ProcedureColumn> getProcColumns()
    {
        return procColumns;
    }

    /**
     * @param procColumns the procColumns to set
     */
    public void setProcColumns(java.util.List<ProcedureColumn> procColumns)
    {
        this.procColumns = procColumns;
    }

    /**
     * @return the procName
     */
    public String getProcName()
    {
        return procName;
    }

    /**
     * @param procName the procName to set
     */
    public void setProcName(String procName)
    {
        this.procName = procName;
    }

    /**
     * @return the procRemarks
     */
    public String getProcRemarks()
    {
        return procRemarks;
    }

    /**
     * @param procRemarks the procRemarks to set
     */
    public void setProcRemarks(String procRemarks)
    {
        this.procRemarks = procRemarks;
    }

    /**
     * @return the procSchema
     */
    public String getProcSchema()
    {
        return procSchema;
    }

    /**
     * @param procSchema the procSchema to set
     */
    public void setProcSchema(String procSchema)
    {
        this.procSchema = procSchema;
    }

    /**
     * @return the procType -- does it return value or not? procedureNoResult, procedureReturnsResult 
     */
    public short getProcType()
    {
        return procType;
    }

    /**
     * @param procType the procType to set
     */
    public void setProcType(short procType)
    {
        this.procType = procType;
    }

    /** Override toString() */
    public String toString()
    {
        //StringBuffer sb = new StringBuffer("Procedure: ");
        //sb.append(Strings.toStringGenerator(this));
        //return sb.toString();
        return this.getProcSchema() + "." + this.getProcName();
    }
    
    /**
     * @return the jFieldName
     */
    public String getJFieldName()
    {
        return Strings.getJavaFieldName(this.getProcName());
    }

    /**
     * @return the jProperFieldName
     */
    public String getJProperFieldName()
    {
        return Strings.getJavaProperFieldName(this.getProcName());
    }
    
    
    public java.util.List<ProcedureColumn> getInParams()
    {
        java.util.List<ProcedureColumn> results = new java.util.ArrayList<ProcedureColumn>();
        
        for (ProcedureColumn col : this.procColumns)
        {
            //Java API is silly here, COLUMN_TYPE comes back as a short, but the values constants are int's
            if (col.getColType() == java.sql.DatabaseMetaData.procedureColumnIn)
            {
                results.add(col);
            }   
        }
        
        return results;
    }
    
    public java.util.List<ProcedureColumn> getOutParams()
    {
        java.util.List<ProcedureColumn> results = new java.util.ArrayList<ProcedureColumn>();
        
        for (ProcedureColumn col : this.procColumns)
        {
            //Java API is silly here, COLUMN_TYPE comes back as a short, but the values constants are int's
            if (col.getColType() == java.sql.DatabaseMetaData.procedureColumnOut)
            {
                results.add(col);
            }   
        }
        
        return results;
    }
    
    public java.util.List<ProcedureColumn> getInOutParams()
    {
        java.util.List<ProcedureColumn> results = new java.util.ArrayList<ProcedureColumn>();
        
        for (ProcedureColumn col : this.procColumns)
        {
            //Java API is silly here, COLUMN_TYPE comes back as a short, but the values constants are int's
            if (col.getColType() == java.sql.DatabaseMetaData.procedureColumnInOut)
            {
                results.add(col);
            }   
        }
        
        return results;
    }

}
