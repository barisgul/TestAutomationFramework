package managers;
  
import org.openqa.selenium.WebDriver;

import pageobjects.CrawlerTitleHandlerPages;
import pageobjects.DropboxPage;
import pageobjects.HomePage;
import pageobjects.LoginPage; 

public class PageManager {
 
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private CrawlerTitleHandlerPages handlerPage; 
	private DropboxPage dropboxPage;

 
	public PageManager(WebDriver driver) { 
		this.driver = driver;
	}
 
	public HomePage getHomePage(){ 
		return (homePage == null) ? homePage = new HomePage(driver) : homePage; 
	}
	
	public LoginPage getLoginPage() {		 
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage; 
	} 	
	
	public CrawlerTitleHandlerPages getCrawledPage() {		 
		if (handlerPage == null)
			return handlerPage = new CrawlerTitleHandlerPages(driver);
		else
			return handlerPage; 
	} 
	
	public DropboxPage getDropboxPage() {		 
		if (dropboxPage == null)
			return dropboxPage = new DropboxPage(driver);
		else
			return dropboxPage; 
	} 
}