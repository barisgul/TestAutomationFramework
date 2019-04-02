package crawlerTest; 
import java.util.HashSet;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import engine.Crawler; 
import pageobjects.CrawlerTitleHandlerPages;
import pageobjects.DropboxPage;
import pageobjects.HomePage;
import pomBase.Context;
import utils.FileNameGenerator;
import utils.FilePathFinder;
import writer.WriterToFile; 

public class SiteCrawler {  
	
	static WebDriver driver;
	Context testContext;
	HomePage homePage; 
	CrawlerTitleHandlerPages handlerPage;
	DropboxPage dropBoxPage;
	List<String> links;
	HashSet<String>  crawledLink;
	HashSet<String>alinkss;
	WriterToFile fileWriter;

	@Before
	public void setUp() {	
		testContext = new Context();
		homePage = testContext.getPageObjectManager().getHomePage(); 
		handlerPage = testContext.getPageObjectManager().getCrawledPage();
		dropBoxPage = testContext.getPageObjectManager().getDropboxPage();
	} 
	
	@Test
	public void crawlSiteAndWriteLinksToText(){
		homePage.navigateTo_HomePage();
		links = homePage.getDepartmentList();
		FileNameGenerator fileNameGenerator = new FileNameGenerator();
		
		// Creates file name in <timestamp>_results.txt format
		String fileName = fileNameGenerator.getFileName(); 
		
	/*	Crawler crawler = new Crawler();
		
		fileWriter = new WriterToFile();
		
		//creates file header that inclueds (title - status  - link) as a template 
		fileWriter.CreateFileTemplate(fileName);  
		
		//parameters will be write to file (title - status  - link)
		String entityParameters;   
		
		for(String url :  links) {
			//opens up the “Departments” dropdown menu on the amazon website, obtains a list of all department links
			crawledLink =crawler.getPageLinks(url, 1); 
			
			//get page title
			handlerPage.getCrawledPageTitle(url);	
			
			//get crawlerEntity values in one line
			entityParameters = handlerPage.crawlerEntity.pageTitle +" - "+ handlerPage.crawlerEntity.status +" - "+ handlerPage.crawlerEntity.link; 
			
			//appends entity values to generated file
			fileWriter.AppendNewLine(fileName, entityParameters);   
		} */
		
		UploadFileToDropBox(fileName);
	} 
	
	@After
	public void close(){ 
		homePage.closeBrowser();
	} 
	//Uploads file to dropbox. In this process winium needs to start a desktop application. So, notepad.exe will start for winium. 
	void UploadFileToDropBox(String fileName) {
		FilePathFinder finder = new FilePathFinder(); //get filePath 
		String fileWithPath = finder.getFilePath(fileName);
		dropBoxPage.navigateTo_HomePage();
		//dropBoxPage.uploadFileTest(filePath); 
		dropBoxPage.openCredentialSection();
		dropBoxPage.setUserName();
		dropBoxPage.setPassword();
		dropBoxPage.login();		
		dropBoxPage.openResultsFolder();
		dropBoxPage.clickOnUploadButton();
		dropBoxPage.uploadFile(fileWithPath);  
	}
	 
 
}
