package scottfinkelstein.com.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<News> mNewsList;

    public NewsAdapter(List<News> newsList) {
        mNewsList = newsList;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View newsView = inflater.inflate(R.layout.list_item_news, parent, false);

        NewsHolder newsHolder = new NewsHolder(newsView);

        return newsHolder;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.NewsHolder newsHolder, int position) {
        News news = mNewsList.get(position);

        TextView textView = newsHolder.newsTitleTextView;
        textView.setText(news.title);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        public TextView newsTitleTextView;

        public NewsHolder(View itemView) {
            super(itemView);
            newsTitleTextView = (TextView)itemView.findViewById(R.id.news_title);

        }


    }
}
