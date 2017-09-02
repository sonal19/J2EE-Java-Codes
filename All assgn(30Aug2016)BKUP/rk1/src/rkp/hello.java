package rkp;

import java.io.Console;  
import java.util.regex.*;  

public class hello extends Exception{  
	  public static void main(String[] args){  
	        
	        while (true) {  
	            Pattern pattern = Pattern.compile("rk");  
	            Matcher matcher = pattern.matcher("My name is rk .....rk is good rkrkt");  
	            boolean found = false;  
	            while (matcher.find()) {  
	                System.out.println("I found the text "+matcher.group()+" starting at index "+  
	                 matcher.start()+" and ending at index "+matcher.end());  
	                found = true;  
	            }  
	            if(!found){  
	                System.out.println("No match found."); 
	                break;
	            }  
	        }  
	    }  
}  