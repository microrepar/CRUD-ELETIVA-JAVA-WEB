package br.com.eletivajavaweb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteDataHora {

	public static String converteDataString(Date dtData){  
		SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy HH:mm");		  	     
		return (formatBra.format(dtData)); 
	} 
		
	public static Date converteStringData(String data) {   
		if (data == null || data.equals(""))  
			return null;  

		Date date = null;  
		try {  
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
			date = (java.util.Date)formatter.parse(data.replace("-", "/"));  
			return date;
		} catch (ParseException e) {              
			e.printStackTrace();
		}  
		return null;
	}
	
}

