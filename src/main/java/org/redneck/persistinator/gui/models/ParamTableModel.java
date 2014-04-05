package org.redneck.persistinator.gui.models;

import org.redneck.persistinator.meta.AbstractTable;
import org.redneck.persistinator.meta.userdef.CustomMethod;
import org.redneck.persistinator.meta.userdef.CustomMethodParameter;

/**
 * TODO: need a thread like in CD demo I did to see if updates need to be addressed/repainted?
 * @author ran488
 */
public class ParamTableModel extends javax.swing.table.AbstractTableModel {
    private final static int COL_COUNT = 2;
    private final static String[] COL_NAMES = { "Parameter", "Type" };
    private AbstractTable table;
    private CustomMethod method;
    
    /** Creates a new instance of ParamTableModel */
    public ParamTableModel(AbstractTable tableOrProc, CustomMethod method) {
        super();
        this.table = tableOrProc;
        this.method = method;
    }
    
    /** return header column names */
    public String getColumnName(int col) {
        return COL_NAMES[col];
    }
    
    
    public int getRowCount() {
        return 1;//always 1 more so user can add another
    }
    
    public int getColumnCount() {
        return COL_COUNT;
    }
    
    /** all cells are editable */
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "";
    }
}
