package scottfinkelstein.com.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(NewsActivity.this));

        List<News> newsList = new ArrayList<News>();
        newsList.add(new News("Item 1", "2018-07-05", "Description 1"));
        newsList.add(new News("Item 2", "2018-07-05", "Description 2"));
        newsList.add(new News("Item 3", "2018-07-05", "Description 3"));
        newsList.add(new News("Item 4", "2018-07-05", "Description 4"));
        newsList.add(new News("Item 5", "2018-07-05", "Description 5"));



        NewsAdapter adapter = new NewsAdapter(newsList);
        mRecyclerView.setAdapter(adapter);
    }
}
