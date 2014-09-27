
package serversas;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ServerSAS {
public static void main(String[] args) throws ClassNotFoundException {
        
    try {
        // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
       // handle exception
    }
    Server server = new Server();
    server.setSize(300, 150);
    server.setVisible(true);
    server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    server.runServer();
    }
}
