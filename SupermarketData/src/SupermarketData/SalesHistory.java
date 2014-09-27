
package SupermarketData;

import java.io.Serializable;

public class SalesHistory implements Serializable{
    private String productId;
    private float quantitySold;
    private String doS;
    private float cost;
    private float sellingprice;
    
    public SalesHistory(String pid, float quan, String doS, float cost, float sellingprice){
        productId = pid;
        quantitySold = quan;
        this.doS = doS;
        this.cost = cost;
        this.sellingprice = sellingprice;
    }
    public String getProductId(){
        return productId;
    }
    public float getQuantitySold(){
        return quantitySold;
    }
    public String getDateOfSale(){
        return doS;
    }
    public float getCostPrice(){
        return cost;
    }
    public float getSellingPrice(){
        return sellingprice;
    }
}
