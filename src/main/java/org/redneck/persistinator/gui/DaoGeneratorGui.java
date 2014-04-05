/*
 * DaoGeneratorGui.java
 *
 * Created on December 4, 2006, 8:22 PM
 */

package org.redneck.persistinator.gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.redneck.persistinator.generator.CodeGenerator;
import org.redneck.persistinator.log.SimpleLogger;
import org.redneck.persistinator.meta.Database;
import org.redneck.persistinator.meta.DbDescriptor;
import org.redneck.persistinator.util.SerializerUtil;


/**
 *
 * @author  Robb
 */
public class DaoGeneratorGui extends javax.swing.JFrame
{
    
    /** The application-specific stuff */
    private SerializerUtil serializer = null;
    //private ProjectInfo prjInfo = null;
    private OutputFrame outFrm = null;
    private DbViewPanel dbView = null;
    private CustomQueryPanel custQuery = null;
    private QueryRunnerPanel queryRunner = null;
    private JTabbedPane tabPane = null;
    private HelpFrame helpFrm = null;
    
    /** Creates new form DaoGeneratorGui */
    public DaoGeneratorGui()
    {
        serializer = new SerializerUtil();
        prjPanel = new ProjectPanel();
        outFrm = new OutputFrame();
//        // temp
//        Table temp = new Table();
//        temp.setTableSchema("test");
//        temp.setTableName("blah");
//        temp.setColumns(new java.util.ArrayList());
//        temp.setExportedKeys(new java.util.ArrayList());
//        temp.setImportedKeys(new java.util.ArrayList());
//        temp.setPrimaryKeys(new java.util.ArrayList());
//        temp.setTableRemarks("remarks");
//        temp.setTableType("table");
//        custQuery = new CustomQueryPanel(this,temp);
//        //
        queryRunner = new QueryRunnerPanel(this);
        
        tabPane = new JTabbedPane();
        tabPane.addTab("Configuration", prjPanel);
//        // temp
//        tabPane.addTab("Custom Queries", custQuery);
//        // 
        tabPane.addTab("Run Query", queryRunner);
        tabPane.addTab("Output", outFrm.outputPanel);
        
        SimpleLogger.textArea = outFrm.outputTextArea;
        //getContentPane().add(prjPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(tabPane, java.awt.BorderLayout.CENTER);
        
        initComponents();
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewButtonsGroup = new javax.swing.ButtonGroup();
        toolBar = new javax.swing.JToolBar();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        saveAsButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dbDescribeButton = new javax.swing.JButton();
        codeGenerateButton = new javax.swing.JButton();
        showLogToggle = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        metalOption = new javax.swing.JRadioButtonMenuItem();
        motifOption = new javax.swing.JRadioButtonMenuItem();
        nativeOption = new javax.swing.JRadioButtonMenuItem();
        nimbusOption = new javax.swing.JRadioButtonMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DAO Generator GUI");
        setName("daoGenMainFrame"); // NOI18N

        toolBar.setName("DAO Generator Actions"); // NOI18N

        openButton.setMnemonic('O');
        openButton.setText("Open...");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        toolBar.add(openButton);

        saveButton.setMnemonic('S');
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        toolBar.add(saveButton);

        saveAsButton.setMnemonic('A');
        saveAsButton.setText("Save As...");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });
        toolBar.add(saveAsButton);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMaximumSize(new java.awt.Dimension(10, 25));
        jSeparator1.setMinimumSize(new java.awt.Dimension(10, 25));
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 25));
        toolBar.add(jSeparator1);

        dbDescribeButton.setMnemonic('D');
        dbDescribeButton.setText("Describe Database");
        dbDescribeButton.setToolTipText("Connect to database and describe database metadata");
        dbDescribeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbDescribeButtonActionPerformed(evt);
            }
        });
        toolBar.add(dbDescribeButton);

        codeGenerateButton.setMnemonic('G');
        codeGenerateButton.setText("Generate Code");
        codeGenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeGenerateButtonActionPerformed(evt);
            }
        });
        toolBar.add(codeGenerateButton);

        showLogToggle.setMnemonic('W');
        showLogToggle.setText("Show Output Window");
        showLogToggle.setToolTipText("Launcha new window to show console output");
        showLogToggle.setEnabled(false);
        showLogToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLogToggleActionPerformed(evt);
            }
        });
        toolBar.add(showLogToggle);

        getContentPane().add(toolBar, java.awt.BorderLayout.NORTH);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('O');
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setMnemonic('S');
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('A');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('E');
        editMenu.setText("Edit");

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);

        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyMenuItem.setMnemonic('C');
        copyMenuItem.setText("Copy");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        pasteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteMenuItem.setMnemonic('P');
        pasteMenuItem.setText("Paste");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteMenuItem);

        menuBar.add(editMenu);

        viewMenu.setMnemonic('V');
        viewMenu.setText("View");

        viewButtonsGroup.add(metalOption);
        metalOption.setMnemonic('J');
        metalOption.setSelected(true);
        metalOption.setText("Java/Metal");
        metalOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metalOptionActionPerformed(evt);
            }
        });
        viewMenu.add(metalOption);

        viewButtonsGroup.add(motifOption);
        motifOption.setMnemonic('M');
        motifOption.setText("Motif");
        motifOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motifOptionActionPerformed(evt);
            }
        });
        viewMenu.add(motifOption);

        viewButtonsGroup.add(nativeOption);
        nativeOption.setMnemonic('N');
        nativeOption.setText("Platform Native");
        nativeOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nativeOptionActionPerformed(evt);
            }
        });
        viewMenu.add(nativeOption);

        viewButtonsGroup.add(nimbusOption);
        nimbusOption.setText("Nimbus");
        nimbusOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimbusOptionActionPerformed(evt);
            }
        });
        viewMenu.add(nimbusOption);

        menuBar.add(viewMenu);

        helpMenu.setMnemonic('H');
        helpMenu.setText("Help");

        contentsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        contentsMenuItem.setMnemonic('C');
        contentsMenuItem.setText("Contents");
        contentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentsMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_pasteMenuItemActionPerformed
    {//GEN-HEADEREND:event_pasteMenuItemActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_copyMenuItemActionPerformed
    {//GEN-HEADEREND:event_copyMenuItemActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cutMenuItemActionPerformed
    {//GEN-HEADEREND:event_cutMenuItemActionPerformed
    // TODO add your handling code here:    
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void contentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentsMenuItemActionPerformed
         if (helpFrm == null) helpFrm = new HelpFrame();
         helpFrm.setVisible(true);
    }//GEN-LAST:event_contentsMenuItemActionPerformed
    
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        String aboutContents = "DAO Generator version 1.0. Copyright 2006 ran488.";
        JOptionPane.showMessageDialog(this, aboutContents, "About DAO Generator", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void showLogToggleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_showLogToggleActionPerformed
    {//GEN-HEADEREND:event_showLogToggleActionPerformed
        if (this.showLogToggle.isSelected())
        {
            outFrm.setVisible(true);
        }
        else
        {
            outFrm.setVisible(false);
        }
    }//GEN-LAST:event_showLogToggleActionPerformed
    
    private void codeGenerateButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_codeGenerateButtonActionPerformed
    {//GEN-HEADEREND:event_codeGenerateButtonActionPerformed
        new Thread("Code Generator Thread")
        {
            public void run()
            {
                ProjectInfo updatedInfo = prjPanel.getPrjInfo();
                if (!updatedInfo.isDescribed())
                {
                    JOptionPane.showMessageDialog(DaoGeneratorGui.this, "You must describe the database before generating code.");
                }
                else
                {
                    if (isPopulated("Template Directory", updatedInfo.getTemplateDir()) &&
                            isPopulated("Root Directory", updatedInfo.getRootOutputDir()) &&
                            isPopulated("Base Package", updatedInfo.getBasePackage()))
                    {
                        try
                        {
                            JOptionPane.showMessageDialog(DaoGeneratorGui.this, "About to generate persistence code. This could take some time.");
                            long start = System.currentTimeMillis();
                            
                            CodeGenerator gen = new CodeGenerator();
                            gen.generateSources(updatedInfo.getDatabaseMetaData(), updatedInfo.getTemplateDir(), updatedInfo.getRootOutputDir(), updatedInfo.getBasePackage());
                            
                            long end = System.currentTimeMillis();
                            JOptionPane.showMessageDialog(DaoGeneratorGui.this, "Code Generation has successfully completed. ("+(end-start)+"ms)");
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(DaoGeneratorGui.this, "Code Generation failed due to an exception. " + e.toString());
                        }
                    }
                    else
                    {
                        //something was blank, go to form to fill it in
                        switchToConfigTab();
                    }
                }
            }
        }.start();
    }//GEN-LAST:event_codeGenerateButtonActionPerformed

    /** The meat part of the meat and potatoes. The actual core functionality starts
     * here as opposed to all the GUI plumbing code it takes to churn out a simple
     * Swing application
     */
    private void dbDescribeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dbDescribeButtonActionPerformed
    {//GEN-HEADEREND:event_dbDescribeButtonActionPerformed
        // FIXME: should put this in a separate thread so main gui isn't locked up
        //get latest values off panel
        new Thread("DB Describer Thread")
        {
            public void run()
            {
                ProjectInfo updatedInfo = prjPanel.getPrjInfo();
                
                DbDescriptor dbd;
                Database db = updatedInfo.getDatabaseMetaData();
                //log to see if we have a DB yet?
                SimpleLogger.log( (db == null)? "no DB yet" : db.toString());
                if (db == null)
                    db = new Database();
                
                if ((updatedInfo.getSchemaFilter() != null) && (!updatedInfo.getSchemaFilter().trim().equals("")))
                {
                    dbd = new DbDescriptor(updatedInfo.getSchemaFilter(), db);
                }
                else
                {
                    dbd = new DbDescriptor(db);
                }
                
                if (isPopulated("JDBC Driver", updatedInfo.getJdbcDriver()) &&
                        isPopulated("JDBC Url", updatedInfo.getJdbcUrl()) &&
                        isPopulated("Username", updatedInfo.getUserName())
                        )
                {
                    try
                    {
                        JOptionPane.showMessageDialog(DaoGeneratorGui.this, "About to load all database meta data and describe DB objects. This could take some time.");
                        switchToOutputTab();
                        long start = System.currentTimeMillis();
                        db = dbd.describe(updatedInfo.getJdbcUrl(), updatedInfo.getUserName(), updatedInfo.getPassword(), updatedInfo.getJdbcDriver());
                        updatedInfo.setDatabaseMetaData(db);
                        updatedInfo.setDescribed(true);
                        prjPanel.setPrjInfo(updatedInfo);
                        long end = System.currentTimeMillis();
                        JOptionPane.showMessageDialog(DaoGeneratorGui.this, "DB describe has successfully completed. ("+(end-start)+"ms) Code generation can now begin.");
                        //auto-select explorer tab after describe is done
                        displayDbExplorerTab();
                        switchToDbExplorerTab();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(DaoGeneratorGui.this, "DB describe failed due to an exception. " + e.toString());
                    }
                }
                else
                {
                    //something was blank, go to form to fill it in
                    switchToConfigTab();
                }
            }
        }.start();
    }//GEN-LAST:event_dbDescribeButtonActionPerformed
    

    public boolean isPopulated(String field, String value)
    {
        boolean retCode = true;
        
        if ( (value == null) || (value.trim().equals("")) )
        {
            JOptionPane.showMessageDialog(this, field + " cannot be blank.", "Error", JOptionPane.WARNING_MESSAGE);
            retCode = false;
        }
        
        return retCode;
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButtonActionPerformed
    {//GEN-HEADEREND:event_saveButtonActionPerformed
        saveMenuItemActionPerformed(evt);
    }//GEN-LAST:event_saveButtonActionPerformed
    
    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAsMenuItemActionPerformed
    {//GEN-HEADEREND:event_saveAsMenuItemActionPerformed
        new Thread("SaveAs Thread")
        {
            public void run()
            {
                javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
                java.io.File projectFile;
                String filePath;
                chooser.setDialogType(JFileChooser.SAVE_DIALOG);
                chooser.setFileFilter(new DaoGeneratorGui.PrjFileFilter());
                chooser.setApproveButtonText("Save");
                chooser.setApproveButtonMnemonic('S');
                
                
                int returnVal = chooser.showSaveDialog(DaoGeneratorGui.this);
                
                if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION)
                {
                    SimpleLogger.log("Saving " + chooser.getSelectedFile().getName() + "...");
                    filePath = chooser.getSelectedFile().getAbsolutePath();
                    if (!filePath.endsWith(".prj"))
                        filePath = filePath + ".prj";
                    
                    //projectFile = chooser.getSelectedFile();
                    projectFile = new File(filePath);

                    try
                    {
                        ProjectInfo updatedInfo = prjPanel.getPrjInfo();
                        updatedInfo.setProjectFileName(projectFile.getCanonicalPath());
                        //SimpleLogger.log("Project Info to save: " + updatedInfo.toString());
                        serializer.saveProject(projectFile.getAbsolutePath(), updatedInfo );
                        SimpleLogger.log(chooser.getSelectedFile().getName() + " Saved.");
                        
                        setTitle("DAO Generator: " + projectFile.getName());
                        prjPanel.setPrjInfo(updatedInfo);
                    }
                    catch (Exception e)
                    {
                        //FIXME: need more specific error message, e.g. file not found, corrupt, not a prj file, etc.
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(DaoGeneratorGui.this, "Could not save project file '" + projectFile.getName() + "' because of an exception:\n\t" + e.toString());
                    }
                }
            }
        }.start();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed
    
    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveMenuItemActionPerformed
    {//GEN-HEADEREND:event_saveMenuItemActionPerformed
        //save the current project if there is one, otherwise save as...
        final ProjectInfo updatedInfo = prjPanel.getPrjInfo();
        final String fileName = updatedInfo.getProjectFileName();
        //SimpleLogger.log("Current filename is: " + fileName);
        if ((fileName == null) || (fileName.trim().equals("")))
        {
            // no current filename, do a save as...
            saveAsMenuItemActionPerformed(evt);
        }
        else
        {
            new Thread("Save Project Thread")
            {
                public void run()
                {
                    //save under current filename...
                    try
                    {
                        SimpleLogger.log("Saving " + fileName + "..." );
                        serializer.saveProject(fileName, updatedInfo);
                        SimpleLogger.log(fileName + " Saved.");
                    }
                    catch (Exception e)
                    {
                        //FIXME: need more specific error message, e.g. file not found, corrupt, not a prj file, etc.
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(DaoGeneratorGui.this, "Could not save project file '" + fileName + "'.");
                    }
                }
            }.start();
        }
        
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openButtonActionPerformed
    {//GEN-HEADEREND:event_openButtonActionPerformed
        openMenuItemActionPerformed(evt);
    }//GEN-LAST:event_openButtonActionPerformed
    
    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAsButtonActionPerformed
    {//GEN-HEADEREND:event_saveAsButtonActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_saveAsButtonActionPerformed
    
    private void nativeOptionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nativeOptionActionPerformed
    {//GEN-HEADEREND:event_nativeOptionActionPerformed
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {}
    }//GEN-LAST:event_nativeOptionActionPerformed
    
    private void motifOptionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_motifOptionActionPerformed
    {//GEN-HEADEREND:event_motifOptionActionPerformed
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {}
    }//GEN-LAST:event_motifOptionActionPerformed
    
    private void metalOptionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_metalOptionActionPerformed
    {//GEN-HEADEREND:event_metalOptionActionPerformed
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
            /*
            UIManager.LookAndFeelInfo[] lnf = UIManager.getInstalledLookAndFeels();
            for (int i = 0; i < lnf.length; i++)
            {
                SimpleLogger.log("Look and feel: " + lnf[i].getName() + " / " + lnf[i].getClassName());
            }
             */
        }
        catch (Exception e)
        {}
    }//GEN-LAST:event_metalOptionActionPerformed
    
    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        java.io.File projectFile;
        chooser.setFileFilter(new DaoGeneratorGui.PrjFileFilter());
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        int returnVal = chooser.showOpenDialog(this);
        ProjectInfo prjInfo = null;
        
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION)
        {
            SimpleLogger.log("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
            projectFile = chooser.getSelectedFile();
            
            try
            {
                prjInfo = serializer.loadProject(projectFile.getAbsolutePath());
                this.setTitle("DAO Generator: " + projectFile.getName());
                prjInfo.setProjectFileName(projectFile.getCanonicalPath());
                prjPanel.setPrjInfo(prjInfo);
                displayDbExplorerTab();
            }
            catch (Exception e)
            {
                //FIXME: need more specific error message, e.g. file not found, corrupt, not a prj file, etc.
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Could not load project file '" + projectFile.getName() + "'.");
            }            
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void displayDbExplorerTab()
    {
        if (this.getProjectInfo().isDescribed())
        {
            if (dbView != null)
                tabPane.remove(dbView);
            
            dbView = new DbViewPanel(this);
            tabPane.addTab("DB Explorer", dbView);
        }
    }
    
//    /** Object o has to be either a Table or Procedure, I know it should
//     * be more typesafe than this, but screw it for now 
//     */
//    public void displayCustomQueryTab(AbstractTable o)
//    {
//        String tabName = null;
//        
//        if (o.isTable())
//            tabName = ((Table)o).getTableName();
//        else if (o.isProcedure())
//            tabName = ((Procedure)o).getProcName();
//            
//        CustomQueryPanel q1 = new CustomQueryPanel(this, o);
//        tabPane.addTab("Custom Method: " + tabName, q1);
//        //FIXME: this tab must have a way to close it or we could have many many many!!!!
//        tabPane.setSelectedComponent(q1);
//    }
    
    /** to remove a custom query tab when user is done */
    public void closeCustomQueryTab(CustomQueryPanel cqp)
    {
        // remove the tab and release the memory the panel is using up
        tabPane.remove(cqp);
        cqp = null;
    }
    
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

	private void nimbusOptionActionPerformed(java.awt.event.ActionEvent evt) {

		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
					SwingUtilities.updateComponentTreeUI(this);
					break;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			}
		}
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new DaoGeneratorGui().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton codeGenerateButton;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JButton dbDescribeButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JRadioButtonMenuItem metalOption;
    private javax.swing.JRadioButtonMenuItem motifOption;
    private javax.swing.JRadioButtonMenuItem nativeOption;
    private javax.swing.JRadioButtonMenuItem nimbusOption;
    private javax.swing.JButton openButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JButton saveButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JToggleButton showLogToggle;
    private javax.swing.JToolBar toolBar;
    private javax.swing.ButtonGroup viewButtonsGroup;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
    private ProjectPanel prjPanel;
    
    public ProjectInfo getProjectInfo()
    {
        return prjPanel.getPrjInfo();
    }
    
    private static class PrjFileFilter extends javax.swing.filechooser.FileFilter
    {
        public boolean accept(java.io.File f)
        {
            return ((f.getName() != null) && (!f.getName().equals("")) && (f.getName().endsWith(".prj")));
        }
        
        public String getDescription()
        {
            return "DAO Generator Project Files";
        }
    }
    
    public void switchToDbExplorerTab()
    {
        tabPane.setSelectedComponent(dbView);
    }
    
    
    public void switchToOutputTab()
    {
        //auto-select output tab
        tabPane.setSelectedComponent(outFrm.outputPanel);
    }
    
    public void switchToConfigTab()
    {
        tabPane.setSelectedComponent(prjPanel);
    }

}