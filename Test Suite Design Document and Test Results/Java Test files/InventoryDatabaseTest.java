/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import SupermarketData.Product;
import SupermarketData.SalesTransaction;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class InventoryDatabaseTest {
    
    public InventoryDatabaseTest() {
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
     * Test of updateInventory method, of class InventoryDatabase.
     */
    @Test
    public void testUpdateInventory() {
        System.out.println("updateInventory");
        String prodID = "1234567890";
        float Quantity = 100;
        int updationType = 1;
        try{
        Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
        String expResult = "UPDATED";
        String result = instance.updateInventory(prodID, Quantity, updationType);
        assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AddProduct method, of class InventoryDatabase.
     */
    @Test
    public void testAddProduct() {
        System.out.println("AddProduct");
        Product prod = new Product("Toy","Mattel","1234567890");
        
        Client cl = new Client("10.105.25.137");
        try {
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            String expResult = "E002";
            String result = instance.AddProduct(prod);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class InventoryDatabase.
     */
    @Test
    public void testGetProduct() {
        try {
            System.out.println("getProduct");
            String productID = "1234567890";
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            Product result = instance.getProduct(productID);
            assertEquals("Toy", result.getName());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getProductList method, of class InventoryDatabase.
     */
    @Test
    public void testGetProductList() {
        try {
            System.out.println("getProductList");
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            List result = instance.getProductList();
            assertEquals(47, result.size());
        } catch (IOException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updatePrice method, of class InventoryDatabase.
     */
    @Test
    public void testUpdatePrice() {
        try {
            System.out.println("updatePrice");
            String productID = "1234567890";
            float newPrice = 10.0F;
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            String expResult = "UPDATED";
            String result = instance.updatePrice(productID, newPrice);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (IOException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updateDiscount method, of class InventoryDatabase.
     */
    @Test
    public void testUpdateDiscount() {
        try {
            System.out.println("updateDiscount");
            String prodID = "1234567890";
            float disc = 10.0F;
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            String expResult = "SUCCESS";
            String result = instance.updateDiscount(prodID, disc);
            assertEquals(expResult, result);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of editProduct method, of class InventoryDatabase.
     */
    @Test
    public void testEditProduct() {
        try {
            System.out.println("editProduct");
            Product product = new Product("Toy","Mattel","1234567890");
            product.setLocation("abcd");
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            String expResult = "SUCCESS";
            String result = instance.editProduct(product);
            assertEquals(expResult, result);
           
        } catch (IOException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Test
    public void testNewBill() {
        try {
            System.out.println("newBill");
            String sellerID = "SC0016";
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            String expResult = "000000000019";
            String result = instance.newBill(sellerID);
            assertEquals(expResult, result);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Test
    public void testAddBill() {
        try {
            System.out.println("addBill");
            SalesTransaction st = new SalesTransaction("SC0016");
            st.setTransID("000000000019");
            Client cl = new Client("10.105.25.137");
            cl.RunClient();
            InventoryDatabase instance = new InventoryDatabase(cl);
            String expResult = "SUCCESS";
            String result = instance.addBill(st);
            assertEquals(expResult, result);
           
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InventoryDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
