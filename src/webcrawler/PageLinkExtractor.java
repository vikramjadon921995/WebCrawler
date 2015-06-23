package webcrawler;


import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PageLinkExtractor {
    
    private List<String> ListOfLinks;
    private Document HtmlDocument; 
    
    PageLinkExtractor()                                                                                         //Constructor
    {    
        ListOfLinks = new LinkedList<String>();
        
    }
    
    public boolean ExtractPageLinks(String url)
    {   
        try{
            Connection connection = Jsoup.connect(url);                                                         //To set up connection to the url
            this.HtmlDocument = connection.get();
            
            if(connection.response().statusCode() == 200)                                                       //To check if the connection was successful
            {
                System.out.println("Connection Successful to "+ url);
                
                if(!connection.response().contentType().contains("text/html"))                                  //Check if the type of file is not HTML 
                {
                    System.out.println("Parsing Unsuccessful, Received other than text/html");
                    return false;
                }
                
                Elements LinksonPage = HtmlDocument.select("a[href]");                                          //Finding the Links
                Elements ImageLinksonPage = HtmlDocument.select("[src]");                                       //Finding the Links
                
                System.out.println(LinksonPage.size() + ImageLinksonPage.size() + "Links on the page");
                
                for(Element Link : LinksonPage)                                                                 //saving the links to a List
                {
                    this.ListOfLinks.add(Link.absUrl("href"));
                }
                for(Element Link : ImageLinksonPage)                                                            //saving the links to a List
                {
                    this.ListOfLinks.add(Link.absUrl("src"));
                }
                
                return true;
            }
            
        }
        catch(Exception ex)
        {
            System.out.println("Error occured while extracting Links from "+url);
            return false;
            
        }
        
        return false;
    }
    
    public boolean KeywordSearch(String keyword)                                                                //To search a keyword
    {
        String PageText = this.HtmlDocument.body().text();
        return PageText.toLowerCase().contains(keyword);
                
    }

    public List<String> getLinks()                                                                              //Returns all the links found on the page. 
    {
        return this.ListOfLinks;
    }
}
