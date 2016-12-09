package lt.nfq.androidws.services;

import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import lt.nfq.androidws.models.Movie;

/**
 * Created by eakatauskas on 09/12/2016.
 */

public class MovieService {

    private final static String MOVIES_URL = "http://www.omdbapi.com/?s=";

    public static void getMovies(final String searchText, final MoviesCallback callback){
        String URL = MOVIES_URL+searchText;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                List<Movie> movies = new ArrayList<Movie>();
                JsonObject object = (JsonObject)new JsonParser().parse(response.toString());
                for(JsonElement element : object.getAsJsonArray("Search")){
                    Movie movie = Movie.fromJson(element);
                    movies.add(movie);
                    Log.d("Movie", movie.toString());
                }

                callback.onSuccess(movies);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                callback.onError();
            }
        });
    }

    public interface MoviesCallback{
        void onSuccess(List<Movie> movies);
        void onError();
    }

}
