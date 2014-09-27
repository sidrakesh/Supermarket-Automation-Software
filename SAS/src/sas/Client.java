
package sas;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {
    private Socket connection;
    private String serverAddress;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;
    
    public Client(String h){
        serverAddress = h;
    }
    public void RunClient() throws IOException, ClassNotFoundException{
        try{
            connectToServer();
            getStreams();
            
        }
        catch (EOFException eofexcept){                  
        }
        finally{
            //closeConnection();
        }
    }
    private void connectToServer() throws IOException, ClassNotFoundException{
        try{
        connection = new Socket(InetAddress.getByName(serverAddress),12323);
        }
        catch (IOException ex){
            int ch = JOptionPane.showConfirmDialog(null, "Unable to connect to the server, Retry connecting?");
            if(ch == JOptionPane.YES_OPTION){
                RunClient();
            }
            else {
                System.exit(-1);
            }
            }    
    }
    private void getStreams() throws IOException{
        writer = new ObjectOutputStream(connection.getOutputStream());
        writer.flush();
        reader = new ObjectInputStream(connection.getInputStream());   
    }

      public void closeConnection() throws IOException{
        
            writer.close();
            reader.close();
            connection.close();
    }
     public Object recieveData() throws IOException, ClassNotFoundException{
         Object message = reader.readObject();
         return message;
     }
     public void sendData(Object message) throws IOException{
        
            writer.writeObject(message);
            writer.flush();
        
    }
     public Socket getSocket(){
         return connection;
     }
     public String getServerAddress()
     {
         return serverAddress;
     }
}

