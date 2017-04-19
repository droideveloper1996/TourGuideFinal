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

public class Hotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        final ListView listView=(ListView)findViewById(R.id.hotelListView);
        final ArrayList<City> cityArrayList=new ArrayList<>();
        cityArrayList.add(new City("Maria Resort", "Hotel Palm", "Budget Hotel", "Pool", "3 star", "Club", R.drawable.hotel));
        cityArrayList.add(new City("Acacia Palm", "DJ", "Club", "PoolParty", "5 star Hotel", "Club", R.drawable.hotel));
        CityAdapter cityAdapter=new CityAdapter(this,cityArrayList);
        listView.setAdapter(cityAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = cityArrayList.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Log.i("Resource ID", Integer.toString(res));
                Toast.makeText(getApplicationContext(), "Item CLicked on" + position + " with type " + type, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Hotel.this, DetailActivity.class);
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
