/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ManagerFrame extends javax.swing.JFrame {

    private Client cl;
    private String empId;
    private InventoryDatabase id;
    public ManagerFrame(Client cl, String empId) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Icon.png"));
        this.setIconImage(icon.getImage());
        this.cl = cl;
        this.empId = empId;
        initComponents();
        ItemManagePanel.setLayout(new FlowLayout());
        ItemManagePanel.add(new ItemManagementPanel(this.cl));
        ManageEmpPanel.setLayout(new FlowLayout());
        ManageEmpPanel.add(new ViewEmployeesPanel(this.cl));
        AddEmpPanel.setLayout(new FlowLayout());
        AddEmpPanel.add(new AddEmployeePanel(this.cl));
        ItemManagePanel.revalidate();
        
        id = new InventoryDatabase(this.cl);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        ManagerTabs = new javax.swing.JTabbedPane();
        ItemManagePanel = new javax.swing.JPanel();
        ManageEmpPanel = new javax.swing.JPanel();
        AddEmpPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ChangePassword = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ViewProfileItem = new javax.swing.JMenuItem();
        OverallStatItem = new javax.swing.JMenuItem();
        ItemManagementItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout ItemManagePanelLayout = new javax.swing.GroupLayout(ItemManagePanel);
        ItemManagePanel.setLayout(ItemManagePanelLayout);
        ItemManagePanelLayout.setHorizontalGroup(
            ItemManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
        );
        ItemManagePanelLayout.setVerticalGroup(
            ItemManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        ManagerTabs.addTab("Item Management", ItemManagePanel);

        javax.swing.GroupLayout ManageEmpPanelLayout = new javax.swing.GroupLayout(ManageEmpPanel);
        ManageEmpPanel.setLayout(ManageEmpPanelLayout);
        ManageEmpPanelLayout.setHorizontalGroup(
            ManageEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
        );
        ManageEmpPanelLayout.setVerticalGroup(
            ManageEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        ManagerTabs.addTab("Manage employees", ManageEmpPanel);

        javax.swing.GroupLayout AddEmpPanelLayout = new javax.swing.GroupLayout(AddEmpPanel);
        AddEmpPanel.setLayout(AddEmpPanelLayout);
        AddEmpPanelLayout.setHorizontalGroup(
            AddEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
        );
        AddEmpPanelLayout.setVerticalGroup(
            AddEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        ManagerTabs.addTab("Add Employee", AddEmpPanel);

        jMenu1.setMnemonic('F');
        jMenu1.setText("File");

        ChangePassword.setText("Change Password");
        ChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordActionPerformed(evt);
            }
        });
        jMenu1.add(ChangePassword);

        jMenuItem3.setText("Logout");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu4.setMnemonic('V');
        jMenu4.setText("View");

        ViewProfileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        ViewProfileItem.setText("Profile");
        ViewProfileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewProfileItemActionPerformed(evt);
            }
        });
        jMenu4.add(ViewProfileItem);

        OverallStatItem.setText("Overall statistics");
        OverallStatItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OverallStatItemActionPerformed(evt);
            }
        });
        jMenu4.add(OverallStatItem);

        ItemManagementItem.setText("Item management");
        ItemManagementItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemManagementItemActionPerformed(evt);
            }
        });
        jMenu4.add(ItemManagementItem);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ManagerTabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ManagerTabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordActionPerformed
        final ChangePassword dialog;
        boolean done = false;
        dialog = new ChangePassword(new JFrame(), true);
        dialog.setLocationRelativeTo(this);
        dialog.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent evt){
                dialog.setWantToChange(false);
            }
        });
        do{
        
        dialog.setVisible(true);
        if(dialog.wantToChange()){
            String reply = EmployeeDatabase.changePassword(empId, dialog.getOldPassword(), dialog.getNewPassword(), cl);
            if(reply.startsWith("SUCCESS")){
                JOptionPane.showMessageDialog(null, "Password successfully changed","",JOptionPane.INFORMATION_MESSAGE);
                done = true;
            }
            else{
                dialog.showError(reply);
                done = false;
            }
        }
        else{
            done = true;
        }
        }while(!done);
    }//GEN-LAST:event_ChangePasswordActionPerformed

    private void OverallStatItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OverallStatItemActionPerformed
        OverallStatisticsDialog osd = new OverallStatisticsDialog(new JFrame(), true, id);
        osd.setLocationRelativeTo(null);
        osd.setVisible(true);
    }//GEN-LAST:event_OverallStatItemActionPerformed

    private void ItemManagementItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemManagementItemActionPerformed
        ManagerTabs.setSelectedIndex(0);
    }//GEN-LAST:event_ItemManagementItemActionPerformed

    private void ViewProfileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewProfileItemActionPerformed
        ViewProfileDialog vpd = new ViewProfileDialog(new JFrame(),true,cl,empId);
        vpd.setLocationRelativeTo(null);
        vpd.setVisible(true);
    }//GEN-LAST:event_ViewProfileItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            EmployeeDatabase.Logout(cl);
            cl.closeConnection();
            System.exit(0);
        } catch (IOException ex) {
            System.exit(-1);
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddEmpPanel;
    private javax.swing.JMenuItem ChangePassword;
    private javax.swing.JPanel ItemManagePanel;
    private javax.swing.JMenuItem ItemManagementItem;
    private javax.swing.JPanel ManageEmpPanel;
    private javax.swing.JTabbedPane ManagerTabs;
    private javax.swing.JMenuItem OverallStatItem;
    private javax.swing.JMenuItem ViewProfileItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
