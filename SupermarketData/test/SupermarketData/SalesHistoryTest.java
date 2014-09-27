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
public class SalesHistoryTest {
    
    public SalesHistoryTest() {
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
     * Test of getProductId method, of class SalesHistory.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        SalesHistory instance = new SalesHistory("1234567890", 100, "1/1/2000", 10, 12);
        String expResult = "1234567890";
        String result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantitySold method, of class SalesHistory.
     */
    @Test
    public void testGetQuantitySold() {
        System.out.println("getQuantitySold");
        SalesHistory instance = new SalesHistory("1234567890", 100, "1/1/2000", 10, 12);
        float expResult = 100;
        float result = instance.getQuantitySold();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfSale method, of class SalesHistory.
     */
    @Test
    public void testGetDateOfSale() {
        System.out.println("getDateOfSale");
        SalesHistory instance = new SalesHistory("1234567890", 100, "1/1/2000", 10, 12);
        String expResult = "1/1/2000";
        String result = instance.getDateOfSale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCostPrice method, of class SalesHistory.
     */
    @Test
    public void testGetCostPrice() {
        System.out.println("getCostPrice");
        SalesHistory instance = new SalesHistory("1234567890", 100, "1/1/2000", 10, 12);
        float expResult = 10;
        float result = instance.getCostPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSellingPrice method, of class SalesHistory.
     */
    @Test
    public void testGetSellingPrice() {
        System.out.println("getSellingPrice");
        SalesHistory instance = new SalesHistory("1234567890", 100, "1/1/2000", 10, 12);
        float expResult = 12;
        float result = instance.getSellingPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
