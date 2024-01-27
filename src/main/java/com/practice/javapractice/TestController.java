package com.practice.javapractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


@RestController
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	 
	public String basePath="C:\\Users\\vikash.saini\\Desktop\\Vikash" ;
	public String appName= "javapractice";
	
	@GetMapping("/testlog")
	@ResponseBody
	public String testLogger() {
		 logger.trace("1.This is a TRACE message.");
	        logger.debug("2.This is a DEBUG message.");
	        logger.info("3.This is an INFO message.");
	        logger.warn("4.This is a WARN message.");
	        logger.error("5.This is an ERROR message.");
		
		System.out.println("Hello");
		
		Path basePathWithApplName = (Path)Paths.get(basePath, appName);
		Path basePurgedFilePathWithApplName = (Path)Paths.get(basePath, "purged_files", appName);
		
		Path destinationFolderPath = (Path)Paths.get(basePath, "purged_files", appName, "hq_bills/11/02/");

		String sourceFilePath = Paths.get("C:/Users/vikash.saini/Desktop/Vikash/javapractice/index/hq_bills/11","test.txt").toString();
		
		System.out.println("sourceFilePath"+sourceFilePath);
		// create object of Path
        Path path = (Path)Paths.get(basePath,appName,"index/hq_bills/11/", "test.txt");
  
        // print Path
        System.out.println(path);
		
//		try {
//			Files.createDirectories(destinationFolderPath);
//			logger.info("created");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        Path destinationFilePath = destinationFolderPath.resolve("test.text");
        try {
			Files.move(Paths.get(sourceFilePath), destinationFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//		if (Files.exists(Paths.get(sourceFilePath))) {
//            // Files.move(sourceFilePath, destinationFolderPath.resolve(indexTableVO.getFileName()));
//             Path destinationFilePath = destinationFolderPath.resolve("test.text");
//             try {
//				Files.move(Paths.get(sourceFilePath), destinationFilePath);
//				logger.info("File moved success");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				 logger.info("File moved success failed");
//				 logger.info("Error: ",e);
//			}
//             
//         } else {                       
//        	 logger.info("File note exits");
//         }

		logger.info("basePath ",basePathWithApplName);
		return "Hello";
	}
	
	
	
	
	
	

}
