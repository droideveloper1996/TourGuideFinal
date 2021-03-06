package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class Beach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);
        ListView beachListView = (ListView) findViewById(R.id.beachListView);
        final ArrayList<City> beaches = new ArrayList<>();
        beaches.add(new City(getResources().getString(R.string.pallolem), getResources().getString(R.string.beach), getResources().getString(R.string.beachFamous), getResources().getString(R.string.vagator), getResources().getString(R.string.paradise), getResources().getString(R.string.beachsport), R.drawable.beach5));
        beaches.add(new City(getResources().getString(R.string.pallolem), getResources().getString(R.string.beach), getResources().getString(R.string.beachFamous), getResources().getString(R.string.vagator), getResources().getString(R.string.paradise), getResources().getString(R.string.beachsport), R.drawable.beach2));
        beaches.add(new City(getResources().getString(R.string.pallolem), getResources().getString(R.string.beach), getResources().getString(R.string.beachFamous), getResources().getString(R.string.vagator), getResources().getString(R.string.paradise), getResources().getString(R.string.beachsport), R.drawable.beach3));

        CityAdapter beachAdap = new CityAdapter(this, beaches);
        beachListView.setAdapter(beachAdap);
        beachListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                City city1 = beaches.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Intent i = new Intent(Beach.this, DetailActivity.class);
                i.putExtra(getResources().getString(R.string.imageResourceId), res);
                i.putExtra(getResources().getString(R.string.place), city1.getmPlace());
                i.putExtra(getResources().getString(R.string.description), city1.getmDescription());
                i.putExtra(getResources().getString(R.string.restaurant), city1.getmRestaurants());
                i.putExtra(getResources().getString(R.string.attraction), city1.getmAttraction());
                i.putExtra(getResources().getString(R.string.event), city1.getmEvent());
                startActivity(i);
            }
        });
    }
}
