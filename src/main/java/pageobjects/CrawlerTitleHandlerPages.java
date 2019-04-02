package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import entity.CrawlerEntity;


public class CrawlerTitleHandlerPages {
	WebDriver driver;
	String pageTitle;  
	private String pageStatus = "OK";
	public CrawlerEntity crawlerEntity;
	
	public CrawlerTitleHandlerPages(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		crawlerEntity = new CrawlerEntity();
	}
	
	public void navigateTo_CrawledUrl(String url) {
		driver.get(url);
	}	

	
	public void getCrawledPageTitle(String url) {
	  driver.get(url);
      pageTitle = driver.getTitle();
      if(pageTitle == null)
      {
    	  pageTitle = null;
    	  pageStatus="Dead link";
      }
      loadEntity(pageTitle,url,pageStatus);    	 
	}
	
	private void loadEntity(String title, String link, String status) {
		crawlerEntity.pageTitle = title;
		crawlerEntity.link = link;
		crawlerEntity.status = status;
	}
	
}
	
