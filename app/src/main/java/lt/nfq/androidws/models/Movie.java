package lt.nfq.androidws.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eakatauskas on 02/12/2016.
 */

public class Movie {

    @SerializedName("Title") private String title;
    @SerializedName("Year") private String year;
    @SerializedName("Poster") private String poster;
    @SerializedName("Type") private String type;
    @SerializedName("imdbID") private String id;


    public static Movie fromJson(JsonElement element){
        Gson builder = new GsonBuilder().create();
        Movie movie = builder.fromJson(element, Movie.class);
        return movie;
    }

    public Movie(String title, String year, String poster) {
        this.title = title;
        this.year = year;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", poster='" + poster + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
