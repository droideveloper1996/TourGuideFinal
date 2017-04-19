package tourguide.project.com.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Pictures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        ListView pictureListView = (ListView) findViewById(R.id.picture_listView);
        ArrayList<City> picture1 = new ArrayList<City>();
        CityAdapter pictures = new CityAdapter(this, picture1);
        picture1.add(new City("", "", "", "", "", "", R.drawable.beahparty));
        picture1.add(new City("", "", "", "", "", "", R.drawable.beahparty));
        picture1.add(new City("", "", "", "", "", "", R.drawable.beahparty));
        pictureListView.setAdapter(pictures);
    }
}
