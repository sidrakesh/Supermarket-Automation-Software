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
public class SalesClerkTest {
    
    public SalesClerkTest() {
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
     * Test of getLocation method, of class SalesClerk.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        SalesClerk instance = new SalesClerk("fname","lname",'m',"1/1/2000");
        instance.setLocation("1");
        String expResult = "1";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBoss method, of class SalesClerk.
     */
    @Test
    public void testGetBoss() {
        System.out.println("getBoss");
        SalesClerk instance = new SalesClerk("fname","lname",'m',"1/1/2000");
        instance.setBoss("MA001");
        String expResult = "MA001";
        String result = instance.getBoss();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class SalesClerk.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String newLocation = "1";
        SalesClerk instance = new SalesClerk("fname","lname",'m',"1/1/2000");
        instance.setLocation(newLocation);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBoss method, of class SalesClerk.
     */
    @Test
    public void testSetBoss() {
        System.out.println("setBoss");
        String newBoss = "MA001";
        SalesClerk instance = new SalesClerk("fname","lname",'m',"1/1/2000");
        instance.setBoss(newBoss);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
