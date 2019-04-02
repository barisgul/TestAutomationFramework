package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.List; 
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pomBase.Context; 

public class UITestSteps {
	
	static WebDriver driver;
	Context testContext;
	HomePage homePage;
	LoginPage loginPage;

	public UITestSteps(Context context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("^user is on Home Page$")
	public void userIsOnHomePage(){
		homePage.navigateTo_HomePage();
	}
 
	@Given("^I am a user of amazon.com$")
	public void userOfAmazon(){
		homePage.navigateTo_HomePage();
	}
	
	@When("I log in using valid credentials")
	public void loginWithCredentials(DataTable args)  {
		List<String> list = args.asList(String.class);
		String uName = list.get(1);
		String pw = list.get(3); 
		System.out.println(uName+"  --"+pw);
		loginPage.navigateToLoginPage();  
		 
		loginPage.loginToCheckOut(uName,pw); 
	}
	
	@When("I log in using invalid credentials")
	public void loginWithInvalidCredentials(DataTable args)  {
		List<String> list = args.asList(String.class);
		String uName = list.get(1);
		String pw = list.get(3); 
		System.out.println(uName+"  --"+pw);
		loginPage.navigateToLoginPage();  
		 
		loginPage.loginToCheckOut(uName,pw); 
	} 
	
	@Then("I should be logged in$")
	public void successLogon()  {
		String loginMessage =loginPage.getLoginMessage(); 
		assertTrue(loginMessage.equals("Hello, baris"));
	} 
	
	@Then("I should not be logged in$")
	public void notSucceedLogon()  {
		String message =loginPage.getInvalidLoginErrorMessage(); 
		assertTrue(message.contains("There was a problem"));
	}  
	
	@Then("I close browser$")
	public void closeBrowser()  {		
		homePage.closeBrowser();
	} 

}
