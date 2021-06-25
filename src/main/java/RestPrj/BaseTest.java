package RestPrj;

import java.io.IOException;

import Utilities.Payloadconvertor;
import Utilities.baseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	
	static Response response;
	
	public static String login() throws IOException
	{
		
     String endURI = baseURL.getEndPoint("/user/login");
     String payLoad = Payloadconvertor.generatePayload("login.json");
     System.out.println("payload is : "+ payLoad);
     
     response = Restcalls.postRequest(endURI, payLoad);
     
     String respBody = response.getBody().asString();
    
     System.out.println("Response :"+respBody); 
     // check with response.header()
     
     JsonPath jsonString = new JsonPath(respBody);
     String accessToken = jsonString.getString("accessToken");
     System.out.println("AccessToken is:"+accessToken);
     return accessToken;
     
     
		
	}

}
