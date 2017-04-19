package tourguide.project.com.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class Church extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church);
        ListView churchList = (ListView) findViewById(R.id.churchListView);
        final ArrayList<City> church = new ArrayList<>();
        CityAdapter churchAdapter = new CityAdapter(this, church);
        church.add(new City(getResources().getString(R.string.church_name), getResources().getString(R.string.church), "", "", "", "", R.drawable.church));
        church.add(new City(getResources().getString(R.string.church_name1), getResources().getString(R.string.church), "", "", "", "", R.drawable.church));
        churchList.setAdapter(churchAdapter);
        churchList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                City city1 = church.get(position);
                String type = city1.getmType();
                int res = city1.getmImageResouceId();
                Intent i = new Intent(Church.this, DetailActivity.class);
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
