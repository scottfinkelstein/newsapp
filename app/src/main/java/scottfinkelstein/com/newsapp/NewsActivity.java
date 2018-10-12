package scottfinkelstein.com.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public static final String NEWS_EXTRA = "com.scottfinkelstein.newsapp.NEWS_EXTRA";

    private String newsJson = "{\n" +
            "\t\"data\": [{\n" +
            "\t\t\"news_title\": \"Adelphi President, Alumnae Recognized Among Top 50 Most Influential Women In Business\",\n" +
            "\t\t\"pub_date\": \"2018-10-05T16:30:00-04:00\",\n" +
            "\t\t\"description\": \"Long Island Business News\\u00a0has named\\u00a0Adelphi University President Christine Riordan one of the Top 50 Most Influential Women in Business.\"\n" +
            "\t\t\n" +
            "\t}, {\n" +
            "\t\t\"news_title\": \"Mel Pender '97 (Hon.), Continues to Go for the Gold\",\n" +
            "\t\t\"pub_date\": \"2018-10-04T10:38:00-04:00\",\n" +
            "\t\t\"description\": \"He's an Olympic champion, military hero, entrepreneur and philanthropist, and on Saturday, October 13, Mel Pender '76, '97 (Hon.), will add another title to his accomplishments: Adelphi Legend.\"\n" +
            "\t\t\n" +
            "\t}, {\n" +
            "\t\t\"news_title\": \"In Adelphi's Creative Writing M.F.A. Program, Finding Your Voice Is a Group Effort\",\n" +
            "\t\t\"pub_date\": \"2018-10-03T15:42:00-04:00\",\n" +
            "\t\t\"description\": \"What is the right class size for graduate work in creative writing? Igor Webb, Ph.D., professor and director of the M.F.A. in Creative Writing program at Adelphi, believes strongly that the answer is 10 students.\"\n" +
            "\t\n" +
            "\t}, {\n" +
            "\t\t\"news_title\": \"Faerie Knitting by Alice Hoffman is Here to Enchant Readers and Knitters\",\n" +
            "\t\t\"pub_date\": \"2018-10-03T14:01:00-04:00\",\n" +
            "\t\t\"description\": \"Alice Hoffman '73, '02 (Hon.), our 2018\\u00a0Legends Dinner\\u00a0keynote speaker, has written fiction for children, middle-grade books, adult novels and a work of nonfiction. A thread of magic runs through many of them, but her latest is quite a departure from its predecessors.\"\n" +
            "\t\t\n" +
            "\t}, {\n" +
            "\t\t\"news_title\": \"Adelphi Kicks Off Spirit Weekend With First-Ever Fall Frenzy Concert\",\n" +
            "\t\t\"pub_date\": \"2018-10-03T13:21:00-04:00\",\n" +
            "\t\t\"description\": \"Adelphi's second annual Spirit Weekend has a first: the inaugural\\u00a0Fall Frenzy concert.\"\n" +
            "\t\t\n" +
            "\t}, {\n" +
            "\t\t\"news_title\": \"Meet the New Director of the Center for Student Involvement\",\n" +
            "\t\t\"pub_date\": \"2018-10-03T12:47:00-04:00\",\n" +
            "\t\t\"description\": \"The Center for Student Involvement (CSI) has a new director, and she's no stranger to Adelphi.\"\n" +
            "\t}]\n" +
            "}";

    private List<News> newsList = new ArrayList<News>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(NewsActivity.this));

        Gson gson = new Gson();
        NewsData newsData = gson.fromJson(newsJson, NewsData.class);

        for (int i = 0; i < newsData.data.length; i++) {
            newsList.add(newsData.data[i]);
        }



        NewsAdapter adapter = new NewsAdapter(newsList);
        mRecyclerView.setAdapter(adapter);
    }
}
