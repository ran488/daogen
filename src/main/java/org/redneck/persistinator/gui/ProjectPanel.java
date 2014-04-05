/*
 * ProjectPanel.java
 *
 * Created on December 5, 2006, 1:16 PM
 */

package org.redneck.persistinator.gui;

import javax.swing.JOptionPane;

import org.redneck.persistinator.log.SimpleLogger;

/**
 *
 * @author  ran488
 */
public class ProjectPanel extends javax.swing.JPanel
{
    
    private ProjectInfo prjInfo = null;
    
    /** Creates new form ProjectPanel */
    public ProjectPanel()
    {
        prjInfo = new ProjectInfo();
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        dbInfoPanel = new javax.swing.JPanel();
        projectLabel = new javax.swing.JLabel();
        projectInput = new javax.swing.JTextField();
        jdbcDriverLabel = new javax.swing.JLabel();
        jdbcDriverInput = new javax.swing.JTextField();
        dbUrlLabel = new javax.swing.JLabel();
        dbUrlInput = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        userNameInput = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        schemaFilterLabel = new javax.swing.JLabel();
        schemaFilterInput = new javax.swing.JTextField();
        codeGenPanel = new javax.swing.JPanel();
        templatePathLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        templatePathInput = new javax.swing.JTextField();
        templateDirBrowseButton = new javax.swing.JButton();
        rootDirLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rootDirInput = new javax.swing.JTextField();
        rootDirBrowseButton = new javax.swing.JButton();
        basePackageNameLabel = new javax.swing.JLabel();
        basePackageNameInput = new javax.swing.JTextField();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(200, 200));
        dbInfoPanel.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        dbInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("DB Connection"));
        projectLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        projectLabel.setLabelFor(projectInput);
        projectLabel.setText("Project");
        dbInfoPanel.add(projectLabel);

        projectInput.setColumns(20);
        dbInfoPanel.add(projectInput);

        jdbcDriverLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jdbcDriverLabel.setLabelFor(jdbcDriverInput);
        jdbcDriverLabel.setText("JDBC Driver");
        dbInfoPanel.add(jdbcDriverLabel);

        jdbcDriverInput.setColumns(20);
        jdbcDriverInput.setText("oracle.jdbc.driver.OracleDriver");
        dbInfoPanel.add(jdbcDriverInput);

        dbUrlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dbUrlLabel.setLabelFor(dbUrlInput);
        dbUrlLabel.setText("JDBC Url");
        dbInfoPanel.add(dbUrlLabel);

        dbUrlInput.setColumns(25);
        dbInfoPanel.add(dbUrlInput);

        userNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userNameLabel.setLabelFor(userNameInput);
        userNameLabel.setText("User Name");
        dbInfoPanel.add(userNameLabel);

        userNameInput.setColumns(15);
        dbInfoPanel.add(userNameInput);

        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLabel.setLabelFor(passwordInput);
        passwordLabel.setText("Password");
        dbInfoPanel.add(passwordLabel);

        passwordInput.setColumns(15);
        dbInfoPanel.add(passwordInput);

        schemaFilterLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        schemaFilterLabel.setLabelFor(schemaFilterInput);
        schemaFilterLabel.setText("Schema Filter");
        schemaFilterLabel.setToolTipText("User % and _ for SQL wildcards");
        dbInfoPanel.add(schemaFilterLabel);

        schemaFilterInput.setColumns(15);
        dbInfoPanel.add(schemaFilterInput);

        add(dbInfoPanel);

        codeGenPanel.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        codeGenPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Code Generation"));
        templatePathLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        templatePathLabel.setLabelFor(templatePathInput);
        templatePathLabel.setText("Path to Velocity Templates");
        codeGenPanel.add(templatePathLabel);

        jPanel1.setLayout(new java.awt.BorderLayout());

        templatePathInput.setColumns(40);
        templatePathInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel1.add(templatePathInput, java.awt.BorderLayout.CENTER);

        templateDirBrowseButton.setText("Browse...");
        templateDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                templateDirBrowseButtonActionPerformed(evt);
            }
        });

        jPanel1.add(templateDirBrowseButton, java.awt.BorderLayout.EAST);

        codeGenPanel.add(jPanel1);

        rootDirLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rootDirLabel.setLabelFor(rootDirInput);
        rootDirLabel.setText("Generated Code Root Directory");
        codeGenPanel.add(rootDirLabel);

        jPanel2.setLayout(new java.awt.BorderLayout());

        rootDirInput.setColumns(40);
        jPanel2.add(rootDirInput, java.awt.BorderLayout.CENTER);

        rootDirBrowseButton.setText("Browse...");
        rootDirBrowseButton.setToolTipText("Browse file system for root output directory");
        rootDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rootDirBrowseButtonActionPerformed(evt);
            }
        });

        jPanel2.add(rootDirBrowseButton, java.awt.BorderLayout.EAST);

        codeGenPanel.add(jPanel2);

        basePackageNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        basePackageNameLabel.setLabelFor(basePackageNameInput);
        basePackageNameLabel.setText("Generated Code Base Package");
        codeGenPanel.add(basePackageNameLabel);

        basePackageNameInput.setColumns(30);
        basePackageNameInput.setText("com.yourcompany.yourapp");
        codeGenPanel.add(basePackageNameInput);

        add(codeGenPanel);

    }// </editor-fold>//GEN-END:initComponents
    
    private void templateDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templateDirBrowseButtonActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        java.io.File templDir;
        
        chooser.setFileSelectionMode(chooser.DIRECTORIES_ONLY);
        chooser.setApproveButtonText("Select");
        
        int returnVal = chooser.showOpenDialog(this);
        
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            SimpleLogger.log("You chose this directory: " +
                    chooser.getSelectedFile().getName());
            
            try {
                this.templatePathInput.setText(chooser.getSelectedFile().getCanonicalPath() + java.io.File.separator);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error occurred choosing a directory: " + e.toString());
            }
        }
        
    }//GEN-LAST:event_templateDirBrowseButtonActionPerformed
                                        
    private void rootDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rootDirBrowseButtonActionPerformed
    {//GEN-HEADEREND:event_rootDirBrowseButtonActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        java.io.File rootDir;
        
        chooser.setFileSelectionMode(chooser.DIRECTORIES_ONLY);
        chooser.setApproveButtonText("Select");
        
        int returnVal = chooser.showOpenDialog(this);
        
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            SimpleLogger.log("You chose this directory: " +
                    chooser.getSelectedFile().getName());
            
            try {
                this.rootDirInput.setText(chooser.getSelectedFile().getCanonicalPath() + java.io.File.separator);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error occurred choosing a directory: " + e.toString());
            }
        }
    }//GEN-LAST:event_rootDirBrowseButtonActionPerformed
    
    public void populateForm(ProjectInfo info)
    {
        this.basePackageNameInput.setText(info.getBasePackage());
        this.dbUrlInput.setText(info.getJdbcUrl());
        this.jdbcDriverInput.setText(info.getJdbcDriver());
        this.passwordInput.setText(info.getPassword());
        this.userNameInput.setText(info.getUserName());
        this.projectInput.setText(info.getProjectName());
        this.rootDirInput.setText(info.getRootOutputDir());
        this.schemaFilterInput.setText(info.getSchemaFilter());
        this.templatePathInput.setText(info.getTemplateDir());
    }
    
    public ProjectInfo getPrjInfo()
    {
        prjInfo.setBasePackage(this.basePackageNameInput.getText());
        prjInfo.setJdbcUrl(this.dbUrlInput.getText());
        prjInfo.setJdbcDriver(this.jdbcDriverInput.getText());
        prjInfo.setUserName(this.userNameInput.getText());
        prjInfo.setPassword(this.passwordInput.getText());
        prjInfo.setProjectName(this.projectInput.getText());
        prjInfo.setRootOutputDir(this.rootDirInput.getText());
        prjInfo.setSchemaFilter(this.schemaFilterInput.getText());
        prjInfo.setTemplateDir(this.templatePathInput.getText());
        
        return prjInfo;
    }
    
    public void setPrjInfo(ProjectInfo prjInfo)
    {
        this.prjInfo = prjInfo;
        this.populateForm(prjInfo);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField basePackageNameInput;
    private javax.swing.JLabel basePackageNameLabel;
    private javax.swing.JPanel codeGenPanel;
    private javax.swing.JPanel dbInfoPanel;
    private javax.swing.JTextField dbUrlInput;
    private javax.swing.JLabel dbUrlLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jdbcDriverInput;
    private javax.swing.JLabel jdbcDriverLabel;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField projectInput;
    private javax.swing.JLabel projectLabel;
    private javax.swing.JButton rootDirBrowseButton;
    private javax.swing.JTextField rootDirInput;
    private javax.swing.JLabel rootDirLabel;
    private javax.swing.JTextField schemaFilterInput;
    private javax.swing.JLabel schemaFilterLabel;
    private javax.swing.JButton templateDirBrowseButton;
    private javax.swing.JTextField templatePathInput;
    private javax.swing.JLabel templatePathLabel;
    private javax.swing.JTextField userNameInput;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
    
}