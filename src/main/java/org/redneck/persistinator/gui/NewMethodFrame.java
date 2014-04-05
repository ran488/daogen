/*
 * NewMethodFrame.java
 *
 * Created on December 19, 2006, 4:39 PM
 */

package org.redneck.persistinator.gui;

import java.awt.Component;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.redneck.persistinator.meta.AbstractTable;
import org.redneck.persistinator.meta.userdef.CustomMethod;

/**
 *
 * @author  ran488
 */
public class NewMethodFrame extends javax.swing.JFrame {
    AbstractTable table = null;
    
    /** Creates new form NewMethodFrame */
    public NewMethodFrame(AbstractTable o) {
        table = o;
        initComponents();
        methodsList.addListSelectionListener(
                new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    
                    if (methodsList.getSelectedIndex() == -1) {
                        editButton.setEnabled(false);
                        removeButton.setEnabled(false);
                    } else {
                        editButton.setEnabled(true);
                        removeButton.setEnabled(true);
                    }
                }
            }
        }
        );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        methodsList = new javax.swing.JList();
        methodsList.setListData(getAllCustomMethods());

        jPanel1 = new javax.swing.JPanel();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setTitle("Custom Methods");
        setAlwaysOnTop(true);
        methodsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(methodsList);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        removeButton.setMnemonic('R');
        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jPanel1.add(removeButton);

        editButton.setMnemonic('E');
        editButton.setText("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jPanel1.add(editButton);

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        jPanel1.add(newButton);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jPanel1.add(closeButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MethodEditorFrame mef = new MethodEditorFrame(NewMethodFrame.this,table);
                mef.setVisible(true);
            }
        });
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        //CustomMethod selMethod = (CustomMethod)this.methodsList.getSelectedValue();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MethodEditorFrame mef = new MethodEditorFrame(NewMethodFrame.this,table);
                mef.setCustomMethod((CustomMethod)methodsList.getSelectedValue());
                mef.setVisible(true);
            }
        });
        
    }//GEN-LAST:event_editButtonActionPerformed
    
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Object selMethod = this.methodsList.getSelectedValue();
        table.getCustomMethods().remove(selMethod);
        methodsList.setListData(getAllCustomMethods());
    }//GEN-LAST:event_removeButtonActionPerformed
    
    private Object[] getAllCustomMethods() {
        //TODO implement by getting them off table or proc object
        //table.getCustomMethods().add(new CustomMethod("findBySearchCriteria"));
        //table.getCustomMethods().add(new CustomMethod("findByDateRange"));
        //table.getCustomMethods().add(new CustomMethod("findBySomethingElse"));
        
        return table.getCustomMethods().toArray();
    }
    
    public void refreshView()
    {
        methodsList.setListData(getAllCustomMethods());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMethodFrame(null).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList methodsList;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
    
}