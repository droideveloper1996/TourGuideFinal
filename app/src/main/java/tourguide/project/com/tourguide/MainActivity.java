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

        city.add(new City(getResources().getString(R.string.beach), R.drawable.beach));
        city.add(new City(getResources().getString(R.string.restaurants), R.drawable.food));
        city.add(new City(getResources().getString(R.string.church), R.drawable.church));
        city.add(new City(getResources().getString(R.string.events), R.drawable.event));
        city.add(new City(getResources().getString(R.string.hotel), R.drawable.hotel));
        city.add(new City(getResources().getString(R.string.pictures), R.drawable.pict));
        CityAdapter cityAdapter = new CityAdapter(this, city);
        listView.setAdapter(cityAdapter);
        listView.setEmptyView(imageView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = city.get(position);
                String place = city1.getmPlace();
                Toast.makeText(getApplicationContext(), place, Toast.LENGTH_SHORT).show();

                if (place.equals(getResources().getString(R.string.beach))) {
                    startActivity(new Intent(MainActivity.this, Beach.class));
                } else if (place.equals(getResources().getString(R.string.restaurants))) {
                    startActivity(new Intent(MainActivity.this, Restaurants.class));

                } else if (place.equals(getResources().getString(R.string.church))) {
                    startActivity(new Intent(MainActivity.this, Church.class));

                } else if (place.equals((getResources().getString(R.string.hotel)))) {
                    startActivity(new Intent(MainActivity.this, Hotel.class));

                } else if (place.equals(getResources().getString(R.string.pictures))) {
                    startActivity(new Intent(MainActivity.this, Pictures.class));

                } else {
                    startActivity(new Intent(MainActivity.this, Events.class));
                }
            }
        });

    }
}


