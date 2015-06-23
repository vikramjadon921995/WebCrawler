# WebCrawler
Contains webCrawler implementation in java
The crawler contains Four classes Namely WebCrawler.java, LinksManage.java, PageLinkExtractor.java, UrlAccessor.java.
The "designOfCrawler.png" files shows the structure of the application.

Algorithm : 

	1. First the seedUrl is parsed.
	2. It is also stored in the visited Urls Set.
	3. Then all the links found in that Url are stored in the a List. These Urls are to be visited.
	4. Then till the required number of Urls are visited,
		1. The first Url in the List of yet to be visited, if it is not already visited, it is parsed and stored in                  visited set.
		

WebCrawler.java : 

	1. This class contains the main entry point of the application. It always uses UrlAccessor.java to use 			           PageLinkExtractor.java and UrlAccessor.java.
	2.This class contains the code of restricting the crawler to a certain numer of Urls.

UrlAccessor.java
	1. This class is responsible for the connection between the the entry point of the application and the main logic.
	2. It accesses the methods of PageLinkExtractor.java and UrlAccessor.java through their objects.

PageLinkExtractor.java
	
        1. This class contains the logic of parsing the HTML and finding various links in the pages using JSOUP.
	2. These Links are stored in a Linked_list and are returned through a function whenever required.

LinksManager.java
	
	1.This class contains the data structures for storing the visited Urls and yet to visit Urls.
	2.The visited Urls are stored in a Set data structure as the visted urls will be always unique.
	3. The yet to visit urls are stored in a Linked-List data structure.
