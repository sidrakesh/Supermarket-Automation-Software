
package sas;

import SupermarketData.Employee;
import SupermarketData.Manager;
import SupermarketData.SalesClerk;
import SupermarketData.SupermarketStaff;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;

public class ViewEmployeesPanel extends javax.swing.JPanel {
    
    private static Client cl;
    private HashMap<String,String> hm;
    
    public ViewEmployeesPanel(Client ncl) {
        initComponents();
        DefaultListModel model = new DefaultListModel();
        
        EmployeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cl = ncl;
        hm = EmployeeDatabase.getEmployeeList(cl);
        for(String s:hm.keySet())
        {
              if(!s.startsWith("MA")) 
              {
                  model.addElement(s+" - "+hm.get(s));
              }
        }
        EmployeeList.setModel(model);
    }

    private void Setfields(Employee emp)
    {
        EmployeeID.setText(emp.GetEmpID());
        FName.setText(emp.GetfName());
        LName.setText(emp.GetlName());
        if(emp.GetSex()=='m')
        {
            Sex.setText("Male");
        }
        else
        {
            Sex.setText("Female");
        }
        DOB.setText(emp.GetDOB());
        Address.setText(emp.GetAddress());
        Mobile.setText(emp.GetTelephoneNumber());
        Email.setText(emp.GeteMailID());
        Salary.setText(emp.GetSalary()+"");
        BankACNumber.setText(emp.GetBankACNumber());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        EmployeeList = new javax.swing.JList();
        jLabel79 = new javax.swing.JLabel();
        EmployeeID = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        LName = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        Mobile = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        Salary = new javax.swing.JTextField();
        BankACNumber = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        EditEmployeeButton = new javax.swing.JButton();
        RemoveEmployeeButton = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        FName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        SaveEditsButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Sex = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        Location = new javax.swing.JTextField();
        Post = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jTextPane1);

        setPreferredSize(new java.awt.Dimension(942, 556));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel78.setText("Employee Details");

        EmployeeList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Employee List"));
        EmployeeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        EmployeeList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EmployeeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                EmployeeListValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(EmployeeList);

        jLabel79.setText("First Name:");

        EmployeeID.setEnabled(false);

        jLabel80.setText("Last Name:");

        LName.setEnabled(false);

        jLabel81.setText("Sex:");

        jLabel82.setText("Date of Birth:");

        jLabel83.setText("Address");

        jLabel84.setText("Mobile:");

        Mobile.setEnabled(false);

        Email.setEnabled(false);

        jLabel85.setText("Email:");

        jLabel86.setText("Salary:");

        Salary.setEnabled(false);

        BankACNumber.setEnabled(false);

        jLabel87.setText("Bank Account Number:");

        EditEmployeeButton.setText("Edit employee details");
        EditEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditEmployeeButtonActionPerformed(evt);
            }
        });

        RemoveEmployeeButton.setText("Remove employee");
        RemoveEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveEmployeeButtonActionPerformed(evt);
            }
        });

        jLabel88.setText("Employee ID:");

        FName.setEnabled(false);

        jLabel1.setText("Post:");

        SaveEditsButton.setText("Save edits");
        SaveEditsButton.setEnabled(false);
        SaveEditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveEditsButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Location:");

        Sex.setEnabled(false);

        DOB.setEnabled(false);

        Address.setColumns(20);
        Address.setRows(5);
        Address.setEnabled(false);
        jScrollPane2.setViewportView(Address);

        Location.setEnabled(false);

        Post.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(RemoveEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel88)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SaveEditsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FName)
                                    .addComponent(LName)
                                    .addComponent(Email)
                                    .addComponent(Salary)
                                    .addComponent(BankACNumber)
                                    .addComponent(EmployeeID, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(Sex)
                                    .addComponent(DOB)
                                    .addComponent(Mobile)
                                    .addComponent(Location)
                                    .addComponent(Post)))
                            .addComponent(jLabel78)
                            .addComponent(EditEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BankACNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditEmployeeButton)
                            .addComponent(SaveEditsButton))
                        .addGap(18, 18, 18)
                        .addComponent(RemoveEmployeeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EmployeeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_EmployeeListValueChanged
        if(!EmployeeList.isSelectionEmpty()){
        String sa = (String)EmployeeList.getSelectedValue();
        String[] d = sa.split(" - ");
        String s =d[0];
        if(s.startsWith("SC"))
        {
            Post.setText("Sales clerk");
            SalesClerk sc;
            sc = EmployeeDatabase.getSalesClerk(s, cl);
            Setfields(sc);
            Location.setText(sc.getLocation());
        }
        else if(s.startsWith("SS"))
        {
            Post.setText("Supermarket staff");
            SupermarketStaff ss;
            ss = EmployeeDatabase.getSupermarketStaff(s, cl);
            Setfields(ss);
            Location.setText(ss.getLocation());
        }
        else if(s.startsWith("MA"))
        {
            Post.setText("Manager");
            Manager m;
            m = EmployeeDatabase.getManager(s, cl);
            Setfields(m);
        }
        Post.setEnabled(false);
        Address.setEnabled(false);
        Mobile.setEnabled(false);
        Email.setEnabled(false);
        Salary.setEnabled(false);
        Location.setEnabled(false);
        BankACNumber.setEnabled(false);
        SaveEditsButton.setEnabled(false);
        EditEmployeeButton.setEnabled(true);
        }
    }//GEN-LAST:event_EmployeeListValueChanged

    private void EditEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditEmployeeButtonActionPerformed
        //Post.setEnabled(true);   we have to see if we can change post of an existing employee
        Post.setEnabled(true);
        Address.setEnabled(true);
        Mobile.setEnabled(true);
        Email.setEnabled(true);
        Salary.setEnabled(true);
        Location.setEnabled(true);
        BankACNumber.setEnabled(true);
        SaveEditsButton.setEnabled(true);
        EditEmployeeButton.setEnabled(false);
        if(!Post.getText().equals("Manager"))
        {
            Location.setEnabled(true);
        }
    }//GEN-LAST:event_EditEmployeeButtonActionPerformed

    private void RemoveEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveEmployeeButtonActionPerformed
        // TODO add your handling code here:
        String sa = (String)EmployeeList.getSelectedValue();
        String[] d = sa.split(" - ");
        String s =d[0];
        EmployeeDatabase.fireEmployee(s, cl);
        
        JOptionPane.showMessageDialog(null, "Employee has been fired.");
        int x = EmployeeList.getSelectedIndex();
        DefaultListModel dlm = (DefaultListModel)EmployeeList.getModel();
        dlm.remove(x);
        
        ClearFields();
    }//GEN-LAST:event_RemoveEmployeeButtonActionPerformed

    private void SaveEditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveEditsButtonActionPerformed
        // TODO add your handling code here:
        char sex;
        if("Male".equals(Sex.getText())) 
        {
            sex='m';
        }
        else 
        {
            sex='f';
        }
        
        if(Post.getText().equals("Sales clerk"))   //if the post (maybe new) is sales clerk
        {
            SalesClerk sc = new SalesClerk(FName.getText(),LName.getText(),sex,DOB.getText());
            sc.setEmpID(EmployeeID.getText());
            sc.SetAddress(Address.getText());
            sc.SetBankACNumber(BankACNumber.getText());
            sc.SetSalary(Float.parseFloat(Salary.getText()));
            sc.SetTelephoneNumber(Mobile.getText());
            sc.SeteMailID(Email.getText());
            sc.setLocation(Location.getText());
        }
        else if(Post.getText().equals("Supermarket staff"))  //if the post (maybe new) is supermarket staff
        {
            SupermarketStaff ss = new SupermarketStaff(FName.getText(),LName.getText(),sex,DOB.getText());
            ss.setEmpID(EmployeeID.getText());
            ss.SetAddress(Address.getText());
            ss.SetBankACNumber(BankACNumber.getText());
            ss.SetSalary(Float.parseFloat(Salary.getText()));
            ss.SetTelephoneNumber(Mobile.getText());
            ss.SeteMailID(Email.getText());
            ss.setLocation(Location.getText());
            EmployeeDatabase.editEmployee(ss, cl);
        }
        
        Post.setEnabled(false);
        Address.setEnabled(false);
        Mobile.setEnabled(false);
        Email.setEnabled(false);
        Location.setEnabled(false);
        Salary.setEnabled(false);
        BankACNumber.setEnabled(false);
        SaveEditsButton.setEnabled(false);
        EditEmployeeButton.setEnabled(true);
        
        if(!Post.getText().equals("Manager"))
        {
            Location.setEnabled(false);
        }
    }//GEN-LAST:event_SaveEditsButtonActionPerformed

    private void ClearFields()
    {
        EmployeeID.setText("");
        Post.setText("");
        FName.setText("");
        LName.setText("");
        Sex.setText("");
        DOB.setText("");
        Address.setText("");
        Location.setText("");
        Mobile.setText("");
        Email.setText("");
        Salary.setText("");
        BankACNumber.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Address;
    private javax.swing.JTextField BankACNumber;
    private javax.swing.JTextField DOB;
    private javax.swing.JButton EditEmployeeButton;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField EmployeeID;
    private javax.swing.JList EmployeeList;
    private javax.swing.JTextField FName;
    private javax.swing.JTextField LName;
    private javax.swing.JTextField Location;
    private javax.swing.JTextField Mobile;
    private javax.swing.JTextField Post;
    private javax.swing.JButton RemoveEmployeeButton;
    private javax.swing.JTextField Salary;
    private javax.swing.JButton SaveEditsButton;
    private javax.swing.JTextField Sex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
