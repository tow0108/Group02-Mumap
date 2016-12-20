package com.egco428.a13283_a13265.mumap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.egco428.a13283_a13265.mumap.Tram.TramDataSource;

import java.util.List;

public class NearByActivity extends AppCompatActivity {
    private BuildingDataSource buildingDataSource;
    private TramDataSource tramDataSource;
    private ArrayAdapter<BuildingPlace> buildingArrayAdapter,atmArrayAdapter,busArrayAdapter;
    Double latitude,longitude;
    public static final String XYposition = "position";
    public static final String nearvalue = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buildingDataSource = new BuildingDataSource(this);
        buildingDataSource.open();

        tramDataSource = new TramDataSource(this);
        tramDataSource.open();

        String position[] = getIntent().getExtras().getStringArray("position");
        latitude   = Double.parseDouble(position[0]);
        longitude = Double.parseDouble(position[1]);


        ListView cafelistView = (ListView) findViewById(R.id.buildList);
        final List<BuildingPlace> building = nearbyME(latitude,longitude,"3");
        buildingArrayAdapter = new NearByActivity.CourseArrayAdapter(this, 0,building);
        cafelistView.setAdapter(buildingArrayAdapter);
        cafelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                if (atmArrayAdapter.getCount()>0) {


                    final BuildingPlace buildingPlace = building.get(position);
                    String deslatitude = buildingPlace.getLatitude();
                    String deslongitude = buildingPlace.getLongitude();
                    String destination = deslatitude+" "+deslongitude;
                    String origin = latitude + " " + longitude;
                    Intent intent = new Intent();
                    String inputValue[] = {origin,destination};
                    intent.putExtra(nearvalue,inputValue);
                    setResult(MainActivity.RESULT_OK, intent);
                    finish();

                }
            }
        });

        ListView ATMlistView = (ListView) findViewById(R.id.atmList);
        final List<BuildingPlace> atm = nearbyME(latitude,longitude,"2");
        atmArrayAdapter = new NearByActivity.CourseArrayAdapter(this, 0,atm);
        ATMlistView.setAdapter(atmArrayAdapter);
        ATMlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                if (atmArrayAdapter.getCount()>0) {


                    final BuildingPlace buildingPlace = atm.get(position);
                    String deslatitude = buildingPlace.getLatitude();
                    String deslongitude = buildingPlace.getLongitude();
                    String destination = deslatitude+" "+deslongitude;
                    String origin = latitude + " " + longitude;
                    Intent intent = new Intent();
                    String inputValue[] = {origin,destination};
                    intent.putExtra(nearvalue,inputValue);
                    setResult(MainActivity.RESULT_OK, intent);
                    finish();

                }
            }
        });

        ListView BuslistView = (ListView) findViewById(R.id.buslist);
        final List<BuildingPlace> bus = nearbyME(latitude,longitude,"4");
        if (bus.isEmpty()){Toast.makeText(this,"Bus Stop not around you !",Toast.LENGTH_SHORT).show();}
        else {
            busArrayAdapter = new NearByActivity.CourseArrayAdapter(this, 0, bus);
            BuslistView.setAdapter(busArrayAdapter);
            BuslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                    if (busArrayAdapter.getCount()>0) {


                        final BuildingPlace buildingPlace = bus.get(position);
                        String deslatitude = buildingPlace.getLatitude();
                        String deslongitude = buildingPlace.getLongitude();
                        String destination = deslatitude+" "+deslongitude;
                        String origin = latitude + " " + longitude;
                        Intent intent = new Intent();
                        String inputValue[] = {origin,destination};
                        intent.putExtra(nearvalue,inputValue);
                        setResult(MainActivity.RESULT_OK, intent);
                        finish();

                    }
                }
            });
        }


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


    public List<BuildingPlace> nearbyME(Double lat ,Double longi,String type){
        Double latitude = lat;
        Double longitude = longi;
        String latmin = String.valueOf(latitude-0.001);
        String latmax = String.valueOf(latitude+0.001);
        String longmin = String.valueOf(longitude-0.001);
        String longmax = String.valueOf(longitude+0.001);

        final List<BuildingPlace> values = buildingDataSource.getNearBy(latmin,latmax,longmin,longmax,type);

        return values;
    }
}
