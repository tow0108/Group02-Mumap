package com.egco428.a13283_a13265.mumap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
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
import com.egco428.a13283_a13265.mumap.Tram.TramDataSource;
import com.egco428.a13283_a13265.mumap.Tram.TramPath;

import java.util.List;

public class TramRoute extends AppCompatActivity {
    private Button btnFindPath;
    private EditText etOrigin;
    private EditText etDestination;
    private Button listofsource;
    Double latitude,longitude;
    private Button currentBtn;
    String des,ori;
    private String Desti;
    public static final String nearvalue = "value";
    private String Origin,Destination;
    private BuildingDataSource buildingDataSource;
    private TramDataSource tramDataSource;
    private ArrayAdapter<TramPath> buildingArrayAdapter,atmArrayAdapter,busArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tram_route);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbartram);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String position[] = getIntent().getExtras().getStringArray("position");
        latitude   = Double.parseDouble(position[0]);
        longitude = Double.parseDouble(position[1]);


        buildingDataSource = new BuildingDataSource(this);
        buildingDataSource.open();

        tramDataSource = new TramDataSource(this);
        tramDataSource.open();

        btnFindPath = (Button) findViewById(R.id.btnFindPathtram);
        etDestination = (EditText) findViewById(R.id.etDestinationtram);


        ListView cafelistView = (ListView) findViewById(R.id.bus1tram);
        final List<TramPath> bus1 = nearbyME(latitude,longitude,"4");
        buildingArrayAdapter = new TramRoute.CourseArrayAdapter(this, 0,bus1);
        cafelistView.setAdapter(buildingArrayAdapter);
        cafelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                if (buildingArrayAdapter.getCount()>0) {


                    final TramPath tramPath = bus1.get(position);
                    String deslatitude = tramPath.getLatitude();
                    String deslongitude = tramPath.getLongtitude();
                    Desti = deslatitude+" "+deslongitude;
                    des = (tramPath.getName());
                    etDestination.setText(tramPath.getName());


                }
            }
        });

        ListView ATMlistView = (ListView) findViewById(R.id.bus2tram);
        final List<TramPath> atm = nearbyME(latitude,longitude,"2");
        if (atm.isEmpty()){Toast.makeText(this,"Bus Stop not around you !",Toast.LENGTH_SHORT).show();}

        atmArrayAdapter = new TramRoute.CourseArrayAdapter(this, 0,atm);
        ATMlistView.setAdapter(atmArrayAdapter);
        ATMlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                if (atmArrayAdapter.getCount()>0) {


                    final TramPath tramPath = atm.get(position);
                    String deslatitude = tramPath.getLatitude();
                    String deslongitude = tramPath.getLongtitude();
                    Desti = deslatitude+" "+deslongitude;
                    des = (tramPath.getName());
                    etDestination.setText(tramPath.getName());


                }
            }
        });
        listofsource = (Button)findViewById(R.id.listofDestination);
        listofsource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TramRoute.this,ListTram.class);
                startActivityForResult(intent, 6);
            }
        });
        ListView BuslistView = (ListView) findViewById(R.id.bus3tram);
        final List<TramPath> bus = nearbyME(latitude,longitude,"3");
        if (bus.isEmpty()){Toast.makeText(this,"Bus Stop not around you !",Toast.LENGTH_SHORT).show();}
        else {
            busArrayAdapter = new TramRoute.CourseArrayAdapter(this, 0, bus);
            BuslistView.setAdapter(busArrayAdapter);
            BuslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int position, long l) {
                    if (busArrayAdapter.getCount() > 0) {


                        final TramPath buildingPlace = bus.get(position);
                        String deslatitude = buildingPlace.getLatitude();
                        String deslongitude = buildingPlace.getLongtitude();
                        String destination = deslatitude + " " + deslongitude;
                        Desti = destination;
                        des = (buildingPlace.getName().toString());
                        etDestination.setText(buildingPlace.getName());


                    }
                }
            });

        }
        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();


            }
        });




    }
    public String getOrigin (Double lat,Double longi){
        String origin = String.valueOf(lat)+" "+String.valueOf(longi);

        return origin;
    }
    public List<TramPath> nearbyME(Double lat , Double longi, String type){
         double latitude = lat;
         double  longitude = longi;
        String latmin = String.valueOf(latitude-0.001);
        String latmax = String.valueOf(latitude+0.001);
        String longmin = String.valueOf(longitude-0.001);
        String longmax = String.valueOf(longitude+0.001);

        final List<TramPath> values = tramDataSource.getNearBy(latmin,latmax,longmin,longmax,type);

        return values;
    }



    private void sendRequest() {

        String origin = latitude + " " + longitude;
        String destination ;

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
        intent.putExtra(nearvalue,inputValue);
        setResult(MainActivity.RESULT_OK, intent);
        finish();

    }
    class CourseArrayAdapter extends ArrayAdapter<TramPath> {
        Context context;
        List<TramPath> objects;
        public CourseArrayAdapter(Context context,int resource,List <TramPath> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            TramPath buildingPlace = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);//ประกาศตัวแปร Inflater
            View view = inflater.inflate(R.layout.layout_listview,null);//ตรง null ถ้าสร้างเป็นกรุ๊บ Layout สามารถใส่เพิ่มได้

            TextView word = (TextView)view.findViewById(R.id.textView);
            word.setText(buildingPlace.getId()+"  "+buildingPlace.getName());

            return view;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 6) {
            if (resultCode == ListTram.RESULT_OK) {
                String inputData[] = data.getStringArrayExtra(ListTram.XYposition);
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
