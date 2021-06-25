package Utilities;

public class baseURL {
	
	public static final String baseuri = "https://ecommerceservice.herokuapp.com";
	public static String getEndPoint()
	{
		return baseuri;
	}
	
	public static String getEndPoint(String resource)
	{
		return baseuri + resource;
	}
	
	

}
