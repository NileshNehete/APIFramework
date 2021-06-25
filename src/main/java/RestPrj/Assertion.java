package RestPrj;

import Utilities.TestUtil;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Assertion {
	
	public static void verifyStatusCode(Response response,int status)
	{
		Assert.assertEquals(TestUtil.getStatusCode(response), status);
	}

}
