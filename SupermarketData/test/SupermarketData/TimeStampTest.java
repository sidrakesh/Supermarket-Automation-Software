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
public class TimeStampTest {
    
    public TimeStampTest() {
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
     * Test of getYear method, of class TimeStamp.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        TimeStamp instance = new TimeStamp(2000,1,1,10,30,30);
        int expResult = 2000;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMonth method, of class TimeStamp.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        TimeStamp instance = new TimeStamp(2000,1,1,10,30,30);
        int expResult = 1;
        int result = instance.getMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class TimeStamp.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        TimeStamp instance = new TimeStamp(2000,1,1,10,30,30);
        int expResult = 1;
        int result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHour method, of class TimeStamp.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        TimeStamp instance = new TimeStamp(2000,1,1,10,30,30);
        int expResult = 10;
        int result = instance.getHour();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMinute method, of class TimeStamp.
     */
    @Test
    public void testGetMinute() {
        System.out.println("getMinute");
        TimeStamp instance = new TimeStamp(2000,1,1,10,30,30);
        int expResult = 30;
        int result = instance.getMinute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSecond method, of class TimeStamp.
     */
    @Test
    public void testGetSecond() {
        System.out.println("getSecond");
        TimeStamp instance = new TimeStamp(2000,1,1,10,30,30);
        int expResult = 30;
        int result = instance.getSecond();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
