package entity;

public class CrawlerEntity {	

    
    public String link;
    void setLink(String link)
    {
        this.link = link;
    }
    
    public String pageTitle;    
    void setPageTitle(String pageTitle)
    {
        this.pageTitle = pageTitle;
    }
   
    public String status;    
    void setStatus(String status)
    {
        this.status = status;
    }
    
    public CrawlerEntity() {
    }
    
    public CrawlerEntity(String link, String pageTitle, String status) {
    	this.link = link;
    	this.pageTitle = pageTitle;
    	this.status = status; 
    }

}
