package com.if5b.peta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.if5b.peta.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityMainBinding binding;
    private GoogleMap mMap;
    private List<Lokasi> restaurantList = new ArrayList<>();
    private List<Lokasi> hospitalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        restaurantList.add(new Lokasi("Kapaltaru", new LatLng(-2.954148516506887, 104.74964790028122)));
        restaurantList.add(new Lokasi("Japanese Street Food", new LatLng(-2.953997817242022, 104.75510602780861)));
        restaurantList.add(new Lokasi("Wakcoy Coffee", new LatLng(-2.9511187997574213, 104.75091831695273)));
        restaurantList.add(new Lokasi("Amanda Brownies", new LatLng(-2.9567811193123266, 104.74447900010466)));
        restaurantList.add(new Lokasi("Pecel Lele Mas Yanto", new LatLng(-2.959194474075568, 104.7563581918656)));
        restaurantList.add(new Lokasi("Restaurant Jenny", new LatLng(-2.9705237383965195, 104.7411203383913)));
        restaurantList.add(new Lokasi("Cafe Delapan", new LatLng(-2.953997817242022, 104.75510602780861)));
        restaurantList.add(new Lokasi("Nobu Bistro", new LatLng(-2.973569811529998, 104.73816243394397)));
        restaurantList.add(new Lokasi("Braserie Resto", new LatLng(-2.978115532952121, 104.74580955811555)));
        restaurantList.add(new Lokasi("RameNation", new LatLng(-2.9753965640676645, 104.7676738037715)));
        restaurantList.add(new Lokasi("The Hungry Burger", new LatLng(-2.97329851505968, 104.73862078695166)));
        restaurantList.add(new Lokasi("Pondok Kelapo", new LatLng(-2.9633479613551548, 104.73613631454938)));

        hospitalList.add(new Lokasi("RS Hermina", new LatLng(-2.9556455686637375, 104.74850247174261)));
        hospitalList.add(new Lokasi("RS Bhayangkara", new LatLng(-2.958140396108232, 104.73746765491678)));
        hospitalList.add(new Lokasi("RS Mohammad Hoesin", new LatLng(-2.966102022312736, 104.75022478339717)));
        hospitalList.add(new Lokasi("RS Bunda", new LatLng(-2.967165162834265, 104.73415675386268)));
        hospitalList.add(new Lokasi("RS Myria", new LatLng(-2.9402250838142003, 104.72627593179574)));


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.fabRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();

                for (int i = 0; i < restaurantList.size(); i++) {
                    mMap.addMarker(new MarkerOptions()
                                    .position(restaurantList.get(i)
                                            .getLatLng()).title(restaurantList.get(i).getNama()))
                            .showInfoWindow();
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(restaurantList.get(4).getLatLng(), 17));
            }
        });

        binding.fabHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();

                for (int i = 0; i < hospitalList.size(); i++) {
                    mMap.addMarker(new MarkerOptions()
                                    .position(hospitalList.get(i).getLatLng())
                                    .title(hospitalList.get(i).getNama())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                            .showInfoWindow();
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(hospitalList.get(4).getLatLng(), 17));
            }

        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setMyLocationEnabled(true);
        LatLng latLngUser = new LatLng(-2.962744, 104.740001);
        mMap.addMarker(new MarkerOptions().position(latLngUser).title("Lokasi Saya"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngUser, 19));
    }
}