/*
 * ParamTypeCellEditor.java
 *
 * Created on December 19, 2006, 11:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.redneck.persistinator.gui.models;

import java.awt.Component;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;

/**
 * to provide a selection list for editing the java-type cell
 * @author ran488
 */
public class ParamTypeCellEditor implements javax.swing.table.TableCellEditor
{
    private Object[] selections = {
        "",
        "BigDecimal",
        "Boolean",
        "Byte",
        "Date",
        "Double",
        "Integer",
        "Float",
        "Long",
        "Object", 
        "Short", 
        "String",
        "Time",
        "Timestamp"
    };
    
    private JComboBox cellEditor;
    
    private List<CellEditorListener> cellEditorListeners = null;
            
    /** Creates a new instance of ParamTypeCellEditor */
    public ParamTypeCellEditor()
    {
        super();
        cellEditor = new JComboBox(selections);
        cellEditor.setEditable(false);
        
        cellEditorListeners = new Vector<CellEditorListener>();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
        return new javax.swing.JComboBox(selections);
    }

    public Object getCellEditorValue()
    {
        return cellEditor.getSelectedItem();
    }

    public boolean isCellEditable(EventObject anEvent)
    {
        return true;
    }

    public boolean shouldSelectCell(EventObject anEvent)
    {
        return true;
    }

    public boolean stopCellEditing()
    {
        return true;
    }

    public void cancelCellEditing()
    {
        //do nothing, eh?
    }

    public void addCellEditorListener(CellEditorListener l)
    {
        cellEditorListeners.add(l);
    }

    public void removeCellEditorListener(CellEditorListener l)
    {
        cellEditorListeners.remove(l);
    }
    
}
