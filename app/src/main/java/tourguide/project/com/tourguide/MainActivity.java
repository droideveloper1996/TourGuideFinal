package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=(ImageView)findViewById(R.id.emptyView);
        ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayList<City> city = new ArrayList<City>();
        /**
         * String mPlace = location of place,
         * String mType,
         * String mDescription,
         * String mRestaurants,
         * String mAttraction,
         * String mEvent
         */


        city.add(new City("Calangaute Beach", "Beach", "Magnificent Sunset", "Majorda", "Beach Side Restaurent", "Beach Party",R.drawable.beach));
        city.add(new City("Vagator Beach", "Beach Sports", "Famous for Water Soprts", "Vagator", "Water Soprts", "Beach Sports",R.drawable.sports));
        city.add(new City("Cameo Restaurant", "Beach Restaurants", "Famous for Water Soprts", "Vagator", "Famous for Sea Foods", "Beach Restaurants",R.drawable.food));
        city.add(new City("Anjuna Beach", "Beach", "Anjuna Beach", "Heaven for sea Food Lovers", "Famous for nightlife and parties. For Hippies", "Beach Party",R.drawable.church));
        city.add(new City("Britto's Restaurant", "Beach Restaurants", "Famous for Water Soprts", "Vagator", "Famous for Sea Foods", "Beach Restaurants",R.drawable.beahparty,R.drawable.event));
        CityAdapter cityAdapter = new CityAdapter(this, city);
        listView.setAdapter(cityAdapter);
        listView.setEmptyView(imageView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = city.get(position);
                String type = city1.getmType();
                int res=city1.getmImageResouceId();
                Log.i("Resource ID",Integer.toString(res));
                Toast.makeText(getApplicationContext(), "Item CLicked on" + position + " with type " + type, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("imageResourceId", res);
                i.putExtra("place", city1.getmPlace());
                i.putExtra("description", city1.getmDescription());
                i.putExtra("restaurant", city1.getmRestaurants());
                i.putExtra("attraction", city1.getmAttraction());
                i.putExtra("event", city1.getmEvent());
               startActivity(i);
            }
        });
        cityAdapter.setNotifyOnChange(true);
    }
}
