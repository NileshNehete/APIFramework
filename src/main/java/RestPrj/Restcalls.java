package RestPrj;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restcalls {
	
	public static Response getRequest(String URI)
	{
		
	   RequestSpecification rs = RestAssured.given();
	   rs.contentType(ContentType.JSON);
	   Response rsp = rs.get(URI);
	   return rsp;   
	}
	public static Response getRequestWithHeader(String URI,String token)
	{
		
	   RequestSpecification rs = RestAssured.given();
	   rs.contentType(ContentType.JSON);
	   rs.header("Authorization","bearer "+token);
	   Response rsp = rs.get(URI);
	   return rsp;   
	}
	
	public static Response postRequest(String URI,String jsonbody)
	{		
	   RequestSpecification rs = RestAssured.given().body(jsonbody);
	   rs.contentType(ContentType.JSON);
	   Response rsp = rs.post(URI);
	   return rsp;   
	}
	public static Response putRequest(String URI,String jsonbody)
	{		
	   RequestSpecification rs = RestAssured.given().body(jsonbody);
	   rs.contentType(ContentType.JSON);
	   Response rsp = rs.put(URI);
	   return rsp;   
	}
	public static Response deleteRequestWithHeader(String URI,String token)
	{		
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		rs.header("Authorization","bearer "+token).log().all(); // to log outcomes in console
		Response rsp = rs.delete(URI);
	    return rsp;   
	}	

}
