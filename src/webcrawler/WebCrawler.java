package webcrawler;

public class WebCrawler {
    
    private static int MaximumUrlToVisit = 10;
    private static String SeedUrl = "http://python.org";

    public static void main(String[] args) {           //Entry Point for the crawler 
        
        int pagesvisited;
        
        UrlAccessor Accessor = new UrlAccessor(); 
        
        pagesvisited = Accessor.pagesVisited();        //To find The number of pages visited;    
     
        Accessor.addSeedUrl(SeedUrl);                  //To add the first Url (SeedUrl) to the Container that contains all the pages to be visited
                                                       //addSeedUrl() function defined in UrlAccessor class
    
        while(pagesvisited <= MaximumUrlToVisit)       //To make the crawler to visit only "MaximumUrlToVisit" Urls
        {
            String currentUrl;
            currentUrl = Accessor.getNextUrl();        //To get the next url, getNextUrl() defined in UrlAccessor class
            Accessor.setUrltoParse(currentUrl);        //To parse the "currentUrl" page, setUrltoParse() defined in UrlAccessor class
            Accessor.SaveNewUrls();                    //To save new Urls, SaveNewUrls() defined in UrlAccessor class
            pagesvisited = Accessor.pagesVisited();    //To change the value of "pagesVisited", defined in UrlAccessor class
        }
        
        System.out.println("The Visited Pages are : ");
        Accessor.PrintVisitedLinks();                  //To print all the Visited Pages. 
    }
    
}
