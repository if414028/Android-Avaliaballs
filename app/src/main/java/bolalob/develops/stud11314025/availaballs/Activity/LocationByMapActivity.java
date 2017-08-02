package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import bolalob.develops.stud11314025.availaballs.R;

public class LocationByMapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker position1, position2, position3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_by_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        addActionBar();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.2297264, 106.689428), 10.0f));

        LatLng pos1 = new LatLng(-6.220452, 106.8264896);
        LatLng pos2 = new LatLng(-6.2214659, 106.819605);
        LatLng pos3 = new LatLng(-6.1816086, 106.9001859);

        position1 = googleMap.addMarker(new MarkerOptions()
                .position(pos1)
                .title("GFK")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));

        position2 = googleMap.addMarker(new MarkerOptions()
                .position(pos2)
                .title("Kuningan")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));

        position3 = googleMap.addMarker(new MarkerOptions()
                .position(pos3)
                .title("Bolalob")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));

    }


    public void addActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text_centered);
        mTitleTextView.setText("By Map");

        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (marker.equals(position1)) {
            Intent intent = new Intent(LocationByMapActivity.this, DetailLapanganActivity.class);
            intent.putExtra("NAMALAP_KEY", "GFK");
            intent.putExtra("LOKASI_KEY", "Kuningan");
//            intent.putExtra("PHOTO_KEY", Photo);
            intent.putExtra("PHONENUM_KEY", "0812345678");
            intent.putExtra("JUMLAHLAP_KEY", "2");
            intent.putExtra("OPENHOUR_KEY", "08:00");
            intent.putExtra("CLOSEHOUR_KEY", "22:00");
            intent.putExtra("PRICE_KEY", "Rp. 125.000");

            startActivity(intent);
        } else if (marker.equals(position2)) {
            Intent intent = new Intent(LocationByMapActivity.this, DetailLapanganActivity.class);
            intent.putExtra("NAMALAP_KEY", "GFK");
            intent.putExtra("LOKASI_KEY", "Kuningan");
//            intent.putExtra("PHOTO_KEY", Photo);
            intent.putExtra("PHONENUM_KEY", "0812345678");
            intent.putExtra("JUMLAHLAP_KEY", "2");
            intent.putExtra("OPENHOUR_KEY", "08:00");
            intent.putExtra("CLOSEHOUR_KEY", "22:00");
            intent.putExtra("PRICE_KEY", "Rp. 125.000");
        } else if (marker.equals(position3)) {
            Intent intent = new Intent(LocationByMapActivity.this, DetailLapanganActivity.class);
            intent.putExtra("NAMALAP_KEY", "GFK");
            intent.putExtra("LOKASI_KEY", "Kuningan");
//            intent.putExtra("PHOTO_KEY", Photo);
            intent.putExtra("PHONENUM_KEY", "0812345678");
            intent.putExtra("JUMLAHLAP_KEY", "2");
            intent.putExtra("OPENHOUR_KEY", "08:00");
            intent.putExtra("CLOSEHOUR_KEY", "22:00");
            intent.putExtra("PRICE_KEY", "Rp. 125.000");
        }

        return false;
    }
}
