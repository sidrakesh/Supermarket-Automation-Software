package SupermarketData;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author 
 */
public class Manager extends Employee implements Serializable{
    private String roomNumber;

    public Manager(String newfName,String newlName,char gender,String regDOB){
    super(newfName,newlName,gender,regDOB);
    }
    public String getRoomNumber()
    {
        return roomNumber;
    }
    public void setRoomNumber(String newRoomNumber)
    {
        roomNumber = newRoomNumber;
    }
}
