package lt.nfq.androidws.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lt.nfq.androidws.R;
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
        ViewHolder holder = null;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }

        Movie movie = getItem(position);
        if(movie != null){
            holder.movieYear.setText(movie.getYear());
            holder.movieName.setText(movie.getTitle());
            if(!movie.getPoster().isEmpty()) {
                Picasso.with(mContext)
                        .load(movie.getPoster())
                        .into(holder.poster);
            }

        }


        return view;
    }

    static class ViewHolder {

        @BindView(R.id.poster)
        ImageView poster;

        @BindView(R.id.movieName)
        TextView movieName;

        @BindView(R.id.movieYear)
        TextView movieYear;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

    }
}
