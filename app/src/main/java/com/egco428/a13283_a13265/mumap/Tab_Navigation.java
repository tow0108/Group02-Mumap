package com.egco428.a13283_a13265.mumap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.egco428.a13283_a13265.mumap.Building.BuildingDataSource;
import com.egco428.a13283_a13265.mumap.Building.BuildingPlace;
import com.egco428.a13283_a13265.mumap.Modules.DirectionFinder;
import com.egco428.a13283_a13265.mumap.Tram.TramDataSource;
import com.egco428.a13283_a13265.mumap.Tram.TramPath;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Tab_Navigation extends AppCompatActivity  {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Button btnFindPath;
    private EditText etOrigin;
    private EditText etDestination;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    public static final String value = "value";
    private BuildingDataSource buildingDataSource;
    private TramDataSource tramDataSource;
    Double latitude,longitude;
    private Button currentBtn,listofsource;
    String des,ori;
    private String Origin,Desti;
    private ArrayAdapter<BuildingPlace> buildingArrayAdapter,atmArrayAdapter,busArrayAdapter;
    public static final String nearvalue = "value";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String position[] = getIntent().getExtras().getStringArray("position");
        latitude   = Double.parseDouble(position[0]);
        longitude = Double.parseDouble(position[1]);


        buildingDataSource = new BuildingDataSource(this);
        buildingDataSource.open();

        tramDataSource = new TramDataSource(this);
        tramDataSource.open();

        listofsource = (Button)findViewById(R.id.listofSource);
        listofsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tab_Navigation.this,ListBuilding.class);
                startActivityForResult(intent, 5);
            }
        });

        btnFindPath = (Button) findViewById(R.id.btnFindPath);
        etOrigin = (EditText) findViewById(R.id.etOrigin);
        etDestination = (EditText) findViewById(R.id.etDestination);




        ListView cafelistView = (ListView) findViewById(R.id.buildingnear);
        final List<BuildingPlace> building = nearbyME(latitude,longitude,"4");
        buildingArrayAdapter = new Tab_Navigation.CourseArrayAdapter(this, 0,building);
        cafelistView.setAdapter(buildingArrayAdapter);
        cafelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                if (atmArrayAdapter.getCount()>0) {


                    final BuildingPlace buildingPlace = building.get(position);
                    String deslatitude = buildingPlace.getLatitude();
                    String deslongitude = buildingPlace.getLongitude();
                    String destination = deslatitude+" "+deslongitude;
                    Origin = destination;
                    ori = buildingPlace.getName();
                    etOrigin.setText(buildingPlace.getName());


                }
            }
        });

        ListView ATMlistView = (ListView) findViewById(R.id.atmnear);
        final List<BuildingPlace> atm = nearbyME(latitude,longitude,"1");
        atmArrayAdapter = new Tab_Navigation.CourseArrayAdapter(this, 0,atm);
        ATMlistView.setAdapter(atmArrayAdapter);
        ATMlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                if (atmArrayAdapter.getCount()>0) {


                    final BuildingPlace buildingPlace = atm.get(position);
                    String deslatitude = buildingPlace.getLatitude();
                    String deslongitude = buildingPlace.getLongitude();
                    String destination = deslatitude+" "+deslongitude;
                    Origin = destination;
                    ori = buildingPlace.getName();
                    etOrigin.setText(buildingPlace.getName());


                }
            }
        });

        ListView BuslistView = (ListView) findViewById(R.id.coffeenear);
        final List<BuildingPlace> bus = nearbyME(latitude,longitude,"3");
        if (bus.isEmpty()){Toast.makeText(this,"Bus Stop not around you !",Toast.LENGTH_SHORT).show();}
        else {
            busArrayAdapter = new Tab_Navigation.CourseArrayAdapter(this, 0, bus);
            BuslistView.setAdapter(busArrayAdapter);
            BuslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                    if (busArrayAdapter.getCount() > 0) {


                        final BuildingPlace buildingPlace = bus.get(position);
                        String deslatitude = buildingPlace.getLatitude();
                        String deslongitude = buildingPlace.getLongitude();
                        String destination = deslatitude + " " + deslongitude;
                        Origin = destination;
                        ori = buildingPlace.getName();
                        etOrigin.setText(buildingPlace.getName());


                    }
                }
            });




        }

        currentBtn = (Button) findViewById(R.id.currentLocation);
        currentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Origin = getOrigin(latitude, longitude);
                ori = "Your Location.";
                 etOrigin.setText("Your Location.");

            }
        });

        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();


            }
        });



    }
        public List<BuildingPlace> nearbyME(Double lat ,Double longi,String type){
            Double latitude = lat;
            Double longitude = longi;
            String latmin = String.valueOf(latitude-0.001);
            String latmax = String.valueOf(latitude+0.001);
            String longmin = String.valueOf(longitude-0.001);
            String longmax = String.valueOf(longitude+0.001);
            return buildingDataSource.getNearBy(latmin,latmax,longmin,longmax,type);
        }



    private void sendRequest() {
        String origin;
        String destination ;

        if(etOrigin.getText().toString().equals(ori)){origin = Origin;}
        else {origin = etOrigin.getText().toString();}

        if(etDestination.getText().toString().equals(des)){destination = Desti;}
        else {destination = etDestination.getText().toString();}



        if (origin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        String inputValue[] = {origin,destination};
        intent.putExtra(value,inputValue);
        setResult(MainActivity.RESULT_OK, intent);
        finish();

    }

    public String getOrigin (Double lat,Double longi){
        return String.valueOf(lat)+" "+String.valueOf(longi);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5) {
            if (resultCode == ListBuilding.RESULT_OK) {
                String inputData[] = data.getStringArrayExtra(ListBuilding.XYposition);
               String lat = inputData[0];
               String longi = inputData[1];
                String name = inputData[2];
                Desti = lat +" " + longi;
                des = name;
                etDestination.setText(name);



            }
        }
    }

}
