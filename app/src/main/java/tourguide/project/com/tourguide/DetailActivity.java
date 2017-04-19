package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imageView = (ImageView) findViewById(R.id.detailImageView);
        TextView textView = (TextView) findViewById(R.id.detailTextView);
        Intent i = getIntent();
        int resource = i.getIntExtra(getResources().getString(R.string.imageResourceId), -1);
        String description = i.getStringExtra(getResources().getString(R.string.description));
        String restaurant = i.getStringExtra(getResources().getString(R.string.restaurant));
        String attraction = i.getStringExtra(getResources().getString(R.string.attraction));
        String event = i.getStringExtra(getResources().getString(R.string.event));
        String place = i.getStringExtra(getString(R.string.place));
        if (resource != -1) {
            imageView.setImageResource(resource);
        }
        textView.setText(place + '\n' + attraction + '\n' + description + '\n' + restaurant + '\n' + event);
    }
}
