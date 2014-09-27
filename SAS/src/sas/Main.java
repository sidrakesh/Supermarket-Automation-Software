/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

   public class Main {

    public static void main(String[] args) {
           try {
        // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
       // handle exception
    }
        String s = JOptionPane.showInputDialog("Please enter the server address");
        final Client cl = new Client(s);
        
        try {
            boolean IsLoggedSuccess = true;
            cl.RunClient();
            do
            {  
                Login logindialog = new Login(new JFrame(), true);
                if(!IsLoggedSuccess)
                {
                    logindialog.ShowError();
                }
                logindialog.setLocationRelativeTo(null);
                logindialog.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent we){
                        System.exit(0);
                    }
                });
                logindialog.setVisible(true);
                String IDString = logindialog.getID();
                String Password = logindialog.getPassword();
            
                String result;
                result = EmployeeDatabase.Login(IDString, Password, cl);
            
                if(result.equalsIgnoreCase("LOGIN1"))
                {
                    IsLoggedSuccess = true;
                    if(IDString.startsWith("SC")){
                        SalesClerkFrame scf = new SalesClerkFrame(cl,IDString);
                        scf.setLocationRelativeTo(null);
                        scf.addWindowListener(new WindowAdapter(){
                            @Override
                            public void windowClosing(WindowEvent evt){
                                try {
                                    EmployeeDatabase.Logout(cl);
                                    cl.closeConnection();
                                } catch (IOException ex) {
                                    System.exit(-1);
                                }
                                
                            }
                        });
                        scf.setVisible(true);
                    }
                    else if(IDString.startsWith("SS")){
                        SupermarketStaffFrame ssf = new SupermarketStaffFrame(cl,IDString);
                        ssf.setLocationRelativeTo(null);
                        ssf.addWindowListener(new WindowAdapter(){
                            @Override
                            public void windowClosing(WindowEvent evt){
                                try {
                                    EmployeeDatabase.Logout(cl);
                                    cl.closeConnection();
                                } catch (IOException ex) {
                                    System.exit(-1);
                                }
                                
                            }
                        });
                        ssf.setVisible(true);
                    }
                    else if(IDString.startsWith("MA")){
                        final ManagerFrame ma = new ManagerFrame(cl,IDString);
                        ma.setLocationRelativeTo(null);
                        ma.addWindowListener(new WindowAdapter(){
                            @Override
                            public void windowClosing(WindowEvent evt){
                                try {
                                    EmployeeDatabase.Logout(cl);
                                    cl.closeConnection();
                                } catch (IOException ex) {
                                    System.exit(-1);
                                }
                                
                            }
                        });
                        ma.setVisible(true);
                    }
                }
                else
                {
                    IsLoggedSuccess = false;
                }
            }while(!IsLoggedSuccess);
            
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
