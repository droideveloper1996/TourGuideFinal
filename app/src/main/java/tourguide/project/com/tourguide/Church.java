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

public class Church extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church);
        ListView churchList = (ListView) findViewById(R.id.churchListView);
        final ArrayList<City> church = new ArrayList<>();
        CityAdapter churchAdapter = new CityAdapter(this, church);
        church.add(new City("Three kings Chappel Church", "Church", "Haunted", "", "", "", R.drawable.church));
        church.add(new City("Our Lady of Rosary", "Church", "Haunted", "", "", "", R.drawable.church));
        churchList.setAdapter(churchAdapter);
        churchList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = church.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Log.i("Resource ID", Integer.toString(res));
                Toast.makeText(getApplicationContext(), "Item CLicked on" + position + " with type " + type, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Church.this, DetailActivity.class);
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
