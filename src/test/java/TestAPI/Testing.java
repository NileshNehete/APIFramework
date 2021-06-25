package TestAPI;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RestPrj.Assertion;
import RestPrj.BaseTest;
import RestPrj.Restcalls;
import Utilities.TestUtil;
import Utilities.baseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Testing {
	
	public String accesstoken ;
	public String userId;
	Response responseGetUsers,responseDeleteuser;
	
	@BeforeTest
	public void setup() throws IOException
	{
		accesstoken = BaseTest.login();
	}
	
	@Test(priority = 0)
	public void getUsers()
	{
		String endPointURL = baseURL.getEndPoint("/user");
		responseGetUsers = Restcalls.getRequestWithHeader(endPointURL, accesstoken);
		
		String resp_getUsers = TestUtil.getResponseString(responseGetUsers);
		JsonPath jsonResp = TestUtil.jsonParser(resp_getUsers);
		
		userId = jsonResp.getString("users[2]._id");
		System.out.println("User id is :"+ userId);
		Assertion.verifyStatusCode(responseGetUsers, 200);
		System.out.println("!!!Test is successful!!!");
	}
	
	@Test(dependsOnMethods="getUsers")
	public void deleteUser()
	{
		String endPointURL = baseURL.getEndPoint("/user/"+userId);
		responseDeleteuser = Restcalls.deleteRequestWithHeader(endPointURL, accesstoken);
		String resp_deleteUser = TestUtil.getResponseString(responseDeleteuser);
		System.out.println(resp_deleteUser);
		
	}
	

}
