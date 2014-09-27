
package sas;

import java.io.IOException;
import java.util.HashMap;
import SupermarketData.*;
public class EmployeeDatabase {
    
    public static String editEmployee(SalesClerk sc,Client cl)
    {
        try {
            cl.sendData("EDITEMPSC");
            cl.sendData(sc);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("EDITEMPSC1")){
                return "SUCCESS";
            }
            else{
                return "E002";
            }
        } catch (ClassNotFoundException | IOException ex) {
            return "E001";
        }
    }
    
    public static String editEmployee(SupermarketStaff ss,Client cl)
    {
        try {
            cl.sendData("EDITEMPSS");
            cl.sendData(ss);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("EDITEMPSS1")){
                return "SUCCESS";
            }
            else{
                return "E002";
            }
        } catch (ClassNotFoundException | IOException ex) {
            return "E001";
        }
    }
    
    public static String Login(String empId, String pass, Client cl){
        try {
            cl.sendData("LOGIN;"+empId+";"+pass);
            String reply = (String)cl.recieveData();
            return reply;
        } catch (IOException | ClassNotFoundException ex) {
            return "E001";
        }
    }
    public static void Logout(Client cl){
        try {
            cl.sendData("LOGOUT");
        } catch (IOException ex) {
            
        }
    }
    public static String[] addEmployee(SalesClerk sc, Client cl){
        try {
            cl.sendData("ADDEMPSC");
            cl.sendData(sc);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("ADDEMPSC1")){
                String s[] = reply.split(";");
                return new String[]{s[1],s[2]};
            }
            else{
                return new String[]{"E002"};
            }
        } catch (ClassNotFoundException | IOException ex) {
            return new String[]{"E001"};
        }
    }
    public static String[] addEmployee(SupermarketStaff ss, Client cl){
        try {
            cl.sendData("ADDEMPSS");
            cl.sendData(ss);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("ADDEMPSS1")){
                String s[] = reply.split(";");
                return new String[]{s[1],s[2]};
            }
            else{
                return new String[]{"E002"};
            }
        } catch (ClassNotFoundException | IOException ex) {
            return new String[]{"E001"};
        }
    }
    public static HashMap<String,String> getEmployeeList(Client cl){
        try {
            cl.sendData("GETEMPLIST");
            String reply = (String)cl.recieveData();
            if(reply.startsWith("GETEMPLIST1")){
            HashMap<String,String> hm = (HashMap<String,String>)cl.recieveData();
            return hm;
            }
            else{
                return null;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }
    public static SalesClerk getSalesClerk(String empID, Client cl){
        try {
            cl.sendData("GETEMP;"+empID);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("GETEMP1")){
                SalesClerk sc = (SalesClerk)cl.recieveData();
                return sc;
            }
            else{
                return null;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }
    public static SupermarketStaff getSupermarketStaff(String empID, Client cl){
        try {
            cl.sendData("GETEMP;"+empID);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("GETEMP1")){
                SupermarketStaff ss = (SupermarketStaff)cl.recieveData();
                return ss;
            }
            else{
                return null;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }
    public static Manager getManager(String empID,Client cl){
         try {
            cl.sendData("GETEMP;"+empID);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("GETEMP1")){
                Manager m = (Manager)cl.recieveData();
                return m;
            }
            else{
                return null;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }
    public static boolean fireEmployee(String empID,Client cl){
        try {
            cl.sendData("FIREEMP;"+empID);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("FIRED")){
                return true;
            }
            else{
                return false;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return false;
        }
        
    }
    public static String changePassword(String empId, String oldPass, String newPass, Client cl){
        try {
            cl.sendData("CHANGEPASS;"+empId+";"+oldPass+";"+newPass);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("CHANGED")){
                return "SUCCESS";
            }
            else{
                return "The password you entered is wrong";
            }
        } catch (ClassNotFoundException | IOException ex) {
            return "E001";
        }
    }
    
}
