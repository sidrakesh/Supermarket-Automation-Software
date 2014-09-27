
package sas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ChangePassword extends javax.swing.JDialog {

    String pass, newpass;
    boolean change = false;
    public ChangePassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ChangePassButton.addActionListener(new OKCancelHandler());
        CancelButton.addActionListener(new OKCancelHandler());
        
    }
    private class OKCancelHandler implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            if(evt.getSource() == ChangePassButton){
                if(!Arrays.equals(NewPassword.getPassword(), ConfirmNewPassword.getPassword())){
                    showError("Passwords do not match!");
                }
                else{
                    pass = new String(OldPassword.getPassword());
                    newpass = new String(NewPassword.getPassword());
                    ErrorLabel.setText("");
                    change = true;
                    dispose();
                }
            }
            else{
                change = false;
                dispose();
            }
        }
    }

    public boolean wantToChange(){
        return change;
    }
    public void setWantToChange(boolean value){
        change = value;
    }
    public void showError(String s){
        ErrorLabel.setText(s);
    }
    public String getOldPassword(){
        return pass;
    }
    public String getNewPassword(){
        return newpass;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        OldPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        NewPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        ConfirmNewPassword = new javax.swing.JPasswordField();
        ChangePassButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Password");

        jLabel2.setText("New Password");

        jLabel3.setText("Confirm New Password");

        ChangePassButton.setText("Change Password");

        CancelButton.setText("Cancel");

        ErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OldPassword)
                    .addComponent(NewPassword)
                    .addComponent(ConfirmNewPassword)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ChangePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(ChangePassButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ChangePassButton;
    private javax.swing.JPasswordField ConfirmNewPassword;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JPasswordField NewPassword;
    private javax.swing.JPasswordField OldPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
