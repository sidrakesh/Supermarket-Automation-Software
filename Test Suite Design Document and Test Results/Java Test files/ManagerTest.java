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
public class ManagerTest {
    
    public ManagerTest() {
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
     * Test of getRoomNumber method, of class Manager.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Manager instance = new Manager("fname","lname",'m',"1/1/2000");
        instance.setRoomNumber("1");
        String expResult = "1";
        String result = instance.getRoomNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomNumber method, of class Manager.
     */
    @Test
    public void testSetRoomNumber() {
        System.out.println("setRoomNumber");
        String newRoomNumber = "1";
        Manager instance = new Manager("fname","lname",'m',"1/1/2000");
        instance.setRoomNumber(newRoomNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
