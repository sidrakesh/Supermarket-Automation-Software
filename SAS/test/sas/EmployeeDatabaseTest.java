/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import SupermarketData.SalesClerk;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author in dia
 */
public class EmployeeDatabaseTest {
    
    public EmployeeDatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testLogin() {
        try {
            System.out.println("Login");
            String empId = "SS0016";
            String pass = "SUBASH";
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            String expResult = "LOGIN1";
            String result = EmployeeDatabase.Login(empId, pass, cl);
            assertEquals(expResult, result);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of Logout method, of class EmployeeDatabase.
     */
    @Test
    public void testLogout() {
        try {
            System.out.println("Logout");
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            EmployeeDatabase.Logout(cl);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of addEmployee method, of class EmployeeDatabase.
     */
    @Test
    public void testAddEmployee_SalesClerk_Client() {
        try {
            System.out.println("addEmployee");
            SalesClerk sc = new SalesClerk("fname","lname",'m',"somedob");
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            String[] result = EmployeeDatabase.addEmployee(sc, cl);
            assert(result[0].startsWith("SC00") || result[0].startsWith("E00"));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetEmployeeList() {
        try {
            System.out.println("getEmployeeList");
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            HashMap result = EmployeeDatabase.getEmployeeList(cl);
            assertEquals(8, result.size());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getSalesClerk method, of class EmployeeDatabase.
     */
    @Test
    public void testGetSalesClerk() {
        try {
            System.out.println("getSalesClerk");
            String empID = "SC0015";
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            SalesClerk result = EmployeeDatabase.getSalesClerk(empID, cl);
            assertEquals("SC0015", result.GetEmpID());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testChangePassword() {
        try {
            System.out.println("changePassword");
            String empId = "SS0015";
            String oldPass = "efgh";
            String newPass = "efgh";
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            String expResult = "SUCCESS";
            String result = EmployeeDatabase.changePassword(empId, oldPass, newPass, cl);
            assertEquals(expResult, result);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
