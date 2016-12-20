package com.egco428.a13283_a13265.mumap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.egco428.a13283_a13265.mumap.Building.BuildingDataSource;
import com.egco428.a13283_a13265.mumap.Building.BuildingPlace;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    BuildingDataSource buildingDataSource;
    private ArrayAdapter<BuildingPlace> courseArrayAdapter;
    public static final String XYposition = "position";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buildingDataSource = new BuildingDataSource(this);
        buildingDataSource.open();
        final List<BuildingPlace> values = buildingDataSource.getAllComments();
        ListView listView = (ListView) findViewById(R.id.buildingList);
        courseArrayAdapter = new CourseArrayAdapter(this, 0,values);
        listView.setAdapter(courseArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,final View view, int position, long l) {
                if (courseArrayAdapter.getCount()>0) {

                    final BuildingPlace buildingPlace = values.get(position);
                    String latitude = buildingPlace.getLatitude();
                    String longitude = buildingPlace.getLongitude();
                    Intent intent = new Intent();
                    String inputValue[] = {latitude,longitude,buildingPlace.getName()};
                    intent.putExtra(XYposition,inputValue);
                    setResult(SearchActivity.RESULT_OK, intent);
                    finish();

                }
            }
        });

    }

    class CourseArrayAdapter extends ArrayAdapter<BuildingPlace> {
        Context context;
        List<BuildingPlace> objects;
        public CourseArrayAdapter(Context context,int resource,List <BuildingPlace> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            BuildingPlace buildingPlace = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);//ประกาศตัวแปร Inflater
            View view = inflater.inflate(R.layout.layout_listview,null);//ตรง null ถ้าสร้างเป็นกรุ๊บ Layout สามารถใส่เพิ่มได้

            TextView word = (TextView)view.findViewById(R.id.textView);
            word.setText(buildingPlace.getId()+"  "+buildingPlace.getName());
            word.setTextColor(Color.parseColor("#FFFFFF"));

            return view;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        buildingDataSource.open();
    }
    @Override
    protected void onPause(){
        super.onPause();
        buildingDataSource.close();
    }
}
