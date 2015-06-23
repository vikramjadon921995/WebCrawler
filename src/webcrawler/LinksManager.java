package webcrawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LinksManager {

    private Set<String> VisitedUrls;                            //Set for unique Visited Urls                        
    private List<String> UrlsToVisit;                           //Linked-List for all nonvisited Urls
    
    LinksManager()                                              //Constructor
    { 
        VisitedUrls = new HashSet<String>();           
        UrlsToVisit = new LinkedList<String>();
    }
    
    public String NextUrltoSearch()                             //function to find the NextUrl that is to be parsed.
    {
        String NextUrl;
        
        do                                                      //To make NextUrl take only those values which are already not in the visited Set. 
        {
            NextUrl = this.UrlsToVisit.remove(0);               
        }while(this.VisitedUrls.contains(NextUrl));
        
        this.VisitedUrls.add(NextUrl);                          //To add NextUrl to the Visited Set.
        
        return NextUrl;
    }
    
    public void SaveNewUrls(List<String> ListOfNewUrls)         //Function to save new Urls to be visited
    {
        this.UrlsToVisit.addAll(ListOfNewUrls);
    }
    
    public int NoOfPagesVisited()                               //Function to find the Number of pages Visited
    {
        return VisitedUrls.size();
    }
    
    public boolean UrlContainerisEmpty()                        //Function to check if Urlstovisit is empty
    {
        return UrlsToVisit.isEmpty();
    }
    
    public void AddtoUrlstoVisit(String Url)                    //Function to add any url to the UrlstoVisit List.
    {
        UrlsToVisit.add(Url);
    }
    
    public Set getVisitedLinks()                                //Function to get all the links that are visited
    {
        return VisitedUrls;
    }
}
