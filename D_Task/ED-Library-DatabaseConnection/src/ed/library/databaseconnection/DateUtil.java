/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.library.databaseconnection;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author iOSDev
 */
public class DateUtil {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String TIME_FORMAT = "HH:mm";

    /**
     * Receives a date as a String object, converting to LocalDate object 
     * 
     * @param       aDate   a string date object to convert
     * @return      LocalDate object
     */ 
    public static Date convertDate(String aDate) 
    {
        try {
            // Hard code date format to dd/MM/YYYY
            DateTimeFormatter format = DateTimeFormatter.ofPattern (DATE_FORMAT);
            return java.sql.Date.valueOf(LocalDate.parse (aDate , format));
        } 
        catch (DateTimeParseException ex) {
            throw ex;
        }
    }
    
    public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }


    /**
     * Receives a String object, converting to LocalTime object 
     * 
     * @param       aTime   a string time object to convert
     * @return      LocalTime object
     */ 
    public static LocalTime convertTime(String aTime) 
    {
        try {
            // Hard code time format to HH:mm
            DateTimeFormatter format = DateTimeFormatter.ofPattern (TIME_FORMAT);
            return LocalTime.parse (aTime , format);
        } 
        catch (DateTimeParseException ex) {
            throw ex;
        }
    }

    /**
     * Receives a LocalTime object, converting to string 
     * 
     * @param       aTime   a time to convert
     * @return      time as formatted string
     */     
    public static String timeToString(LocalTime aTime, String format) 
    {
        if (aTime != null && format != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return aTime.format(formatter);
        }
        return "";
    }

    /**
     * Receives a LocalDate object, converting to string 
     * 
     * @param       aDate   a date to convert
     * @return      date as formatted string
     */     
    public static String dateToString(LocalDate aDate, String format) 
    {
        if (aDate != null && format != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return aDate.format(formatter);
        }
        return "";
    }
}
