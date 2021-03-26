package com.example.maps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class Maps2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    public void getLocationFromAddress(String strAddress, String str1) {


        List<Address> address;
        List<Address> address2;

        try {
            address = geocoder.getFromLocationName(strAddress, 1);
            if (address == null) {
                Toast.makeText(getApplicationContext(), "Destino no encontrado",Toast.LENGTH_LONG).show();
            }
            Address location = address.get(0);
            Double lat = location.getLatitude();
            Double lng = location.getLongitude();

            LatLng one = new LatLng(lat,lng);

            address2 = geocoder.getFromLocationName(str1, 1);
            if (address2 == null) {
                Toast.makeText(getApplicationContext(), "Destino no encontrado",Toast.LENGTH_LONG).show();
            }
            Address location1 = address.get(0);
            Double lat1 = location1.getLatitude();
            Double lng1 = location1.getLongitude();

            LatLng two = new LatLng(lat1,lng1);

            Polyline polyline=mMap.addPolyline(new PolylineOptions().add(one,two).width(5).color(Color.RED));


        } catch (Exception e) {

        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        String val1=getIntent().getExtras().getString("PTA");
        String val2=getIntent().getExtras().getString("dest");
        getLocationFromAddress(val1,val2);
    }
}