package scottfinkelstein.com.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public static final String NEWS_EXTRA = "com.scottfinkelstein.newsapp.NEWS_EXTRA";



    private List<News> newsList = new ArrayList<News>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(NewsActivity.this));

        requestJsonObject();
    }

    private void requestJsonObject() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://home.adelphi.edu/~fi17067/news-api.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                NewsData newsData = gson.fromJson(response.toString(), NewsData.class);

                for (int i = 0; i < newsData.data.length; i++) {
                    newsList.add(newsData.data[i]);
                }

                NewsAdapter adapter = new NewsAdapter(newsList);
                mRecyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsActivity.this, "Error: " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }
}
