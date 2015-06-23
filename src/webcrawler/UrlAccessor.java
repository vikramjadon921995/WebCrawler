package webcrawler;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class UrlAccessor {
    
    private PageLinkExtractor LinkExtractor;                                //object references of PageLinkExtractor class and LinksManager class
    private LinksManager Manager;
    
    UrlAccessor()                                                           //Constructor
    {
         LinkExtractor = new PageLinkExtractor();
         Manager = new LinksManager();
    }
    
    public String getNextUrl()                                              //Function to be called from main() and to access the NextUrl to be visited
    {
        String NextUrl;
        NextUrl = Manager.NextUrltoSearch();                                //NextUrltoSearch() function defined in Manager class
        return NextUrl;
    }
    
    public boolean setUrltoParse(String url)                                //Function to be called from main() and to set The new url to parse
    {
        boolean SearchSuccessful;
        SearchSuccessful = LinkExtractor.ExtractPageLinks(url);             //ExtractPageLinks() function defined in LinkExtractor class.
        
        if(SearchSuccessful)
        {
            return true;
        }
    
        return false;
    }
    
    public void SaveNewUrls()                                               //Function to be called from main() to save all the new Urls in the LinkManager
    {
        List<String> ListOfNewUrls;
        ListOfNewUrls = LinkExtractor.getLinks();                           //getLinks() function defined in LinkExtractor class to get the Links of the Page.
        Manager.SaveNewUrls(ListOfNewUrls);                                 //SaveNewUrl() function defined in Manager class to Save the New Urls to be visited
    }
    
    public int pagesVisited()                                               //Function to be called from main() to find the number of pages visited
    {
        int VisitedPages;
        VisitedPages = Manager.NoOfPagesVisited();                          //NoOfPagesVisited() defined in Manager class
        return VisitedPages;
    }
    
    public boolean UrlcontainerisEmpty()                                    //Function to check if the Urls to be visited is empty of not
    {   
        return Manager.UrlContainerisEmpty();
    }
    
    public void addSeedUrl(String Url)                                      //Function to add the seed url to be visited
    {
        Manager.AddtoUrlstoVisit(Url);
    }
    
    public void PrintVisitedLinks()                                         //Functionto print all the visited links
    {
        Set<String> Visited = new HashSet<String>();
        Visited = Manager.getVisitedLinks();
        
        for (String s : Visited) {
            System.out.println(s);
        }
    }
}
