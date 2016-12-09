package lt.nfq.androidws.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import lt.nfq.androidws.Utils;
import lt.nfq.androidws.adapters.MovieAdapter;
import lt.nfq.androidws.models.Movie;
import lt.nfq.androidws.R;
import lt.nfq.androidws.services.MovieService;


public class ListActivity extends AppCompatActivity implements MovieService.MoviesCallback {

    public final static String KEY_ELEMENT = "key";

    @BindView(R.id.list)
    ListView mList;

    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        if(Utils.isConnected(this)) {
            MovieService.getMovies("fight", this);
        } else {
            Toast.makeText(this, "Nėra interneto", Toast.LENGTH_LONG).show();
        }
    }

    @OnItemClick(R.id.list)
    void clickItem(int position){
       // Toast.makeText(this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, DetailsActivity.class);
//        intent.putExtra(KEY_ELEMENT, mAdapter.getItem(position));
//        startActivity(intent);

    }

    @Override
    public void onSuccess(List<Movie> movies) {
        mAdapter = new MovieAdapter(this, movies);
        mList.setAdapter(mAdapter);
    }

    @Override
    public void onError() {

    }
}
