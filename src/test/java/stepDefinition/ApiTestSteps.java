package stepDefinition;

 
import static org.junit.Assert.assertEquals; 

import java.util.List; 
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Posts;
import reader.FileReaderFactory;
import request.RestRequest;

public class ApiTestSteps {
	 
	RestRequest request;
	Posts[] posts;	
	private String customRequestUrl;
	private String overridedRequestUrl;  
	
	
	public ApiTestSteps() {
		customRequestUrl = FileReaderFactory.getInstance().getConfigReader().getRequestUrl();
		request = new RestRequest(); 
	}

	@When("^I get a list of blog posts using the API endpoint$")
	public void getListOfBlogPost(){
		request = new RestRequest();
		posts = request.getPosts();
		assertEquals(posts.length, 100);   
	}
	
	
	@Then("^user should have posts.$")
	public void getAndCheckUserPosts(DataTable dataTable)  { 
		 
		List<String> list = dataTable.asList(String.class);
		for (String item : list)
		{
			if(item.equals(list.get(0))) { 
				overridedRequestUrl = customRequestUrl.trim()+"?userId="+list.get(0).trim();
				request = new RestRequest(overridedRequestUrl);
				posts = request.getPosts();
				assertEquals(posts.length, Integer.parseInt(list.get(1)));  
				overridedRequestUrl = "";
				}
			else if(item.equals(list.get(2))) {
				overridedRequestUrl = customRequestUrl.trim()+"?userId="+list.get(2).trim();
				request = new RestRequest(overridedRequestUrl);
				posts = request.getPosts();
				assertEquals(posts.length, Integer.parseInt(list.get(3)));   
				overridedRequestUrl = "";
			}
			else if(item.equals(list.get(4))) {
				overridedRequestUrl = customRequestUrl.trim()+"?userId="+list.get(4).trim();
				request = new RestRequest();
				posts = request.getPosts(overridedRequestUrl);
				assertEquals(posts.length, Integer.parseInt(list.get(5)));   
			} 
		} 
	}
	
	//get posts and asserts post count with 100, then in loop assert every item id for uniqe type. 
	@Then("^each blog post should have a unique ID$")
	public void getAndCheckPostIdIsUnique(){
		int counterOfPosts =1;
		request = new RestRequest();
		posts = request.getPosts();
		assertEquals(posts.length, 100);   
		
		for(Posts item : posts) {
			assertEquals(item.id, counterOfPosts); 			
			counterOfPosts++;
		}
	}
	
	
	
 
}
