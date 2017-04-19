package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        ImageView imageView = (ImageView) findViewById(R.id.emptyView);
        ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayList<City> city = new ArrayList<City>();

        city.add(new City("Beaches", R.drawable.beach));
        city.add(new City("Restaurants", R.drawable.food));
        city.add(new City("Church", R.drawable.church));
        city.add(new City("Events", R.drawable.event));
        city.add(new City("Hotels", R.drawable.hotel));
        city.add(new City("More Pics", R.drawable.pict));
        CityAdapter cityAdapter = new CityAdapter(this, city);
        listView.setAdapter(cityAdapter);
        listView.setEmptyView(imageView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = city.get(position);
                String place = city1.getmPlace();
                Toast.makeText(getApplicationContext(), place, Toast.LENGTH_SHORT).show();

                if (place.equals("Beaches")) {
                    startActivity(new Intent(MainActivity.this, Beach.class));
                } else if (place.equals("Restaurants")) {
                    startActivity(new Intent(MainActivity.this, Restaurants.class));

                } else if (place.equals("Church")) {
                    startActivity(new Intent(MainActivity.this, Church.class));

                } else if (place.equals("Hotels")) {
                    startActivity(new Intent(MainActivity.this, Hotel.class));

                } else if (place.equals("More Pics")) {
                    startActivity(new Intent(MainActivity.this, Pictures.class));

                } else {
                    startActivity(new Intent(MainActivity.this, Events.class));
                }
            }
        });

    }
}


