package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Crawler {
    HashSet<String> UrlSet ;
    int max_depth = 2;
    Crawler(){
        UrlSet = new HashSet<>();
    }

    public void getPageTextsAndLink(String url, int depth) {
        if(UrlSet.contains(url))
        {
            return;
        }
        if (depth >= max_depth)
        {
            return;
        }
        if(UrlSet.add(url))
        {
            System.out.println(url);
        }
        depth++;
        try {
            Document document = Jsoup.connect(url).timeout(5000).get();
            //Indexer work start here
            Indexer indexer = new Indexer(document,url);
            System.out.println(document.title());
            Elements avaiableLinksOnPage = document.select("a[href]");

            for(Element currentLinks : avaiableLinksOnPage)
            {
                getPageTextsAndLink(currentLinks.attr("abs:href"), depth);
            }
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
    public static void main(String[] args)  {
        Crawler crawler = new Crawler();
        crawler.getPageTextsAndLink("https://www.javatpoint.com/",0);
    }
}