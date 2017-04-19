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

public class Beach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);
        ListView beachListView = (ListView) findViewById(R.id.beachListView);
        final ArrayList<City> beaches = new ArrayList<>();
        beaches.add(new City("Pallolem Beach", "Beach", "Famous for Water Soprts", "Vagator", "Paradise for Couple", "Beach Sports", R.drawable.beach5));
        CityAdapter beachAdap = new CityAdapter(this, beaches);
        beachListView.setAdapter(beachAdap);
        beachListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                City city1 = beaches.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Log.i("Resource ID", Integer.toString(res));
                Toast.makeText(getApplicationContext(), "Item CLicked on" + position + " with type " + type, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Beach.this, DetailActivity.class);
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
