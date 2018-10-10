package scottfinkelstein.com.newsapp;

public class News {

    public String title;
    public String pubDate;
    public String desc;

    public News(String newsTitle, String newsPubDate, String newsDesc) {
        title = newsTitle;
        pubDate = newsPubDate;
        desc = newsDesc;
    }
}
