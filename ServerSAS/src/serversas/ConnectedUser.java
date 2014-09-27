
package serversas;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectedUser {
    private String empID;
    private Socket connection;
    private ObjectOutputStream os;
    
    public ConnectedUser(Socket C){
        connection = C;
        empID = "";
        try {
            os = new ObjectOutputStream(connection.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ConnectedUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Socket getSocket(){
        return connection;
    }
    public String getEmpID(){
        return empID;
    }
    public void setEmpID(String id){
        empID = id;
    }
    public void sendData(Object s){
        try {
            os.writeObject(s);
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConnectedUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeOutput() throws IOException{
        os.close();
    }
}
