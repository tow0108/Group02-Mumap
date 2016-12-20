package com.egco428.a13283_a13265.mumap;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PointF;
import android.hardware.camera2.CameraManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.egco428.a13283_a13265.mumap.Building.BuildingDataSource;
import com.egco428.a13283_a13265.mumap.Building.BuildingPlace;
import com.egco428.a13283_a13265.mumap.Modules.DirectionFinder;
import com.egco428.a13283_a13265.mumap.Modules.DirectionFinderListener;
import com.egco428.a13283_a13265.mumap.Modules.Route;
import com.egco428.a13283_a13265.mumap.Tram.TramDataSource;
import com.egco428.a13283_a13265.mumap.Tram.TramPath;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, ActivityCompat.OnRequestPermissionsResultCallback, DirectionFinderListener, android.location.LocationListener,View.OnTouchListener {

    private GoogleMap mMap;
    private LatLngBounds Mahidol = new LatLngBounds(
            new LatLng(13.80103, 100.328), new LatLng(13.90153, 100.33614065));

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean mPermissionDenied = false;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private List<Marker> serchMarkers = new ArrayList<>();
    private ProgressDialog progressDialog;
    String origin, destination;
    public static final String XYposition = "position";
    private BuildingDataSource buildingDataSource;
    private TramDataSource tramDataSource;
    Double latitude, longtitude;
    private LocationManager locationManager;
    private LocationListener locationListener;

    List<Marker> buildmarkers = new ArrayList<>();
    int buildcount = 1;


    List<Marker> coffeemarkers = new ArrayList<>();
    int coffeecount = 1;


    List<Marker> atmmarkers = new ArrayList<>();
    int atmcount = 1;


    List<Polyline> tram1polylines = new ArrayList<>();
    List<Marker> tram1markers = new ArrayList<>();
    int tram1count = 1;


    List<Polyline> tram2polylines = new ArrayList<>();
    List<Marker> tram2markers = new ArrayList<>();
    int tram2count = 1;


    List<Polyline> tram3polylines = new ArrayList<>();
    List<Marker> tram3markers = new ArrayList<>();
    int tram3count = 1;

    List<Polyline> tram4polylines = new ArrayList<>();
    List<Marker> tram4markers = new ArrayList<>();
    int tram4count = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (googleServicesAvalible()) {
//            Toast.makeText(this,"Perfect !!",Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.mapFragment);
            mapFragment.getMapAsync(this);

        } else {
            // No Google map layout NOOO //
        }


        LocationManager myManager;
        MyLocListener loc = new MyLocListener();
        myManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        myManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, (android.location.LocationListener) MainActivity.this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        buildingDataSource = new BuildingDataSource(this);
        buildingDataSource.open();
        buildingDataSource.createComment();
        Toast.makeText(this,"Data dowload completed",Toast.LENGTH_LONG).show();

        final List<BuildingPlace> values = buildingDataSource.getAllComments();

        tramDataSource = new TramDataSource(this);
        tramDataSource.open();
        tramDataSource.createComment();
        final List<TramPath> values2 = tramDataSource.getAllComments();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
//            Intent intent = new Intent(this,Contact.class);
//            startActivity(intent);

        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
        }

        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this,  SearchActivity.class);
                startActivityForResult(intent, 2);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();
        if (id == R.id.mumap) {

            ((TextView) findViewById(R.id.tvDistance)).setText("0.0 km");
            ((TextView) findViewById(R.id.tvDuration)).setText("0 min");

            if (serchMarkers != null) {
                for (Marker marker : serchMarkers) {
                    marker.remove();
                }
            }


            if (tram1count == 0) {

                if (tram1markers != null) {
                    for (Marker marker : tram1markers) {
                        marker.remove();
                    }
                }

                if (tram1polylines != null) {
                    for (Polyline polyline : tram1polylines) {
                        polyline.remove();
                    }
                }
                tram1count++;

            }

            if (tram2count == 0) {

                if (tram2markers != null) {
                    for (Marker marker : tram2markers) {
                        marker.remove();
                    }
                }

                if (tram2polylines != null) {
                    for (Polyline polyline : tram2polylines) {
                        polyline.remove();
                    }
                }
                tram2count++;

            }
            if (tram3count == 0) {

                if (tram3markers != null) {
                    for (Marker marker : tram3markers) {
                        marker.remove();
                    }
                }

                if (tram3polylines != null) {
                    for (Polyline polyline : tram3polylines) {
                        polyline.remove();
                    }
                }
                tram3count++;

            }
            if (tram4count == 0) {

                if (tram4markers != null) {
                    for (Marker marker : tram4markers) {
                        marker.remove();
                    }
                }

                if (tram4polylines != null) {
                    for (Polyline polyline : tram1polylines) {
                        polyline.remove();
                    }
                }
                tram4count++;

            }
            if (originMarkers != null) {
                for (Marker marker : originMarkers) {
                    marker.remove();
                }
            }

            if (destinationMarkers != null) {
                for (Marker marker : destinationMarkers) {
                    marker.remove();
                }
            }

            if (polylinePaths != null) {
                for (Polyline polyline:polylinePaths ) {
                    polyline.remove();
                }
            }
            if (atmcount == 0) {

                if (atmmarkers != null) {
                    for (Marker marker : atmmarkers) {
                        marker.remove();
                    }
                }
                atmcount++;

            }
            if (buildcount == 0) {

                if (buildmarkers != null) {
                    for (Marker marker : buildmarkers) {
                        marker.remove();
                    }
                }
                atmcount++;

            }
            if (coffeecount == 0) {

                if (atmmarkers != null) {
                    for (Marker marker : coffeemarkers) {
                        marker.remove();
                    }
                }
                coffeecount++;

            }


            // Handle the camera action
        } else if (id == R.id.navigator) {
            Intent intent = new Intent(this,  Tab_Navigation.class);
            String inputValue[] = {String.valueOf(latitude),String.valueOf(longtitude)};
            intent.putExtra(XYposition,inputValue);
            startActivityForResult(intent, 1);
        }  else if (id == R.id.nearBy) {

            Intent intent = new Intent(MainActivity.this,NearByActivity.class);
            String inputValue[] = {String.valueOf(latitude),String.valueOf(longtitude)};
            intent.putExtra(XYposition,inputValue);
            startActivityForResult(intent, 3);


//            Intent intent = new Intent(this,  Setting.class);
//            startActivity(intent);
       } else if (id == R.id.tram1) {

            final List<TramPath> route1 =  tramDataSource.getAllType("5");
            final List<TramPath> markroute1 =  tramDataSource.getAllType("1");

            if (tram1count == 0) {

                if (tram1markers != null) {
                    for (Marker marker : tram1markers) {
                        marker.remove();
                    }
                }

                if (tram1polylines != null) {
                    for (Polyline polyline : tram1polylines) {
                        polyline.remove();
                    }
                }
                tram1count++;

            }
            else {

                for (int i = 0; i < markroute1.size(); i++) {

                    Double markx = Double.parseDouble(markroute1.get(i).getLatitude());
                    Double marky = Double.parseDouble(markroute1.get(i).getLongtitude());
                    String origin = markroute1.get(i).getLatitude() + " " + markroute1.get(i).getLongtitude();
                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.tram1);
                 tram1markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(markx, marky))
                            .icon(icon)
                            .title("Yellow Tram No.1")
                            .snippet(origin)));
                }


                PolylineOptions options = new PolylineOptions().width(5).color(Color.YELLOW);
                for (int i = 0; i < route1.size(); i++) {

                    Double lat = Double.parseDouble(route1.get(i).getLatitude());
                    Double longi = Double.parseDouble(route1.get(i).getLongtitude());
                    options.add(new LatLng(lat, longi));
                }
                tram1polylines.add(mMap.addPolyline(options));
                tram1count--;
            }
        }
        else if (id == R.id.tram2){

            final List<TramPath> route1 =  tramDataSource.getAllType("6");
            final List<TramPath> markroute1 =  tramDataSource.getAllType("2");

            if (tram2count == 0) {

                if (tram2markers != null) {
                    for (Marker marker : tram2markers) {
                        marker.remove();
                    }
                }

                if (tram2polylines != null) {
                    for (Polyline polyline : tram2polylines) {
                        polyline.remove();
                    }
                }
                tram2count++;

            }
            else {

                for (int i = 0; i < markroute1.size(); i++) {

                    Double markx = Double.parseDouble(markroute1.get(i).getLatitude());
                    Double marky = Double.parseDouble(markroute1.get(i).getLongtitude());
                    String origin = markroute1.get(i).getLatitude() + " " + markroute1.get(i).getLongtitude();
                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.tram2);
                tram2markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(markx, marky))
                            .icon(icon)
                            .title("Blue Tram No.2")
                            .snippet(origin)));
                }

                PolylineOptions options = new PolylineOptions().width(5).color(Color.BLUE);
                for (int i = 0; i < route1.size(); i++) {

                    Double lat = Double.parseDouble(route1.get(i).getLatitude());
                    Double longi = Double.parseDouble(route1.get(i).getLongtitude());
                    options.add(new LatLng(lat, longi));
                }
                tram2polylines.add(mMap.addPolyline(options));
                tram2count--;

            }
        }
        else if (id == R.id.tram3){
            final List<TramPath> route1 =  tramDataSource.getAllType("7");
            final List<TramPath> markroute1 =  tramDataSource.getAllType("3");

            if (tram3count == 0) {

                if (tram3markers != null) {
                    for (Marker marker : tram3markers) {
                        marker.remove();
                    }
                }

                if (tram3polylines != null) {
                    for (Polyline polyline : tram3polylines) {
                        polyline.remove();
                    }
                }
                tram3count++;

            }
            else {

                for (int i = 0; i < markroute1.size(); i++) {

                    Double markx = Double.parseDouble(markroute1.get(i).getLatitude());
                    Double marky = Double.parseDouble(markroute1.get(i).getLongtitude());
                    String origin = markroute1.get(i).getLatitude() + " " + markroute1.get(i).getLongtitude();
                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.tram3);
                  tram3markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(markx, marky))
                            .icon(icon)
                            .title("Red Tram No.2")
                            .snippet(origin)));
                }

                PolylineOptions options = new PolylineOptions().width(5).color(Color.RED);
                for (int i = 0; i < route1.size(); i++) {

                    Double lat = Double.parseDouble(route1.get(i).getLatitude());
                    Double longi = Double.parseDouble(route1.get(i).getLongtitude());

                    options.add(new LatLng(lat, longi));
                }
                tram3polylines.add(mMap.addPolyline(options));
                tram3count--;

            }

        }
        else if (id == R.id.tram4){
            final List<TramPath> route1 =  tramDataSource.getAllType("8");
            final List<TramPath> markroute1 =  tramDataSource.getAllType("4");


            if (tram4count == 0) {

                if (tram4markers != null) {
                    for (Marker marker : tram4markers) {
                        marker.remove();
                    }
                }

                if (tram4polylines != null) {
                    for (Polyline polyline : tram4polylines) {
                        polyline.remove();
                    }
                }
                tram4count++;

            }
            else {

                for (int i = 0; i < markroute1.size(); i++) {

                    Double markx = Double.parseDouble(markroute1.get(i).getLatitude());
                    Double marky = Double.parseDouble(markroute1.get(i).getLongtitude());
                    String origin = markroute1.get(i).getLatitude() + " " + markroute1.get(i).getLongtitude();
                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.tram4);
                    tram4markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(markx, marky))
                            .icon(icon)
                            .title("Green Tram No.2")
                            .snippet(origin)));

                }

                PolylineOptions options = new PolylineOptions().width(5).color(Color.GREEN);
                for (int i = 0; i < route1.size(); i++) {

                    Double lat = Double.parseDouble(route1.get(i).getLatitude());
                    Double longi = Double.parseDouble(route1.get(i).getLongtitude());

                    options.add(new LatLng(lat, longi));
                }
                tram4polylines.add(mMap.addPolyline(options));
                tram4count--;
            }

        }
        else if (id == R.id.atm){
            final List<BuildingPlace> markroute = buildingDataSource.getAllType("2");


            if (atmcount == 0) {

                        if (atmmarkers != null) {
                            for (Marker marker : atmmarkers) {
                                marker.remove();
                            }
                        }
                        atmcount++;

            }
            else {
                    for (int i = 0; i < markroute.size(); i++) {

                        Double markx = Double.parseDouble(markroute.get(i).getLatitude());
                        Double marky = Double.parseDouble(markroute.get(i).getLongitude());
                        String origin = markroute.get(i).getLatitude() + " " + markroute.get(i).getLongitude();

                        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.credit_card);
                      atmmarkers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(markx, marky))
                                .icon(icon)
                                .title(markroute.get(i).getName() + "")
                                .snippet(origin)));
                    }
                atmcount--;

            }

        }
        else if (id == R.id.cafe){

            final List<BuildingPlace> markroute = buildingDataSource.getAllType("3");

            if (coffeecount == 0) {

                if (coffeemarkers != null) {
                    for (Marker marker : coffeemarkers) {
                        marker.remove();
                    }
                }
                coffeecount++;

            }
            else {

                for (int i = 0; i < markroute.size(); i++) {

                    Double markx = Double.parseDouble(markroute.get(i).getLatitude());
                    Double marky = Double.parseDouble(markroute.get(i).getLongitude());
                    String origin = markroute.get(i).getLatitude() + " " + markroute.get(i).getLongitude();

                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.coffee);
                 coffeemarkers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(markx, marky))
                            .icon(icon)
                            .title(markroute.get(i).getName() + "")
                            .snippet(origin)));
                }
                coffeecount--;
            }
        }
        else if (id == R.id.building){

            final List<BuildingPlace> markroute = buildingDataSource.getAllType("1");

            if (buildcount == 0) {

                if (buildmarkers != null) {
                    for (Marker marker : buildmarkers) {
                        marker.remove();
                    }
                }
                buildcount++;


            }
            else {

                for (int i = 0; i < markroute.size(); i++) {

                    Double markx = Double.parseDouble(markroute.get(i).getLatitude());
                    Double marky = Double.parseDouble(markroute.get(i).getLongitude());
                    String origin = markroute.get(i).getLatitude() + " " + markroute.get(i).getLongitude();
                    BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.home);
                 buildmarkers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(markx, marky))
                            .icon(icon)
                            .title(markroute.get(i).getName() + "")
                            .snippet(origin)));
                }
                buildcount--;
            }
        }

        else if (id == R.id.navigatorTram) {
            Intent intent = new Intent(this,  TramRoute.class);
            String inputValue[] = {String.valueOf(latitude),String.valueOf(longtitude)};
            intent.putExtra(XYposition,inputValue);
            startActivityForResult(intent, 4);
        }
        else if (id == R.id.contact){
            Intent intent = new Intent(MainActivity.this,Contact.class);
            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean googleServicesAvalible(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }else if (api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this,isAvailable,0);
            dialog.show();;
        }else {
            Toast.makeText(this,"Cant connect to play servieces",Toast.LENGTH_LONG).show();
        }
        return false;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();

        // Add a marker in Sydney and move the camera
        LatLng mahidol = new LatLng(13.795544, 100.322700);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Mahidol.getCenter(), 10));
        mMap.addMarker(new MarkerOptions().position(mahidol).title("Marker in Mahidol"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mahidol));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.795544, 100.322700),15));

//        setUpMap();

    }
    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    android.Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }

    }
    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();

        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Tab_Navigation.RESULT_OK){
                String inputData[] = data.getStringArrayExtra(Tab_Navigation.value);
                origin = inputData[0];
                destination = inputData[1];
                try {
                    new DirectionFinder(this, origin, destination).execute();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }
        else if (requestCode == 2) {
            if(resultCode == SearchActivity.RESULT_OK){
                String inputData[] = data.getStringArrayExtra(SearchActivity.XYposition);
                latitude   = Double.parseDouble(inputData[0]);
                longtitude = Double.parseDouble(inputData[1]);
                String name = inputData[2];
                LatLng target = new LatLng(latitude, longtitude);
//                BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.mapicona);
                serchMarkers.add(mMap.addMarker(new MarkerOptions().position(target).title(name)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(target));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude),17));

            }
        }

        else if (requestCode == 3) {
                if(resultCode == NearByActivity.RESULT_OK){
                    String inputData[] = data.getStringArrayExtra(NearByActivity.nearvalue);
                    origin = inputData[0];
                    destination = inputData[1];

                    try {
                        new DirectionFinder(this, origin, destination).execute();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                }



        }
        if (requestCode == 4) {
            if(resultCode == TramRoute.RESULT_OK){
                String inputData[] = data.getStringArrayExtra(TramRoute.nearvalue);
                origin = inputData[0];
                destination = inputData[1];
                try {
                    new DirectionFinder(this, origin, destination).execute();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }


    }


    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Finding direction..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }

    }
    @Override
    protected void onResume(){
        super.onResume();
        buildingDataSource.open();
        tramDataSource.open();
    }
    @Override
    protected void onPause(){
        super.onPause();
        buildingDataSource.close();
        tramDataSource.close();
    }

    @Override
    public void onLocationChanged(Location location)
    {
        if(location != null)
        {
            Log.e("Latitude Main:", "" + location.getLatitude());
            Log.e("Longitude Main:", "" + location.getLongitude());
            latitude = location.getLatitude();
            longtitude = location.getLongitude();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        

        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }
}



