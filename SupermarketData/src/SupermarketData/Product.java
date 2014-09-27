package SupermarketData;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sameer
 */
public class Product implements Serializable{
    private String productID;
    private String name;
    private String manufacturer;
    private String location;
    private float cost;
    private String description;
    private float discount;
    private float quantity;
    private float MRP;
    private static int ADD = 1;
    private static int DELETE = -1;

    public Product(String nameString,String manufacturerString,String productIDString)
    {
        quantity = 0;
        name = nameString;
        manufacturer = manufacturerString;
        productID = productIDString;
    }
    public float calcProfit()
    {
        return ((100-discount)/100)*MRP-cost;
    }
    
    public void updateQuantity(float newQuantityUpdate,int updateType)
    {
        if(updateType==ADD)
        {
            quantity += newQuantityUpdate;
        }	
        else if(updateType==DELETE)
        {
            quantity -= newQuantityUpdate;
        }
    }
    public String getProductID()
    {
        return productID;
    }
    public String getName()
    {
        return name;
    }
    public String getManufacturer()
    {
        return manufacturer;
    }
    public float getMRP()
    {
        return MRP;
    }
    public void setMRP(float MRPVal)
    {
        MRP = MRPVal;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String desc)
    {
        description = desc;
    }
    public float getCost()
    {
        return cost;
    }
    public void setCost(float costVal)
    {
        cost = costVal;
    }
    public float getDiscount()
    {
        return discount;
    }
    public void setDiscount(float discountVal)
    {
        discount = discountVal;
    }
    public float getQuantity()
    {
        return quantity;
    }
    public void setQuantity(float quantityVal)
    {
        quantity = quantityVal;
    }
    public void setLocation(String loc)
    {
        location = loc;
    }
    public String getLocation()
    {
        return location;
    }
}
