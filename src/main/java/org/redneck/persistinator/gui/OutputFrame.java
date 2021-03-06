/*
 * OutputFrame.java
 *
 * Created on December 8, 2006, 4:40 PM
 */

package org.redneck.persistinator.gui;

import javax.swing.JOptionPane;

import org.redneck.persistinator.util.SerializerUtil;

/**
 *
 * @author  ran488
 */
public class OutputFrame extends javax.swing.JFrame
{
    
    /** Creates new form OutputFrame */
    public OutputFrame()
    {
        initComponents();
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        outputPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        buttonPanel = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setTitle("Output Logging");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        outputPanel.setLayout(new java.awt.BorderLayout());

        outputTextArea.setColumns(40);
        outputTextArea.setEditable(false);
        outputTextArea.setRows(20);
        jScrollPane1.setViewportView(outputTextArea);

        outputPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        clearButton.setText("Clear");
        clearButton.setToolTipText("clears output area");
        clearButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(clearButton);

        saveButton.setText("Save");
        saveButton.setToolTipText("saves contents of output to a file");
        saveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(saveButton);

        outputPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButtonActionPerformed
    {//GEN-HEADEREND:event_saveButtonActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        java.io.File logFile;
        chooser.setApproveButtonText("Save");
        chooser.setApproveButtonMnemonic('S');
        int returnVal = chooser.showOpenDialog(this);
        
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION)
        {
            logFile = chooser.getSelectedFile();
            SerializerUtil serializer = new SerializerUtil();
            try
            {
                serializer.save(logFile.getAbsolutePath(), outputTextArea.getText());
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Could not save log file '" + logFile.getName() + "' because of exception:" + e.toString());
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearButtonActionPerformed
    {//GEN-HEADEREND:event_clearButtonActionPerformed
        this.outputTextArea.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new OutputFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton clearButton;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel outputPanel;
    public javax.swing.JTextArea outputTextArea;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    
}
