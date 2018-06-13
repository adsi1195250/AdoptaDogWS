package com.example.worldskills.adoptadogws.Maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.worldskills.adoptadogws.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(4.676778, -74.048290);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Carrera 13 entre 93A y 93B"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng chapinero = new LatLng(4.676778, -74.048290);
        mMap.addMarker(new MarkerOptions().position(chapinero).title("Avenida Calle 63, Chapinero Central"));

        LatLng simonBolivar = new LatLng(4.657815,-74.093407);
        mMap.addMarker(new MarkerOptions().position(simonBolivar).title("Parque Simón Bolívar Bogotá"));

        LatLng corferias = new LatLng(4.630271, -74.090962);
        mMap.addMarker(new MarkerOptions().position(corferias).title("Carrera. 37 #24-67-Corferias"));

        LatLng museoOro = new LatLng(4.601992, -74.072113);
        mMap.addMarker(new MarkerOptions().position(museoOro).title("Carrera. 6 #15-88- Museo del Oro"));

        LatLng casaNariño = new LatLng(4.595544, -74.077561);
        mMap.addMarker(new MarkerOptions().position(casaNariño).title("Carrera. 37 #24-67-Corferias"));

        LatLng  salitrePlaza = new LatLng(4.652067, -74.110232);
        mMap.addMarker(new MarkerOptions().position(salitrePlaza).title("Centro Comercial Salitre Plaza"));
    }
}
