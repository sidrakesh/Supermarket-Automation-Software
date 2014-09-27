/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SupermarketData;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author in dia
 */
public class ProductTest {
    
    public ProductTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of calcProfit method, of class Product.
     */
    @org.junit.Test
    public void testCalcProfit() {
        System.out.println("calcProfit");
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setCost(10);
        instance.setDiscount(10);
        instance.setMRP(20);
        float expResult = 8;
        float result = instance.calcProfit();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateQuantity method, of class Product.
     */
    @org.junit.Test
    public void testUpdateQuantity() {
        System.out.println("updateQuantity");
        float newQuantityUpdate = 10;
        int updateType = 1;
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.updateQuantity(newQuantityUpdate, updateType);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProductID method, of class Product.
     */
    @org.junit.Test
    public void testGetProductID() {
        System.out.println("getProductID");
        Product instance = new Product("Toy","Mattel","1234567890");
        String expResult = "1234567890";
        String result = instance.getProductID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Product.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product("Toy","Mattel","1234567890");
        String expResult = "Toy";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getManufacturer method, of class Product.
     */
    @org.junit.Test
    public void testGetManufacturer() {
        System.out.println("getManufacturer");
        Product instance = new Product("Toy","Mattel","1234567890");
        String expResult = "Mattel";
        String result = instance.getManufacturer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMRP method, of class Product.
     */
    @org.junit.Test
    public void testGetMRP() {
        System.out.println("getMRP");
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setMRP(10);
        float expResult = 10;
        float result = instance.getMRP();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMRP method, of class Product.
     */
    @org.junit.Test
    public void testSetMRP() {
        System.out.println("setMRP");
        float MRPVal = 10;
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setMRP(MRPVal);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Product.
     */
    @org.junit.Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setDescription("This is a toy");
        instance.getDescription();
        String expResult = "This is a toy";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Product.
     */
    @org.junit.Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String desc = "This is a toy";
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setDescription(desc);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCost method, of class Product.
     */
    @org.junit.Test
    public void testGetCost() {
        System.out.println("getCost");
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setCost(10);
        float expResult = 10;
        float result = instance.getCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCost method, of class Product.
     */
    @org.junit.Test
    public void testSetCost() {
        System.out.println("setCost");
        float costVal = 10;
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setCost(costVal);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscount method, of class Product.
     */
    @org.junit.Test
    public void testGetDiscount() {
        System.out.println("getDiscount");
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setDiscount(10);
        float expResult = 10;
        float result = instance.getDiscount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDiscount method, of class Product.
     */
    @org.junit.Test
    public void testSetDiscount() {
        System.out.println("setDiscount");
        float discountVal = 10;
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setDiscount(discountVal);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Product.
     */
    @org.junit.Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setQuantity(100);
        float expResult = 100;
        float result = instance.getQuantity();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class Product.
     */
    @org.junit.Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        float quantityVal = 100;
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setQuantity(quantityVal);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Product.
     */
    @org.junit.Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String loc = "F1-1";
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setLocation(loc);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Product.
     */
    @org.junit.Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Product instance = new Product("Toy","Mattel","1234567890");
        instance.setLocation("F1-1");
        String expResult = "F1-1";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
