package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ListView listView = (ListView) findViewById(R.id.restlistView);
        final ArrayList<City> restArrayList = new ArrayList<>();
        restArrayList.add(new City(getString(R.string.restname), getString(R.string.rest), getString(R.string.famousrest), getString(R.string.beachPlace),getString(R.string.special), getString(R.string.beachRest), R.drawable.beahparty, R.drawable.event));
        CityAdapter restAdapter = new CityAdapter(this, restArrayList);
        listView.setAdapter(restAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = restArrayList.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Intent i = new Intent(Restaurants.this, DetailActivity.class);
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
