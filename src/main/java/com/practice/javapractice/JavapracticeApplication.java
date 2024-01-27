package com.practice.javapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JavapracticeApplication {

	private static final Logger logger = LogManager.getLogger(JavapracticeApplication.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(JavapracticeApplication.class, args);
		  logger.trace("1.This is a TRACE message.");
	        logger.debug("2.This is a DEBUG message.");
	        logger.info("3.This is an INFO message.");
	        logger.warn("4.This is a WARN message.");
	        logger.error("5.This is an ERROR message.");
	        
	        try
	        {
	           int n =100/0;
	           
	           System.out.println("ff"+n );
	        }        
	        catch (ArithmeticException ex)
	        {
	            System.out.println("Arithmetic " + ex);
	        }
	        catch (NumberFormatException ex)
	        {
	            System.out.println("Number Format Exception " + ex);
	        }
	        catch (Exception ex) {
				// TODO: handle exception
	        	System.out.println("Exception " + ex);
			}
//	        int c = "vikash".hashCode();
//	        System.out.println(c);
	        
//	    HashMap<String, Integer> map = new HashMap<String, Integer>();
//	    map.put("vikash", 25);
//	    map.put("rahul", 30);
//	    map.put("rahul1", 30);
//	    map.put("rahul2", 30);
	    
	}
	
	public void testScanner(){
		
		
		Scanner scn = new Scanner(System.in);
        try
        {
            int n = Integer.parseInt(scn.nextLine());
           
            if (99%n == 0)
                System.out.println(n + " is a factor of 99");
        }        
        catch (ArithmeticException ex)
        {
            System.out.println("Arithmetic " + ex);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Number Format Exception " + ex);
        }
        catch (Exception ex) {
			// TODO: handle exception
        	System.out.println("Exception " + ex);
		}
		
	}

}
