package pageobjects;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
 
import reader.FileReaderFactory;


public class DropboxPage {
	WebDriver driver;
	WiniumDriver winiumDriver;
	String baseUrl;
	private String userName;
	private String password;
	
	
	@FindBy(id="sign-up-in")
	private WebElement btnSignIn;
	
	@FindBy(xpath="//*[starts-with(@id,'login_email')]")
	private WebElement txtUserName; 
	
	@FindBy(xpath="//*[starts-with(@id,'login_password')]")
	private WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='login-button signin-button button-primary']")
	private WebElement btnLogin;
	
	@FindBy(id="files")
	private WebElement linkFiles;
	
	@FindBy(xpath="//a[@href='/home/results']/div/span")
	private WebElement btnResults; 
	
	@FindBy(xpath="//span[@class='mc-tertiary-icon-text']/div[@class='ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-upload-file']")
	private WebElement btnUploadFiles; 
	
	@FindBy(id="uploadfile_0")
	private WebElement testUpload; 
	
	
	public DropboxPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);  
		userName = FileReaderFactory.getInstance().getConfigReader().getDroboxUserName();
		password = FileReaderFactory.getInstance().getConfigReader().getDroboxPassword();
		try {
			initializeWinium();
		} catch (MalformedURLException | InterruptedException e) { 
			e.printStackTrace();
		}
	}
	
	public void navigateTo_HomePage() {
		try {
			String url = FileReaderFactory.getInstance().getConfigReader().getDropboxUrl();
			driver.get(url);	
			//http://demo.guru99.com/test/upload/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openCredentialSection() {
		btnSignIn.click();
	}
	
	public void setUserName(){
		txtUserName.sendKeys(userName);
	}
	
	public void setPassword(){
		txtPassword.sendKeys(password);
	}
	
	public void login() {
		try {
			btnLogin.click();
			wait(5,TimeUnit.SECONDS); 
			waitUntilElementToBeClickable(driver,30,linkFiles);
		} catch (Exception e) { 
			e.printStackTrace();
		}		 
	}

	public void openResultsFolder(){
		linkFiles.click();
		wait(5,TimeUnit.SECONDS);
		waitUntilElementToBeClickable(driver,20,btnResults);
		btnResults.click();
		wait(5,TimeUnit.SECONDS);
		waitUntilElementToBeClickable(driver,20,btnUploadFiles);
	}
	
	public void clickOnUploadButton(){
		btnUploadFiles.click();
		wait(5,TimeUnit.SECONDS);
	}
	
	//Set file upload dialog with created txt file and submit to Enter
	public void uploadFile(String fileName)
	{
		try { 
			wait(8,TimeUnit.SECONDS);
			System.out.println("File to be upload: "+fileName); 
			btnUploadFiles.click();
			wait(5,TimeUnit.SECONDS);
			winiumDriver.findElementByName("File name:").sendKeys(fileName);
		    winiumDriver.findElementByXPath("//*[@Name='Cancel']//preceding-sibling::*[@Name='Open']").click();
		    wait(5,TimeUnit.SECONDS);	
		    driver.navigate().refresh();
		    wait(5,TimeUnit.SECONDS);	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uploadFileTest(String fileName)
	{
		try {
			wait(3,TimeUnit.SECONDS);
			System.out.println("Yüklenecej dosya: "+fileName); 
			testUpload.click();
			wait(3,TimeUnit.SECONDS);
			winiumDriver.findElementByName("File name:").sendKeys(fileName);
		    winiumDriver.findElementByXPath("//*[@Name='Cancel']//preceding-sibling::*[@Name='Open']").click();
		    wait(3,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//start winium and add notepad.exe to capabilities
	private void initializeWinium() throws MalformedURLException, InterruptedException 
	{
		winiumDriver = null;
        String appPath = "C:/windows/system32/rundll32.exe";
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        winiumDriver = new WiniumDriver(new URL("http://localhost:9999"),option);
        wait(1,TimeUnit.SECONDS);
	}
	
	private void wait(long timeout, TimeUnit timeUnit)
	{
		driver.manage().timeouts().implicitlyWait(timeout, timeUnit);			
	}
	
	private void waitUntilElementToBeClickable(WebDriver driver, long timeUnit, WebElement element) 
	{ 
		WebDriverWait wait = new WebDriverWait(driver, timeUnit);
		wait.until(ExpectedConditions.elementToBeClickable(element)); 
	}
	 
}
	
