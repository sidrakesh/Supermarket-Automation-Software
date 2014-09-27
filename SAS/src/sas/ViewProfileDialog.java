
package sas;

import SupermarketData.Manager;
import SupermarketData.SalesClerk;
import SupermarketData.SupermarketStaff;
import javax.swing.ImageIcon;

public class ViewProfileDialog extends javax.swing.JDialog {

    public ViewProfileDialog(java.awt.Frame parent, boolean modal, Client cl, String EmpId) {
        super(parent, modal);
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Icon.png"));
        this.setIconImage(icon.getImage());
        if(EmpId.startsWith("SC"))
        {
            SalesClerk sc;
            
            sc = EmployeeDatabase.getSalesClerk(EmpId, cl);
            
            EmployeeID.setText(EmpId);
            Post.setText("Sales clerk");
            FName.setText(sc.GetfName());
            LName.setText(sc.GetlName());
            
            if(sc.GetSex()=='m')
            {
                Sex.setText("Male");
            }
            else
            {
                Sex.setText("Female");
            }
            
            DOB.setText(sc.GetDOB());
            Address.setText(sc.GetAddress());
            Location.setText(sc.getLocation());
            Mobile.setText(sc.GetTelephoneNumber());
            Email.setText(sc.GeteMailID());
            Salary.setText(sc.GetSalary()+"");
            BankACNumber.setText(sc.GetBankACNumber()+"");
        }
        
        else if(EmpId.startsWith("SS"))
        {
            SupermarketStaff ss;
            
            ss = EmployeeDatabase.getSupermarketStaff(EmpId, cl);
            
            EmployeeID.setText(EmpId);
            Post.setText("Supermarket staff");
            FName.setText(ss.GetfName());
            LName.setText(ss.GetlName());
            
            if(ss.GetSex()=='m')
            {
                Sex.setText("Male");
            }
            else
            {
                Sex.setText("Female");
            }
            
            DOB.setText(ss.GetDOB());
            Address.setText(ss.GetAddress());
            Location.setText(ss.getLocation());
            Mobile.setText(ss.GetTelephoneNumber());
            Email.setText(ss.GeteMailID());
            Salary.setText(ss.GetSalary()+"");
            BankACNumber.setText(ss.GetBankACNumber());
        }
        
        else if(EmpId.startsWith("MA"))
        {
            Manager ma;
            
            ma = EmployeeDatabase.getManager(EmpId, cl);
            if(ma!=null){
            EmployeeID.setText(EmpId);
            Post.setText("Manager");
            FName.setText(ma.GetfName());
            LName.setText(ma.GetlName());
            
            if(ma.GetSex()=='m')
            {
                Sex.setText("Male");
            }
            else
            {
                Sex.setText("Female");
            }
            
            DOB.setText(ma.GetDOB());
            Address.setText(ma.GetAddress());
            Mobile.setText(ma.GetTelephoneNumber());
            Email.setText(ma.GeteMailID());
            Salary.setText(ma.GetSalary()+"");
            BankACNumber.setText(ma.GetBankACNumber());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel78 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        EmployeeID = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        FName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        LName = new javax.swing.JTextField();
        Sex = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        DOB = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Location = new javax.swing.JTextField();
        Mobile = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Salary = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        BankACNumber = new javax.swing.JTextField();
        Exit = new javax.swing.JButton();
        Post = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel78.setText("Your Details");

        jLabel88.setText("Employee ID:");

        EmployeeID.setEnabled(false);

        jLabel79.setText("First Name:");

        FName.setEnabled(false);

        jLabel1.setText("Post:");

        jLabel80.setText("Last Name:");

        LName.setEnabled(false);

        Sex.setEnabled(false);

        jLabel81.setText("Sex:");

        jLabel82.setText("Date of Birth:");

        DOB.setEnabled(false);

        jLabel83.setText("Address");

        jLabel2.setText("Location:");

        Location.setEnabled(false);

        Mobile.setEnabled(false);

        jLabel84.setText("Mobile:");

        jLabel85.setText("Email:");

        Email.setEnabled(false);

        Salary.setEnabled(false);

        jLabel86.setText("Salary:");

        jLabel87.setText("Bank Account Number:");

        BankACNumber.setEnabled(false);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Post.setEnabled(false);

        Address.setColumns(20);
        Address.setRows(5);
        Address.setEnabled(false);
        jScrollPane1.setViewportView(Address);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FName)
                            .addComponent(LName)
                            .addComponent(Mobile)
                            .addComponent(Email)
                            .addComponent(Salary)
                            .addComponent(BankACNumber)
                            .addComponent(EmployeeID)
                            .addComponent(Location)
                            .addComponent(Sex)
                            .addComponent(DOB, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addComponent(Post)
                            .addComponent(jScrollPane1)))
                    .addComponent(Exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BankACNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Exit)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_ExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Address;
    private javax.swing.JTextField BankACNumber;
    private javax.swing.JTextField DOB;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField EmployeeID;
    private javax.swing.JButton Exit;
    private javax.swing.JTextField FName;
    private javax.swing.JTextField LName;
    private javax.swing.JTextField Location;
    private javax.swing.JTextField Mobile;
    private javax.swing.JTextField Post;
    private javax.swing.JTextField Salary;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
