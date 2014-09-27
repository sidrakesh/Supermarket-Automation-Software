/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sas;

import SupermarketData.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Sameer
 */
public class InventoryDatabase {
    public static int ADD = 1;
    public static int DELETE = 0;
    private Client cl;
    
    public InventoryDatabase(Client cl){
        this.cl = cl;
    }   

    public String updateInventory(String prodID, float Quantity, int updationType)
    {
            try {
                int update = updationType;
                cl.sendData("UPDATEINV;"+prodID+";"+Quantity+";"+update);
                String reply = (String)cl.recieveData();
                return reply;
                //reply = "UPDATED" if inventory is updated
                //reply = "NOTFOUND" if inventory has no product with the supplied productID
            } catch (ClassNotFoundException | IOException ex) {
                return "E001";          //error in database connection
            }
    }
    public String AddProduct(Product prod){
            try {
                cl.sendData("ADDPRODUCT");
                cl.sendData(prod);
                String reply = (String)cl.recieveData();
                return reply;
                //reply = "UPDATED" if inventory is updated
            } catch (ClassNotFoundException | IOException ex) {
                return "E001";
            }
    }
    public Product getProduct(String productID)
    {
            try {
                cl.sendData("GETPROD;"+productID);
                String reply = (String)cl.recieveData();
                if(reply.startsWith("GETPROD1")){
                    Product p = (Product)cl.recieveData();
                    return p;
                }
                else{
                    return null;
                }
            } catch (IOException | ClassNotFoundException ex) {
                return null;
            }
    }

    public List<Product> getProductList(){
            try {
                cl.sendData("GETPRODLIST");
                String reply = (String)cl.recieveData();
                if(reply.startsWith("GETPRODLIST1")){
                    List<Product> lp = (List<Product>)cl.recieveData();
                    return lp;
                }
                else{
                    return null;
                }
            } catch (ClassNotFoundException | IOException ex) {
                return null;
            }
    }
    public String updatePrice(String productID, float newPrice)
    {
        if(newPrice<0)
        {	
            return "Data Error";
        }
        else
        {
                try {
                    cl.sendData("UPDATEPRICE;"+productID+";"+newPrice);
                    String reply = (String)cl.recieveData();
                    return reply;
                } catch (ClassNotFoundException | IOException ex) {
                    return "E001";
                }
        }
    }
    public String updateDiscount(String prodID, float disc){
            try {
                cl.sendData("UPDATEDISC;"+prodID+";"+disc);
                String reply = (String)cl.recieveData();
                if(reply.startsWith("UPDATED")){
                    return "SUCCESS";
                }
                else{
                    return "E002";
                }
            } catch (IOException | ClassNotFoundException ex) {
                return "E001";
            }
    }
    public String editProduct(Product product){
            try {
                cl.sendData("EDITPROD");
                String reply = (String)cl.recieveData();
                if(reply.startsWith("EDITPROD1")){
                    return "SUCCESS";
                }
                else{
                    return "E002";
                }
            } catch (ClassNotFoundException | IOException ex) {
                return "E001";
            }
    }
    public String removeProduct(String productID){
            try {
                cl.sendData("REMOVEPROD;"+productID);
                String reply = (String)cl.recieveData();
                if(reply.startsWith("REMOVEPROD1")){
                    return "SUCCESS";
                }
                else{
                    return "E002";
                }
            } catch (ClassNotFoundException | IOException ex) {
                return "E001";
            }
    }
    public String addBill(SalesTransaction st){
        try {
            cl.sendData("ADDBILL");
            cl.sendData(st);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("ADDBILL1")){
                return "SUCCESS";
            }
            else{
                return "FAILURE";
            }
        } catch (ClassNotFoundException | IOException ex) {
            return "E001";
        }
        
    }
    public String newBill(String sellerID){
        try {
            cl.sendData("NEWBILL;"+sellerID);
            String reply = (String)cl.recieveData();
            String id = reply.substring(8);
            return id;
        } catch (IOException | ClassNotFoundException ex) {
            return "E001";
        }    
    }
    public String CancelBill(String transID){
        try {
            cl.sendData("CANCELBILL;"+transID);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("CANCELBILL1")){
                return "SUCCESS";
            }
            else{
                return "FAILURE";
            }
        } catch (ClassNotFoundException | IOException ex) {
           return "E001";
        }
    }
    public HashMap<String,Float> getProfitStats(String beginDate, String endDate){
        try {
            cl.sendData("GETPROFITSTAT");
            String reply = (String)cl.recieveData();
            if(reply.startsWith("GETPROFITSTAT1")){
                HashMap<String,Float> hm = (HashMap<String,Float>)cl.recieveData();
                return hm;
            }
            else{
                return null;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }
    public HashMap<String,Float> getSellingPriceStats(String beginDate, String endDate){
        return null;
    }
    public List<SalesHistory> getSalesHistory(String prodId, String beginDate, String endDate){
        try {
            cl.sendData("GETSALEHISTORY;"+prodId+";"+beginDate+";"+endDate);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("GETSALEHISTORY1")){
                List<SalesHistory> lsh = (List<SalesHistory>)cl.recieveData();
                return lsh;
            }
            else{
                return null;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }
    public HashMap<String, Float> getOverallStats(String beginDate, String endDate){
        try {
            cl.sendData("OVERALLSTATPIE;"+beginDate+";"+endDate);
            String s = (String)cl.recieveData();
            if(s.startsWith("OVERALLSTATPIE1")){
                HashMap<String, Float> hm = (HashMap<String, Float>)cl.recieveData();
                return hm;
            }
            else{
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }
    public HashMap<String, Float> getOverallProfit(String beginDate, String endDate){
        try {
            cl.sendData("OVERALLPROFIT;"+beginDate+";"+endDate);
            String reply = (String)cl.recieveData();
            if(reply.startsWith("OVERALLPROFIT1")){
                HashMap<String, Float> hm = (HashMap<String, Float>)cl.recieveData();
                return hm;
            }
            else{
                return null;
            }
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
        
    }
}
