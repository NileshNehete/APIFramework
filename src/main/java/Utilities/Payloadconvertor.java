package Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payloadconvertor {
	
	// convert body into string 
	public static String generatePayload(String filename) throws IOException
	{
		//get json-files
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\"+filename;
		
		System.out.println(filepath);
		
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
	

}
