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
        News welcome = new News();
        welcome.title = "Welcome!";
        News welcomeBack = new News();
        welcomeBack.title = "Welcome Back!";
        newsList.add(welcome);
        newsList.add(welcomeBack);

        NewsAdapter adapter = new NewsAdapter(newsList);
        mRecyclerView.setAdapter(adapter);
    }
}
