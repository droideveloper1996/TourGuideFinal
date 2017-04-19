package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ListView eventsListView=(ListView)findViewById(R.id.eventsListView);
       final ArrayList<City> events=new ArrayList<>();
        CityAdapter eventsAdap=new CityAdapter(this,events);
        events.add(new City(getString(R.string.party), getString(R.string.palm), getString(R.string.club), getString(R.string.club), getString(R.string.club) , getString(R.string.club), R.drawable.event));
        eventsListView.setAdapter(eventsAdap);
        eventsListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = events.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Intent i = new Intent(Events.this, DetailActivity.class);
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
