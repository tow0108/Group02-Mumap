package com.egco428.a13283_a13265.mumap;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Aylar-HP on 28/09/2015.
 */
public class MyLocListener implements LocationListener {
    private Double lat;
    private Double longi;

    @Override
    public void onLocationChanged(Location location)
    {
        if(location != null)
        {
            Log.e("Latitude :", "" + location.getLatitude());
            Log.e("Longitude :", "" + location.getLongitude());
            lat = location.getLatitude();
            longi = location.getLongitude();
        }
    }
    public Double getlat (){return lat;}
    public Double getlongi (){return longi;}


    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

}
