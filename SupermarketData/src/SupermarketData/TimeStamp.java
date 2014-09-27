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
public class TimeStamp implements Serializable{
    private int year;
    private int month;
    private int date;
    private int hour;
    private int minute;
    private int second;
    
    public TimeStamp(int newYear,int newMonth,int newDate,int newHour,int newMinute,int newSecond)
    {
        year = newYear;
        month = newMonth;
        date = newDate;
        hour = newHour;
        minute = newMinute;
        second = newSecond;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getDate()
    {
        return date;
    }
    
    public int getHour()
    {
        return hour;
    }
    
    public int getMinute()
    {
        return minute;
    }
    
    public int getSecond()
    {
        return second;
    }
}
