/*
 * AbstractTable.java
 *
 * Created on December 19, 2006, 1:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.redneck.persistinator.meta;

import org.redneck.persistinator.meta.userdef.CustomMethod;

/**
 *
 * @author ran488
 */
public class AbstractTable implements java.io.Serializable
{

    private static final long serialVersionUID = -1561093020035118405L;
    
    private boolean procedure = false;
    private boolean table = false;
    
    private java.util.List<CustomMethod> customMethods = null;
    
    /** Creates a new instance of AbstractTable */
    public AbstractTable()
    {
        super();
        //init so it can be used safely from gui even if empty
        this.setCustomMethods(new java.util.ArrayList<CustomMethod>());
    }

    public boolean isProcedure()
    {
        return procedure;
    }

    public void setProcedure(boolean procedure)
    {
        this.procedure = procedure;
    }

    public boolean isTable()
    {
        return table;
    }

    public void setTable(boolean table)
    {
        this.table = table;
    }

    /** add a new method to the internal list */
    public boolean addCustomMethod(CustomMethod m)
    {
        return this.customMethods.add(m);
    }
    
    /** add a new method to the internal list */
    public boolean removeCustomMethod(CustomMethod m)
    {
        return this.customMethods.remove(m);
    }
    
    /**
     * @return the customMethods
     */
    public java.util.List<CustomMethod> getCustomMethods()
    {
        return customMethods;
    }

    public void setCustomMethods(java.util.List<CustomMethod> customMethods) {
        this.customMethods = customMethods;
    }
    
}
