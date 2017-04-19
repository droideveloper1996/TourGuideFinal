package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ListView listView = (ListView) findViewById(R.id.restlistView);
        final ArrayList<City> restArrayList = new ArrayList<>();
        restArrayList.add(new City("Britto's Restaurant", "Beach Restaurants", "Famous for Water Soprts", "Vagator", "Famous for Sea Foods", "Beach Restaurants", R.drawable.beahparty, R.drawable.event));
        restArrayList.add(new City("Cameo Restaurant", "Beach Restaurants", "Famous for Water Soprts", "Vagator", "Famous for Sea Foods", "Beach Restaurants", R.drawable.food));
        CityAdapter restAdapter = new CityAdapter(this, restArrayList);
        listView.setAdapter(restAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = restArrayList.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Log.i("Resource ID", Integer.toString(res));
                Toast.makeText(getApplicationContext(), "Item CLicked on" + position + " with type " + type, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Restaurants.this, DetailActivity.class);
                i.putExtra("imageResourceId", res);
                i.putExtra("place", city1.getmPlace());
                i.putExtra("description", city1.getmDescription());
                i.putExtra("restaurant", city1.getmRestaurants());
                i.putExtra("attraction", city1.getmAttraction());
                i.putExtra("event", city1.getmEvent());
                startActivity(i);
            }
        });
    }
}
