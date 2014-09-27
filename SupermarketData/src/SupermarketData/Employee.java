package SupermarketData;

import java.io.Serializable;




public class Employee implements Serializable{
    private String empID;
    private String fName;
    private String lName;
    private char sex;
    private String DOB;
    private String address;
    private String telephoneNumber;
    private String eMailId;
    private String password;
    private float salary;
    private String bankACNumber;

    public Employee(String newfName,String newlName,char gender,String regDOB)
    {
        fName = newfName;
        lName = newlName;
        sex = gender;
        empID = "";
        DOB = regDOB;
    }
    public String GetEmpID()
    {
        return empID;
    }
    public String GetfName()
    {
        return fName;
    }
    public String GetlName()
    {
        return lName;
    }
    public char GetSex()
    {
        return sex;
    }
    public String GetDOB()
    {
        return DOB;
    }
    public String GetAddress()
    {
        return address;
    }
    public void SetAddress(String newAddress)
    {
        address = newAddress;
    }
    public String GetTelephoneNumber()
    {
        return telephoneNumber;
    }
    public void SetTelephoneNumber(String newTelephoneNumber)
    {
        telephoneNumber = newTelephoneNumber;
    }
    public String GeteMailID()
    {
        return eMailId;
    }
    public void SeteMailID(String neweMailID)
    {
        eMailId = neweMailID;
    }
    public String GetPassword()
    {
        return password;
    }
    public void SetPassword(String newPassword)
    {
        password = newPassword;
    }
    public float GetSalary()
    {
        return salary;
    }
    public void SetSalary(float newSalary)
    {
        salary = newSalary;
    }
    public String GetBankACNumber()
    {
        return bankACNumber;
    }
    public void SetBankACNumber(String NewBankACNumber)
    {
        bankACNumber = NewBankACNumber;
    }
    public void setEmpID(String ID){
        empID = ID;
    }
}
