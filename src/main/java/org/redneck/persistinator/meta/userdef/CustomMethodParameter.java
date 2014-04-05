/**
 * 
 */
package org.redneck.persistinator.meta.userdef;

import java.io.Serializable;

/**
 * @author ran488
 * 
 */
public class CustomMethodParameter implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -288060357084358666L;

    /** type of parameter, e.g. String, BigDecimal, Timestamp, Object, etc. */
    private String parmType;

    /** Name of parameter, will also be used in WHERE clause */
    private String parmName;

    /**
     * 
     */
    public CustomMethodParameter()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param parmType
     * @param parmName
     */
    public CustomMethodParameter(String parmType, String parmName)
    {
        super();
        this.parmType = parmType;
        this.parmName = parmName;
    }

    /**
     * @return the parmName
     */
    public String getParmName()
    {
        return parmName;
    }

    /**
     * @param parmName
     *            the parmName to set
     */
    public void setParmName(String parmName)
    {
        this.parmName = parmName;
    }

    /**
     * @return the parmType
     */
    public String getParmType()
    {
        return parmType;
    }

    /**
     * @param parmType
     *            the parmType to set
     */
    public void setParmType(String parmType)
    {
        this.parmType = parmType;
    }

}
