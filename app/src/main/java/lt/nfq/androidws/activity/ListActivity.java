package lt.nfq.androidws.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import lt.nfq.androidws.adapters.MovieAdapter;
import lt.nfq.androidws.models.Movie;
import lt.nfq.androidws.R;


public class ListActivity extends AppCompatActivity {

    public final static String KEY_ELEMENT = "key";

    @BindView(R.id.list)
    ListView mList;

    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        Movie movie1 = new Movie("Pavadinimas", "1992", "");
        Movie movie2 = new Movie("Pavadinimas", "2000", "");
        Movie movie3 = new Movie("Pavadinimas", "2015", "");

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

        mAdapter = new MovieAdapter(this, movieList);
        mList.setAdapter(mAdapter);
    }

    @OnItemClick(R.id.list)
    void clickItem(int position){
       // Toast.makeText(this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, DetailsActivity.class);
//        intent.putExtra(KEY_ELEMENT, mAdapter.getItem(position));
//        startActivity(intent);

    }
}
