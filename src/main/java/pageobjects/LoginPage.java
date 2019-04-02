package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebElement element;
	WebDriver driver;
	
	@FindBy(id = "ap_email")
	private WebElement txtEmail;	
	
	@FindBy(id = "ap_password")
	private WebElement txtPassword;
	
	@FindBy(id = "signInSubmit")
	private WebElement btnSignIn;
	
	@FindBy(id = "nav-link-accountList")
	private WebElement btnNavSignIn; 
	
	@FindBy(className = "nav-line-1")
	private WebElement lblHelloMessage; 
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span[1]")
	WebElement lblLoginMessage;
	
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/h4")
	WebElement lblLogonAlertTitle;
	
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")
	WebElement lblLogonAlertMessage; 
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void enterEmail(String userName){
		txtEmail.sendKeys(userName);
	}
	
	private void enterPassword(String password){
		txtPassword.sendKeys(password);
	}
	
	private void clickOnSignIn(){
		btnSignIn.click();
	}
	public void navigateToLoginPage() {
		btnNavSignIn.click();
	}
	public String getLoginMessage()
	{ 
		String text = lblLoginMessage.getAttribute("innerText").trim();
		System.out.println(text);
		 
		return text;
	}
	
	public String getInvalidLoginErrorMessage() {
		String logonAlertTitle = lblLogonAlertTitle.getAttribute("innerText");
		String logonAlertMessage = lblLogonAlertMessage.getAttribute("innerText");
		System.out.println(logonAlertTitle + " - " + logonAlertMessage);
		 
		return logonAlertTitle + " - " + logonAlertMessage;
	}
	
	public void loginToCheckOut(String userName, String password){
		enterEmail(userName); 
		enterPassword(password);
		clickOnSignIn(); 
	}

}
