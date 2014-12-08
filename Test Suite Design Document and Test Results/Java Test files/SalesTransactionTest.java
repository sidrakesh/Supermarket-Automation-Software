/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SupermarketData;

import java.util.ArrayList;
import java.util.List;
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
public class SalesTransactionTest {
    
    public SalesTransactionTest() {
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
     * Test of setTransID method, of class SalesTransaction.
     */
    @Test
    public void testSetTransID() {
        System.out.println("setTransID");
        String id = "1234567890";
        SalesTransaction instance = new SalesTransaction("SC001");
        instance.setTransID(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class SalesTransaction.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        SalesTransaction instance = new SalesTransaction("SC001");
        TimeStamp expResult = instance.getTime();
        TimeStamp result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSellerID method, of class SalesTransaction.
     */
    @Test
    public void testGetSellerID() {
        System.out.println("getSellerID");
        SalesTransaction instance = new SalesTransaction("SC001");
        String expResult = "SC001";
        String result = instance.getSellerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTransID method, of class SalesTransaction.
     */
    @Test
    public void testGetTransID() {
        System.out.println("getTransID");
        SalesTransaction instance = new SalesTransaction("SC001");;
        String expResult = instance.getTransID();
        String result = instance.getTransID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsList method, of class SalesTransaction.
     */
    @Test
    public void testGetItemsList() {
        System.out.println("getItemsList");
        SalesTransaction instance = new SalesTransaction("SC001");
        List expResult = new ArrayList<>();
        List result = instance.getItemsList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class SalesTransaction.
     */
    @Test
    public void testDeleteItem_String() {
        System.out.println("deleteItem");
        String prodID = "1234567890";
        SalesTransaction instance = new SalesTransaction("SC001");
        instance.addItem(new Product("Toy","Mattel","1234567890"));
        instance.deleteItem(prodID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class SalesTransaction.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Product p = new Product("Toy","Mattel","1234567890");
        SalesTransaction instance = new SalesTransaction("SC001");
        instance.addItem(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class SalesTransaction.
     */
    @Test
    public void testDeleteItem_String_float() {
        System.out.println("deleteItem");
        String prodID = "1234567890";
        float quantity = 0.0F;
        SalesTransaction instance = new SalesTransaction("SC001");
        Product p = new Product("Toy","Mattel","1234567890");
        p.setQuantity(100);
        instance.addItem(p);
        
        instance.deleteItem(prodID, 10);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
