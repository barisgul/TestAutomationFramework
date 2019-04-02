package engine;
import java.io.IOException; 
import java.util.HashSet; 

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 

public class Crawler {
	
	private static final int MAX_DEPTH = 2;
    private HashSet<String> links;  
    String title = "";

    public Crawler() {
        links = new HashSet<>();  
    }
     

    public HashSet<String> getPageLinks(String URL, int depth) {
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            System.out.println(">> Depth: " + depth + " [" + URL + "]" + "  title: "+title); 
            try {
                links.add(URL);

                Document document = Jsoup.connect(URL).get();
                title = document.title();
                Elements linksOnPage = document.select("a[href]");

                depth++;
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"), depth);
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
        return links;
    }
    
    public String getPageTitle(String url) {
    	String sTitle = "";
    	try {
    		Document document = Jsoup.connect(url).get();
    		Elements titles = document.select("h1.main-title");    	    
    	    if (titles.size() > 0)
    	        sTitle = titles.get(0).text();
		} catch (Exception e) {
			System.err.println("For '" + url + "': " + e.getMessage());
		}    	
    	return sTitle;
    } 

}
