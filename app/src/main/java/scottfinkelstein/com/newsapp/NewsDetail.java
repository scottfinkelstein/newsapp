package scottfinkelstein.com.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewsDetail extends AppCompatActivity {

    TextView titleTextView;
    TextView dateTextView;
    TextView descTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        titleTextView = (TextView)findViewById(R.id.news_title);
        dateTextView = (TextView)findViewById(R.id.news_date);
        descTextView = (TextView)findViewById(R.id.news_desc);

        //String desc = getIntent().getStringExtra(NewsActivity.NEWS_EXTRA);
        //descTextView.setText(desc);

        News news = (News)getIntent().getParcelableExtra(NewsActivity.NEWS_EXTRA);
        titleTextView.setText(news.title);
        dateTextView.setText(news.pubDate);
        descTextView.setText(news.desc);
    }
}
