/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SupermarketData;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sameer
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetEmpID method, of class Employee.
     */
    @Test
    public void testGetEmpID() {
        System.out.println("GetEmpID");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.setEmpID("1");
        String expResult = "1";
        String result = instance.GetEmpID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of GetfName method, of class Employee.
     */
    @Test
    public void testGetfName() {
        System.out.println("GetfName");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        String expResult = "fname";
        String result = instance.GetfName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetlName method, of class Employee.
     */
    @Test
    public void testGetlName() {
        System.out.println("GetlName");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        String expResult = "lname";
        String result = instance.GetlName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetSex method, of class Employee.
     */
    @Test
    public void testGetSex() {
        System.out.println("GetSex");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        char expResult = 'm';
        char result = instance.GetSex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetDOB method, of class Employee.
     */
    @Test
    public void testGetDOB() {
        System.out.println("GetDOB");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        String expResult = "24/6/2000";
        String result = instance.GetDOB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetAddress method, of class Employee.
     */
    @Test
    public void testGetAddress() {
        System.out.println("GetAddress");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetAddress("home");
        String expResult = "home";
        String result = instance.GetAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SetAddress method, of class Employee.
     */
    @Test
    public void testSetAddress() {
        System.out.println("SetAddress");
        String newAddress = "home";
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        
        instance.SetAddress(newAddress);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetTelephoneNumber method, of class Employee.
     */
    @Test
    public void testGetTelephoneNumber() {
        System.out.println("GetTelephoneNumber");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetTelephoneNumber("1010101010");
        String expResult = "1010101010";
        String result = instance.GetTelephoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SetTelephoneNumber method, of class Employee.
     */
    @Test
    public void testSetTelephoneNumber() {
        System.out.println("SetTelephoneNumber");
        String newTelephoneNumber = "1010101010";
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetTelephoneNumber(newTelephoneNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GeteMailID method, of class Employee.
     */
    @Test
    public void testGeteMailID() {
        System.out.println("GeteMailID");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SeteMailID("sid.rakesh@gmail.com");
        String expResult = "sid.rakesh@gmail.com";
        String result = instance.GeteMailID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SeteMailID method, of class Employee.
     */
    @Test
    public void testSeteMailID() {
        System.out.println("SeteMailID");
        String neweMailID = "sid.rakesh@gmail.com";
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SeteMailID(neweMailID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetPassword method, of class Employee.
     */
    @Test
    public void testGetPassword() {
        System.out.println("GetPassword");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetPassword("1234");
        String expResult = "1234";
        String result = instance.GetPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SetPassword method, of class Employee.
     */
    @Test
    public void testSetPassword() {
        System.out.println("SetPassword");
        String newPassword = "1234";
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetPassword(newPassword);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetSalary method, of class Employee.
     */
    @Test
    public void testGetSalary() {
        System.out.println("GetSalary");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetSalary(1000);
        float expResult = 1000;
        float result = instance.GetSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SetSalary method, of class Employee.
     */
    @Test
    public void testSetSalary() {
        System.out.println("SetSalary");
        float newSalary = 1000;
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetSalary(newSalary);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GetBankACNumber method, of class Employee.
     */
    @Test
    public void testGetBankACNumber() {
        System.out.println("GetBankACNumber");
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetBankACNumber("1010101010");
        String expResult = "1010101010";
        String result = instance.GetBankACNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SetBankACNumber method, of class Employee.
     */
    @Test
    public void testSetBankACNumber() {
        System.out.println("SetBankACNumber");
        String NewBankACNumber = "1010101010";
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.SetBankACNumber(NewBankACNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpID method, of class Employee.
     */
    @Test
    public void testSetEmpID() {
        System.out.println("setEmpID");
        String ID = "SS001";
        Employee instance = new Employee("fname","lname",'m',"24/6/2000");
        instance.setEmpID(ID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
