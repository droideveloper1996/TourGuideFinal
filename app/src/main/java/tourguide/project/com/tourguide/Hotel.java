package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class Hotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        final ListView listView=(ListView)findViewById(R.id.hotelListView);
        final ArrayList<City> cityArrayList=new ArrayList<>();
        cityArrayList.add(new City(getString(R.string.maria), getString(R.string.hotelPalm), getString(R.string.budget), getString(R.string.pool),getString(R.string.star), getString(R.string.club), R.drawable.hotel));
        CityAdapter cityAdapter=new CityAdapter(this,cityArrayList);
        listView.setAdapter(cityAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = cityArrayList.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Intent i = new Intent(Hotel.this, DetailActivity.class);
                i.putExtra(getResources().getString(R.string.imageResourceId), res);
                i.putExtra(getResources().getString(R.string.place), city1.getmPlace());
                i.putExtra(getResources().getString(R.string.restaurant), city1.getmRestaurants());
                i.putExtra(getResources().getString(R.string.description), city1.getmRestaurants());
                i.putExtra(getResources().getString(R.string.attraction), city1.getmAttraction());
                i.putExtra(getResources().getString(R.string.event), city1.getmEvent());
                startActivity(i);
            }
        });
    }
}
