package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.PageFactory;
 
import reader.FileReaderFactory;


public class HomePage {
	WebDriver driver; 
	 
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderFactory.getInstance().getConfigReader().getApplicationUrl());
	} 

	public void closeBrowser() {
		driver.close();		
		driver.quit();
	}	
	
	//get all department links from homepage and add to List object
	public List<String> getDepartmentList() {  
       List<WebElement> list = driver.findElements(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/a"));    
       List<String> departmentLinks = new ArrayList<String>(); 
       
       for (int i= 1; i <= list.size(); i++) { 
    	   List<WebElement> links = driver.findElements(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/a["+i+"]"));
           String rowLinks = "";
           for (WebElement link : links) {
                rowLinks = rowLinks + link.getAttribute("href");                
           } 
           System.out.println(rowLinks);
           departmentLinks.add(rowLinks); 
       }       	    
		return departmentLinks;
	}
}
	
