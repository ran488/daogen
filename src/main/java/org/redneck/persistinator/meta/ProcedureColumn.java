/**
 * 
 */
package org.redneck.persistinator.meta;

import org.redneck.persistinator.util.Strings;

/**
 * @author ran488
 *
 */
public class ProcedureColumn extends AbstractColumn implements java.io.Serializable
{
   
    /**
     * 
     */
    private static final long serialVersionUID = 3494720862926257801L;
    short colType;
    int precision;
    short scale;
    short radix;
    /**
     * 
     */
    public ProcedureColumn()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param colName
     * @param colType
     * @param dataType
     * @param typeName
     * @param precision
     * @param scale
     * @param radix
     * @param nullable
     * @param remarks
     */
    public ProcedureColumn(String colName, short colType, int dataType, String typeName, int precision, short scale, short radix, short nullable, String remarks)
    {
        super();
        this.colName = colName;
        this.colType = colType;
        this.dataType = dataType;
        this.typeName = typeName;
        this.precision = precision;
        this.scale = scale;
        this.radix = radix;
        this.nullable = nullable;
        this.remarks = remarks;
    }

    /**
     * @return the colType
     */
    public short getColType()
    {
        return colType;
    }

    /**
     * @param colType the colType to set
     */
    public void setColType(short colType)
    {
        this.colType = colType;
    }

    /**
     * @return the precision
     */
    public int getPrecision()
    {
        return precision;
    }

    /**
     * @param precision the precision to set
     */
    public void setPrecision(int precision)
    {
        this.precision = precision;
    }

    /**
     * @return the radix
     */
    public short getRadix()
    {
        return radix;
    }

    /**
     * @param radix the radix to set
     */
    public void setRadix(short radix)
    {
        this.radix = radix;
    }

    /**
     * @return the scale
     */
    public short getScale()
    {
        return scale;
    }

    /**
     * @param scale the scale to set
     */
    public void setScale(short scale)
    {
        this.scale = scale;
    }

//    /** Override toString() */
//    public String toString()
//    {
//        StringBuffer sb = new StringBuffer("ProcedureColumn: ");
//        sb.append(Strings.toStringGenerator(this));
//        return sb.toString();
//    }

}
