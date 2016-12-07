package lt.nfq.androidws.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import lt.nfq.androidws.models.Movie;

/**
 * Created by eakatauskas on 02/12/2016.
 */

public class MovieAdapter extends BaseAdapter {

    private Context mContext;
    private List<Movie> movieList = new ArrayList<>();


    public MovieAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Movie getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        return null;
    }
}
