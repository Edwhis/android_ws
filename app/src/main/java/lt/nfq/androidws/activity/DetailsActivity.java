package lt.nfq.androidws.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lt.nfq.androidws.R;
import lt.nfq.androidws.activity.ListActivity;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.element)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String element = intent.getStringExtra(ListActivity.KEY_ELEMENT);
        text.setText(element);
    }
}
