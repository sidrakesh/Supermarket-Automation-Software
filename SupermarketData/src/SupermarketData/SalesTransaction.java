/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SupermarketData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author Sameer
 */
public class SalesTransaction implements Serializable{
private	List<Product> productList;  //adding the list of products in this array
private TimeStamp transTime;
private String sellerID;
private String transID;

public void setTransID(String id)
{
    transID = id;
}
public SalesTransaction(String sellerString)
{
    sellerID = sellerString;
    Calendar cal = Calendar.getInstance();
    transTime = new TimeStamp(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),cal.get(Calendar.HOUR),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
    productList = new ArrayList<>();
}
public TimeStamp getTime()
{
    return transTime;
}
public String getSellerID()
{
    return sellerID;
}
public String getTransID()
{
    return transID;
}
public List<Product> getItemsList()
{
    return productList;
}

public void deleteItem(String prodID)     //indicates that the product will be removed from the transaction
{
    int i;
    for(i=0;i<productList.size();i++)
    {
        if((productList.get(i)).getProductID().equals(prodID))
        {
            productList.remove(i);
            return;
        }
    }
}

public void addItem(Product p)
{
    
    productList.add(p);
}

public void deleteItem(String prodID,float quantity)
{
    int i;
    for(i=0;i<productList.size();i++)
    {
        if((productList.get(i)).getProductID().equals(prodID))
        {
            productList.get(i).updateQuantity(quantity, -1);
            return;
        }
    }
}
}
