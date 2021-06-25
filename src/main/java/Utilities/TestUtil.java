package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtil {
	
	public static String getResponseString(Response Resp)
	{
		String resp = Resp.getBody().asString();
		return resp;
		
	}
	
	public static JsonPath jsonParser (String response)
	{
	  JsonPath jsonString = new JsonPath(response);
	  return jsonString;
	  
	} 
	
	public static int getStatusCode(Response response)
	{
		int status = response.getStatusCode();
		return status;
	}
	
	public static String getStatusMsg(Response response)
	{
		String statusMsg = response.getStatusLine();
		return statusMsg;
	}
	
	
	
}
