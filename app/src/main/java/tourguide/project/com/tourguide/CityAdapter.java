package tourguide.project.com.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abhishek on 16/04/2017.
 */

class CityAdapter extends ArrayAdapter<City>{
    public CityAdapter( Context context,  ArrayList<City> city) {
        super(context, 0, city);
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView=LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        City current_object=getItem(position);

        TextView location=(TextView)listItemView.findViewById(R.id.location);
        TextView type=(TextView)listItemView.findViewById(R.id.type);
        TextView attaction=(TextView)listItemView.findViewById(R.id.attraction);

        location.setText(current_object.getmPlace());
        attaction.setText(current_object.getmAttraction());
        type.setText(current_object.getmType());

        return listItemView;
    }
}
