package com.example.maps;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    public void getLocationFromAddress(String strAddress) {


        List<Address> address;

        try {
            address = geocoder.getFromLocationName(strAddress, 1);
            if (address == null) {
                Toast.makeText(getApplicationContext(), "Destino no encontrado",Toast.LENGTH_LONG).show();
            }
            Address location = address.get(0);
            Double lat = location.getLatitude();
            Double lng = location.getLongitude();

            LatLng dd = new LatLng(lat,lng);
            mMap.addMarker(new MarkerOptions().position(dd).title(strAddress));
        } catch (Exception e) {

        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        String val1=getIntent().getExtras().getString("nombre");
        getLocationFromAddress(val1);
    }
}