package serversas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import SupermarketData.*;
import java.util.*;

public class Server extends JFrame {
    
    private JTextArea textarea;
    private ServerSocket server;
    private Socket connection;  
    private Map<Integer, ConnectedUser> OnlineUsers = new HashMap<>();
    private List<Integer> portsInUse;
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/SAS";
    Connection SQLconnection = null;
    Statement SQLstatement = null;
    
    public Server() {
        super("Server");
        connection = new Socket();    
        textarea = new JTextArea();
        portsInUse = new ArrayList<>();
        add(new JScrollPane(textarea));
        
        //connecting to the database
        try {
            Class.forName(JDBC_Driver);
            int flag = 0;
            String id, pass;
            int error = 0;
            do{
                final DatabaseLogin login = new DatabaseLogin(new JFrame(),true);
                login.showError(error);
                login.setLocationRelativeTo(null);
                login.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosing(WindowEvent e){
                        login.cancel();
                        System.exit(0);
                    }
                });
                login.setVisible(true);
                if(!login.isCanceled()){
                    id = login.getLoginID();
                    pass = login.getPassword();
                    try {
                        SQLconnection = DriverManager.getConnection(DATABASE_URL,id,pass);
                        SQLstatement = SQLconnection.createStatement();
                        flag=1;
                        
                    } catch (SQLException ex) {
                        flag = 0;
                        error = 2;
                    }
                }
                else{
                    System.exit(0);
                }
            }while(flag==0);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void runServer() throws ClassNotFoundException {
        try {
            
            server = new ServerSocket(12323);
            portsInUse.add(12323);
            int count = 0;
            while(true){
                try {
                    displayMessage("Waiting for Connection");
                    connection = server.accept();
                    count++;
                    System.out.printf("\ncount = %d",count);
                    ConnectedUser cU = new ConnectedUser(connection);
                    OnlineUsers.put(count, cU);
                    displayMessage("\nUser " + count + " connected");
                    user u = new user(count);
                    new Thread(u).start();
                
                } catch (EOFException eofexception) {
                    displayMessage("Server Terminated Connection");
                } 
            }
        } catch (IOException ioex) {
        }        
    }   

    private void displayMessage(final String str) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                textarea.append(str);
            }
        });
    }
    
    private class user implements Runnable{
        private int userNumber;
        private ObjectInputStream input;
        //set up user thread
        public user(int i){
            try {
                userNumber = i; 
                input = new ObjectInputStream(OnlineUsers.get(userNumber).getSocket().getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
        
        public void run(){
            //try {
                String msg;
                int flag;
                displayMessage("\nUser " + userNumber + " online");
            try {
                do{
                    msg = (String) input.readObject();
                    
                    
                    /*employee related
                    LOGIN Command is sent by the client along with login details*/
                    if(msg.startsWith("LOGIN")){
                        String details[] = msg.split(";");
                        String Id = details[1].substring(4);
                        ResultSet rs = SQLstatement.executeQuery("SELECT password, isWorking FROM employee WHERE empID = '"+Id+"'");
                        if(!rs.next()){
                            sendData("LOGIN0",userNumber);
                        }
                        else{
                            
                                if((Integer)rs.getObject("isWorking")==0){
                                   
                                    sendData("LOGIN0",userNumber);
                                }
                                else{
                                if(!details[2].equals((String)rs.getObject("password"))){
                                    sendData("LOGIN0",userNumber);
                                }
                                else{
                                    OnlineUsers.get(userNumber).setEmpID(details[1]);
                                    sendData("LOGIN1",userNumber);
                                }
                                }
                        }
                    }
                    else if(msg.startsWith("LOGOUT")){
                        break;
                    }
                    /*command to add a sales clerk is sent by the client*/
                    else if(msg.startsWith("ADDEMPSC")){
                        SalesClerk sc = (SalesClerk)input.readObject();
                        ResultSet result = SQLstatement.executeQuery("SELECT empId from Employee WHERE email = '"+sc.GeteMailID()+"'");
                        if(result.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            String pass = getRandomPassword(8);
                            SQLstatement.executeUpdate("INSERT INTO Employee(fname,lname,sex,dob,address,phone,email,salary,type,password,ACNumber,IsWorking)"
                                    + " VALUES('"+sc.GetfName()+"','"+sc.GetlName()+"','"+sc.GetSex()+"','"+sc.GetDOB()+"','"+sc.GetAddress()+"','"+sc.GetTelephoneNumber()+"','"+sc.GeteMailID()+"',"+sc.GetSalary()+",'SC','"+pass+"','"+sc.GetBankACNumber()+"',1)");
                            ResultSet rs = SQLstatement.executeQuery("SELECT empId FROM Employee WHERE email = '"+sc.GeteMailID()+"'");
                            if(rs.next()){
                            String empId = "SC00"+rs.getObject("empId");
                            sendData("ADDEMPSC1;"+empId+";"+pass,userNumber);
                            }
                        }
                    }
                    
                    /*Command to add a supermarket staff is sent by the client*/
                    else if(msg.startsWith("ADDEMPSS")){
                       SupermarketStaff ss= (SupermarketStaff)input.readObject();
                        ResultSet result = SQLstatement.executeQuery("SELECT empId from Employee WHERE email = '"+ss.GeteMailID()+"'");
                        if(result.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            String pass = getRandomPassword(8);
                            SQLstatement.executeUpdate("INSERT INTO Employee(fname,lname,sex,dob,address,phone,email,salary,type,password,ACNumber,IsWorking)"
                                    + " VALUES('"+ss.GetfName()+"','"+ss.GetlName()+"','"+ss.GetSex()+"','"+ss.GetDOB()+"','"+ss.GetAddress()+"','"+ss.GetTelephoneNumber()+"','"+ss.GeteMailID()+"',"+ss.GetSalary()+",'SS','"+pass+"','"+ss.GetBankACNumber()+"',1)");
                            ResultSet rs = SQLstatement.executeQuery("SELECT empId FROM Employee WHERE email = '"+ss.GeteMailID()+"'");
                            if(rs.next()){
                            String empId = "SS00"+rs.getObject("empId");
                            sendData("ADDEMPSS1;"+empId+";"+pass,userNumber);
                            
                            }
                        }
                    }
                    else if(msg.startsWith("EDITEMPSC")){
                        SalesClerk sc = (SalesClerk)input.readObject();
                        ResultSet result = SQLstatement.executeQuery("SELECT fname FROM employee WHERE empId = "+sc.GetEmpID().substring(4));
                        if(!result.next()){
                            sendData("E002",userNumber);
                            System.out.println("kya hai");
                        }
                        else{
                            
                            SQLstatement.executeUpdate("UPDATE employee SET address = '"+sc.GetAddress()+"', location = '"+sc.getLocation()+"', phone = '"+sc.GetTelephoneNumber()+
                                    "', email = '"+sc.GeteMailID()+"', salary = "+sc.GetSalary()+", ACNumber = '"+sc.GetBankACNumber()+"' WHERE empId = "+sc.GetEmpID().substring(4));
                            sendData("EDITEMPSC1",userNumber);
                            
                        }
                    }
                    else if(msg.startsWith("EDITEMPSS")){
                        SupermarketStaff sc = (SupermarketStaff)input.readObject();
                        ResultSet result = SQLstatement.executeQuery("SELECT fname from Employee WHERE empId = "+sc.GetEmpID().substring(4));
                        if(!result.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            
                            SQLstatement.executeUpdate("UPDATE employee SET address = '"+sc.GetAddress()+"', location = '"+sc.getLocation()+"', phone = '"+sc.GetTelephoneNumber()+
                                    "', email = '"+sc.GeteMailID()+"', salary = "+sc.GetSalary()+", ACNumber = '"+sc.GetBankACNumber()+"' WHERE empId = "+sc.GetEmpID().substring(4));
                            sendData("EDITEMPSS1",userNumber);
                            
                        }
                    }
                    /*command to get the list of all employees is send by the client*/
                    else if(msg.startsWith("GETEMPLIST")){
                        ResultSet set = SQLstatement.executeQuery("SELECT empId, fname, lname, type, isWorking from Employee");
                        HashMap<String, String> hm = new HashMap<>();
                        String empID;
                        while(set.next()){
                            if((Integer)set.getObject("isWorking")==1){
                            empID = (String)set.getObject("type")+"00"+set.getObject("empId");
                            hm.put(empID,(String)set.getObject("fname")+" "+(String)set.getObject("lname"));
                            }
                        }
                        sendData("GETEMPLIST1",userNumber);
                        sendData(hm,userNumber);
                    }
                    
                    /*commant to get the details of a particular employee is sent by the client*/
                    else if(msg.startsWith("GETEMP")){
                        String[] details = msg.split(";");
                       
                            String id = details[1].substring(4);
                            System.out.printf("%s",id);
                            ResultSet rs = SQLstatement.executeQuery("SELECT * FROM Employee WHERE empId = '"+id+"'");
                            if(rs.next()){
                            if(details[1].startsWith("SC")){
                                SalesClerk sc = new SalesClerk((String)rs.getObject("fname"),(String)rs.getObject("lname"),((String)rs.getObject("sex")).charAt(0),(String)rs.getObject("dob"));
                                sc.SetAddress((String)rs.getObject("address"));
                                sc.SetBankACNumber((String)rs.getObject("ACNumber"));
                                sc.SetSalary((Float)rs.getObject("salary"));
                                sc.setEmpID("SC00"+rs.getObject("empId"));
                                sc.setLocation(""+rs.getObject("location"));
                                sc.SetTelephoneNumber(""+rs.getObject("phone"));
                                sc.SeteMailID(""+rs.getObject("email"));
                                sendData("GETEMP1",userNumber);
                                sendData(sc,userNumber);
                            }
                            else if(details[1].startsWith("SS")){
                                SupermarketStaff sc = new SupermarketStaff((String)rs.getObject("fname"),(String)rs.getObject("lname"),((String)rs.getObject("sex")).charAt(0),(String)rs.getObject("dob"));
                                sc.SetAddress((String)rs.getObject("address"));
                                sc.SetBankACNumber((String)rs.getObject("ACNumber"));
                                sc.SetSalary((Float)rs.getObject("salary"));
                                sc.setEmpID("SS00"+rs.getObject("empId"));
                                sc.setLocation(""+rs.getObject("location"));
                                sc.SetTelephoneNumber(""+rs.getObject("phone"));
                                sc.SeteMailID(""+rs.getObject("email"));
                                sendData("GETEMP1",userNumber);
                                sendData(sc,userNumber);
                            }
                            else if(msg.startsWith("MA")) {
                                Manager m = new Manager((String)rs.getObject("fname"),(String)rs.getObject("lname"),((String)rs.getObject("sex")).charAt(0),(String)rs.getObject("dob"));
                                m.SetAddress((String)rs.getObject("address"));
                                m.SetBankACNumber((String)rs.getObject("ACNumber"));
                                m.SetSalary((Float)rs.getObject("salary"));
                                m.setEmpID("SS00"+rs.getObject("empId"));
                                m.setRoomNumber(""+rs.getObject("location"));
                                m.SetTelephoneNumber(""+rs.getObject("phone"));
                                m.SeteMailID(""+rs.getObject("email"));
                                sendData("GETEMP1",userNumber);
                                sendData(m,userNumber);
                            }
                            else{
                                sendData("E003",userNumber);  //E003 means invalid id
                            }
                            }
                            else{
                                sendData("E004",userNumber);  //E004 means no employee found by this id
                            }
                    }
                    else if(msg.startsWith("FIREEMP")){
                        String[] details = msg.split(";");
                        String Id = details[1].substring(4);
                        ResultSet rs = SQLstatement.executeQuery("Select email from employee WHERE empId = "+Id);
                        if(!rs.next()){
                            sendData("E004",userNumber);
                        }
                        else{
                            
                            SQLstatement.executeUpdate("UPDATE Employee SET isWorking = 0 WHERE empId = "+Id);
                            sendData("FIRED",userNumber);
                        }
                    }
                    else if(msg.startsWith("CHANGEPASS")){
                        String details[] = msg.split(";");
                        String Id = details[1].substring(4);
                        ResultSet rs = SQLstatement.executeQuery("SELECT password FROM employee WHERE empId = "+Id+"");
                        if(rs.next()){
                            if(details[2].equals((String)rs.getObject("password"))){
                                SQLstatement.executeUpdate("UPDATE employee SET password = '"+details[3]+"' WHERE empId = "+Id);
                                sendData("CHANGED",userNumber);
                            }
                            else{
                                sendData("IPASS",userNumber);
                            }
                        }
                        else{
                            sendData("E002",userNumber);
                        }
                    }
                    
                    /* product related commands */
                    else if(msg.startsWith("ADDPRODUCT")){
                        Product p = (Product)input.readObject();
                        ResultSet rs = SQLstatement.executeQuery("SELECT * FROM Product WHERE productId='"+p.getProductID()+"'");
                        if(rs.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            Calendar cal = Calendar.getInstance();
                            int mnth = cal.get(Calendar.MONTH)+1;
                            String date = mnth+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR);
                            SQLstatement.executeUpdate("INSERT INTO product(productId,name,manufacturer,cost,description,discount,quantity,mrp,location)"
                                    + " VALUES('"+p.getProductID()+"','"+p.getName()+"','"+p.getManufacturer()+"',"+p.getCost()+",'"+p.getDescription()+"',"+p.getDiscount()+","+p.getQuantity()+
                                    ","+p.getMRP()+",'"+p.getLocation()+"')");
                            SQLstatement.executeUpdate("INSERT INTO productStock(productId, doP, quantity)"
                                    + " VALUES('"+p.getProductID()+"','"+date+"',"+p.getQuantity()+")"); 
                            sendData("UPDATED",userNumber);
                        }
                    }
                    else if(msg.startsWith("UPDATEINV")){
                        String details[] = msg.split(";");
                        if(details.length<3){
                            sendData("NOTFOUND",userNumber);
                        }
                        ResultSet rs = SQLstatement.executeQuery("SELECT * FROM Product WHERE productId = '"+details[1]+"'");
                        if(!rs.next()){
                            sendData("NOTFOUND",userNumber);
                        }
                        else{
                            float quantity = (float)rs.getObject("quantity");
                            float more = Float.parseFloat(details[2]);
                            if(details[3].compareTo("1")==0)
                                quantity += more;
                            else{
                                quantity-=more;
                            }
                            Calendar cal = Calendar.getInstance();
                            int mnth = cal.get(Calendar.MONTH)+1;
                            String date = mnth+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR);
                            SQLstatement.executeUpdate("UPDATE Product SET quantity = "+quantity+"WHERE productId = '"+details[1]+"'");
                            SQLstatement.executeUpdate("INSERT INTO productStock(productId, doP, quantity)"
                                    + " VALUES('"+details[1]+"','"+date+"',"+quantity+")");
                            sendData("UPDATED",userNumber);
                        }
                    }
                    else if(msg.startsWith("UPDATEDISC;")){
                        String details[] = msg.split(";");
                        ResultSet rs = SQLstatement.executeQuery("SELECT discount FROM Product WHERE productID = '"+details[1]+"'");
                        if(!rs.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            SQLstatement.executeUpdate("UPDATE Product SET discount = "+details[2]+" WHERE productID = '"+details[1]+"'");
                            sendData("UPDATED",userNumber);
                        }
                    }
                    else if(msg.startsWith("UPDATEPRICE;")){
                        String details[] = msg.split(";");
                        ResultSet rs = SQLstatement.executeQuery("SELECT MRP FROM Product WHERE productID = '"+details[1]+"'");
                        if(!rs.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            Calendar cal = Calendar.getInstance();
                            int mnth = cal.get(Calendar.MONTH)+1;
                            String date = cal.get(Calendar.YEAR)+"/"+mnth+"/"+cal.get(Calendar.DATE);
                            SQLstatement.executeUpdate("UPDATE Product SET MRP = "+details[2]+" WHERE productID = '"+details[1]+"'");
                            SQLstatement.executeUpdate("INSERT INTO priceupdate(productId, doC, price) VALUES('"+details[1]+"','"+date+"',"+details[2]+")");
                            sendData("UPDATED",userNumber);
                        }
                    }
                    else if(msg.startsWith("GETPRODLIST")){
                        ResultSet rs = SQLstatement.executeQuery("SELECT * FROM product");
                        List<Product> lp = new ArrayList<>();
                        while(rs.next()){
                            Product p = new Product((String)rs.getObject("name"),(String)rs.getObject("manufacturer"),(String)rs.getObject("productID"));
                            p.setCost((Float)rs.getObject("cost"));
                            p.setDescription((String)rs.getObject("description"));
                            p.setDiscount((Float)rs.getObject("discount"));
                            p.setMRP((Float)rs.getObject("MRP"));
                            p.setQuantity((Float)rs.getObject("quantity"));
                            p.setLocation((String)rs.getObject("location"));
                            lp.add(p);
                        }
                        sendData("GETPRODLIST1",userNumber);
                        sendData(lp,userNumber);
                    }
                    else if(msg.startsWith("GETPROD")){
                        String[] details = msg.split(";");
                        ResultSet rs = SQLstatement.executeQuery("SELECT * FROM product WHERE productId = '"+details[1]+"'");
                        if(!rs.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            Product p = new Product((String)rs.getObject("name"),(String)rs.getObject("manufacturer"),(String)rs.getObject("productID"));
                            p.setCost((Float)rs.getObject("cost"));
                            p.setDescription((String)rs.getObject("description"));
                            p.setDiscount((Float)rs.getObject("discount"));
                            p.setMRP((Float)rs.getObject("MRP"));
                            p.setQuantity((Float)rs.getObject("quantity"));
                            p.setLocation((String)rs.getObject("location"));
                            sendData("GETPROD1",userNumber);
                            sendData(p,userNumber);
                        }
                    }
                    else if(msg.startsWith("EDITPROD")){
                        Product p = (Product)input.readObject();
                        ResultSet rs = SQLstatement.executeQuery("SELECT name FROM Product ");
                        SQLstatement.executeUpdate("UPDATE Employee SET name='"+p.getName()+"', manufacturer = '"+p.getManufacturer()+"', cost = "+p.getCost()+
                                                    ", description = '"+p.getDescription()+"',  discount = "+p.getDiscount()+", quantity = "+p.getQuantity()+", mrp = "+p.getMRP()+", location = '"+p.getLocation()+"' WHERE productId = '"+p.getProductID()+"'");
                        sendData("EDITPROD1",userNumber);
                    }
                    else if(msg.startsWith("REMOVEPROD")){
                        String details[] = msg.split(";");
                        ResultSet rs = SQLstatement.executeQuery("SELECT name FROM product WHERE productId = '"+details[1]+"'");
                        if(!rs.next()){
                            sendData("E002",userNumber);
                        }
                        else{
                            SQLstatement.executeUpdate("DELETE FROM product WHERE productId = '"+details[1]+"'");
                            sendData("REMOVEPROD1",userNumber);
                        }
                    }
                    else if(msg.startsWith("NEWBILL")){
                        String details[] = msg.split(";");
                        String idd = details[1].substring(4);
                        ResultSet rs = SQLstatement.executeQuery("SELECT fname FROM Employee WHERE empId = "+idd);
                        if(!rs.next()){
                                sendData("E002",userNumber);
                        }
                        SQLstatement.executeUpdate("INSERT INTO transcation(SellerId) VALUES('"+idd+"')");
                        rs = SQLstatement.executeQuery("SELECT MAX(transID) FROM transcation WHERE sellerID = "+idd);
                        while(rs.next()){
                        Integer id = (Integer)rs.getObject("MAX(transID)");
                        int Id = id;
                        int c =0;
                        
                        while(Id>0){
                            c++;
                            Id/=10;
                        }
                        char[] i = new char[12-c];
                        for(int x = 0;x<12-c;x++){
                         i[x]='0';   
                        }
                        
                        String ID = (new String(i))+id;  
                        sendData("NEWBILL;"+ID,userNumber);
                        }
                    }
                    else if(msg.startsWith("ADDBILL")){
                        SalesTransaction bill = (SalesTransaction)input.readObject();
                        List<Product> lp = bill.getItemsList();
                        String doS,toS;
                        doS = bill.getTime().getYear()+"/"+bill.getTime().getMonth()+"/"+bill.getTime().getDate();
                        toS = bill.getTime().getHour()+":"+bill.getTime().getMinute();
                        int transid = Integer.parseInt(bill.getTransID());
                        for(Product p:lp){
                            SQLstatement.executeUpdate("INSERT INTO saleshistory(ProductID, doS ,toS, quantitySold, transId, costPrice, sellingPrice)"
                                    + " VALUES('"+p.getProductID()+"','"+doS+"','"+toS+"',"+p.getQuantity()+","+transid+","+p.getCost()+","+p.getMRP()+")");                
                            SQLstatement.executeUpdate("UPDATE product SET quantity = quantity - "+p.getQuantity()+" WHERE productId = '"+p.getProductID()+"'");
                        }
                        sendData("ADDBILL1",userNumber);
                    }
                    else if(msg.startsWith("CANCELBILL")){
                        String details[] = msg.split(";");
                        SQLstatement.executeUpdate("DELETE FROM transcation WHERE transId = "+details[1]);
                        sendData("CANCELBILL1",userNumber);
                    }
                    else if(msg.startsWith("GETPROFITSTAT")){
                        String[] details = msg.split(";");
                        ResultSet rs = SQLstatement.executeQuery("SELECT SUM((sellingPrice-costPrice)*quantitySold) as Profit, doS FROM saleshistory"
                                + " WHERE productId = '"+details[1]+"'"
                                + " AND doS BETWEEN '"+details[2]+"' AND '"+details[3]+"'"
                                + "GROUP BY doS");
                        HashMap<String,Float> hm = new HashMap<>();
                       while(rs.next()){
                           hm.put((String)rs.getObject("doS"), (Float)rs.getObject("Profit"));
                       }
                       sendData("GETPROFITSTAT1",userNumber);
                       sendData(hm,userNumber);
                    }
                    
                    else if(msg.startsWith("GETSALEHISTORY")){
                        String[] details = msg.split(";");
                        ResultSet rs = SQLstatement.executeQuery("SELECT SUM(quantitySold) as quantity, doS, costPrice, sellingPrice FROM saleshistory"
                                + " WHERE productId = '"+details[1]+"'"
                                + " AND doS BETWEEN '"+details[2]+"' AND '"+details[3]+"'"
                                + "GROUP BY doS");
                        List<SalesHistory> lsh = new ArrayList<>();
                        
                        while(rs.next()){
                            Double x = (Double)rs.getObject("quantity");
                            Float f = new Float(x);
                            
                            SalesHistory sh = new SalesHistory(details[1],f,(String)rs.getObject("doS"),(Float)rs.getObject("costPrice"),(Float)rs.getObject("sellingPrice"));
                            lsh.add(sh);
                        }
                        sendData("GETSALEHISTORY1",userNumber);
                        sendData(lsh,userNumber);
                    }
                    else if(msg.startsWith("OVERALLSTATPIE")){
                        String[] details = msg.split(";");
                        ResultSet rs = SQLstatement.executeQuery("SELECT product.name as name, SUM((sellingPrice-costPrice)*quantitySold) as profit"
                                + " FROM saleshistory "
                                + "INNER JOIN product "
                                + "ON (product.productId = saleshistory.productId)"
                                + " WHERE doS BETWEEN '"+details[1]+"' AND '"+details[2]
                                + "' GROUP BY product.productId");
                        HashMap<String, Float> hm = new HashMap<>();
                        while(rs.next()){
                            String name = (String)rs.getObject("name");
                            Double d = (Double)rs.getObject("profit");
                            Float f = new Float(d);
                                hm.put(name,f);
                            
                        }
                        
                        sendData("OVERALLSTATPIE1",userNumber);
                        sendData(hm,userNumber);
                    }
                    else if(msg.startsWith("OVERALLPROFIT")){
                        String details[] = msg.split(";");
                        
                        ResultSet rs = SQLstatement.executeQuery("SELECT doS, SUM((sellingPrice-costPrice)*quantitySold) as profit FROM saleshistory"
                                + " WHERE doS BETWEEN '"+details[1]+"' AND '"+details[2]+"'"
                                + " GROUP BY doS"); 
                        HashMap<String, Float> hm = new HashMap<>();
                        
                        while(rs.next()){
                            Double x = (Double)rs.getObject("profit");
                            Float f = new Float(x);
                            hm.put((String)rs.getObject("doS"),f);
                        }
                        sendData("OVERALLPROFIT1",userNumber);
                        sendData(hm,userNumber);
                    }
                }while(true);
             
            } catch (    SQLException | IOException | ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    OnlineUsers.get(userNumber).closeOutput();
                    OnlineUsers.remove(userNumber);
                    input.close();
                } catch (IOException ex) {
                    
                }
            }
        }
                
        }
         private void sendData(Object message,int uN) throws IOException {
        
        OnlineUsers.get(uN).sendData(message);
        
         }
          public void sendToAll(Object message){
        
            for(int p: OnlineUsers.keySet()){
            OnlineUsers.get(p).sendData(message);
            }
        
    }
          private String getRandomPassword(int len){
              String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
              Random rnd = new Random();
              StringBuilder sb = new StringBuilder( len );
              for( int i = 0; i < len; i++ ) {
                  sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
              }
              return sb.toString();

          }
         
 
}
