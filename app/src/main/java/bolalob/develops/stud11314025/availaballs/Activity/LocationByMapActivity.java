package bolalob.develops.stud11314025.availaballs.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import bolalob.develops.stud11314025.availaballs.R;

public class LocationByMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_by_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng pos1 = new LatLng(-6.220452, 106.8264896);
        mMap.addMarker(new MarkerOptions().position(pos1).title("GFK").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoavailaball)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos1));

        LatLng pos2 = new LatLng(-6.2214659, 106.819605);
        mMap.addMarker(new MarkerOptions().position(pos2).title("Kuningan").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoavailaball)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos2));

        LatLng pos3 = new LatLng(-6.1816086, 106.9001859);
        mMap.addMarker(new MarkerOptions().position(pos3).title("Bolalob").icon(BitmapDescriptorFactory.fromResource(R.drawable.logoavailaball)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos3));

    }
}
