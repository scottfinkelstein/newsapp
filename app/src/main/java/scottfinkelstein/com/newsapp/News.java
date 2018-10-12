package scottfinkelstein.com.newsapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class News implements Parcelable {

    @SerializedName("news_title")
    public String title;

    @SerializedName("pub_date")
    public String pubDate;

    @SerializedName("description")
    public String desc;

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>()
    {

        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public News(String newsTitle, String newsPubDate, String newsDesc) {
        title = newsTitle;
        pubDate = newsPubDate;
        desc = newsDesc;
    }

    private News(Parcel in) {
        title = in.readString();
        pubDate = in.readString();
        desc = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(pubDate);
        dest.writeString(desc);
    }
}
