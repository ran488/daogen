package org.redneck.persistinator.gui.models;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import org.redneck.persistinator.meta.*;

/**
 * 
 * @author ran488
 */
public class DbTreeModel implements javax.swing.tree.TreeModel {
	private java.util.List<TreeModelListener> listeners;

	String jdbcUrl = null;
	Database db = null;

	/** Creates a new instance of DbTreeModel */
	public DbTreeModel(String jdbcUrl, Database db) {
		this.jdbcUrl = jdbcUrl;
		this.db = db;
	}

	public Object getRoot() {
		return db;
	}

	public Object getChild(Object parent, int index) {
		Object ret = null;

		if (parent instanceof Database) {
			switch (index) {
			case 0:
				ret = "Tables";
				break;
			case 1:
				ret = "Procedures";
				break;
			}
		} else if (parent.equals("Tables")) {
			ret = db.getTables().get(index);
		} else if (parent.equals("Procedures")) {
			ret = db.getProcedures().get(index);
		} else if (parent instanceof Table) {
			ret = ((Table) parent).getColumns().get(index);
		} else if (parent instanceof Procedure) {
			ret = ((Procedure) parent).getProcColumns().get(index);
		}

		return ret;
	}

	public int getChildCount(Object parent) {
		int ret = 0;

		if (parent instanceof Database) {
			ret = 2;
		} else if (parent.equals("Tables")) {
			ret = db.getTables().size();
		} else if (parent.equals("Procedures")) {
			ret = db.getProcedures().size();
		} else if (parent instanceof Table) {
			ret = ((Table) parent).getColumns().size();
		} else if (parent instanceof Procedure) {
			ret = ((Procedure) parent).getProcColumns().size();
		}

		return ret;
	}

	public boolean isLeaf(Object node) {
		boolean ret = false;

		if (node instanceof AbstractColumn)
			ret = true;

		return ret;
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	public int getIndexOfChild(Object parent, Object child) {
		int ret = 0;

		if (parent instanceof Database) {
			if (child.equals("Tables"))
				ret = 0;
			else
				ret = 1;
		} else if (parent.equals("Tables")) {
			ret = db.getTables().indexOf(child);
		} else if (parent.equals("Procedures")) {
			ret = db.getProcedures().indexOf(child);
		} else if (parent instanceof Table) {
			ret = ((Table) parent).getColumns().indexOf(child);
		} else if (parent instanceof Procedure) {
			ret = ((Procedure) parent).getProcColumns().indexOf(child);
		}

		return ret;

	}

	public void addTreeModelListener(TreeModelListener l) {
		if (listeners == null)
			listeners = new java.util.ArrayList();

		listeners.add(l);
	}

	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(l);
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
}
