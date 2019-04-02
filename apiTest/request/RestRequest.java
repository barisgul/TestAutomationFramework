package request;
  
import static org.junit.Assert.assertEquals; 

import entity.Posts;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reader.FileReaderFactory;

public class RestRequest {
	private static String requestUrl = ""; 
	public static Posts[] blogPosts;
	 
	public RestRequest() {
		requestUrl = FileReaderFactory.getInstance().getConfigReader().getRequestUrl();
	} 
	
	public RestRequest(String customUrl) {
		requestUrl = customUrl;
	} 
	 
	public Posts[] getPosts()
	{ 		 
		DeserializeContent(requestUrl);
		Response response = RestResponse(requestUrl); 
		
		int statusCode = response.statusCode(); 
		 
		assertEquals(statusCode, 200); 
		return  blogPosts;
	} 
	
	public Posts[] getPosts(String requestUrl)
	{ 		 
		DeserializeContent(requestUrl);
		Response response = RestResponse(requestUrl); 
		
		int statusCode = response.statusCode(); 
		
		System.out.print("Status Code: "+statusCode);  
		assertEquals(statusCode, 200); 
		return  blogPosts;
	} 
	
	
	private  Response RestResponse(String url) {
		Response response = RestAssured.get(url);
		return response;
	}
	
	private  Posts[] DeserializeContent(String url) { 
		
		Posts[]  posts = RestAssured.get(url).as(Posts[].class); 
		blogPosts = posts;
		 
		return posts;
	} 
}
