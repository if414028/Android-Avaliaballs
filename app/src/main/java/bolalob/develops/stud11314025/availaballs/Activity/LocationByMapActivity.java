package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.APILocationByMap;
import bolalob.develops.stud11314025.availaballs.Service.Service;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationByMapActivity extends AppCompatActivity implements GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker position1, position2, position3;
    private LatLng latLng;
    private ArrayList MarkerList;
    private List<Lapangan> locationByMapList = new ArrayList<>();
    @BindView(R.id.progressBarMap)
    ProgressBar progressBarMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_by_map);
        ButterKnife.bind(this);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        //progressBarMap.setVisibility(View.VISIBLE);

        addActionBar();

        getLocationByMap();
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//        getLocationByMap();
//        mMap = googleMap;
//
//        mMap.setOnMarkerClickListener(this);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.2297264, 106.689428), 10.0f));
//
//        LatLng pos1 = new LatLng(-6.220452, 106.8264896);
//        LatLng pos2 = new LatLng(-6.2214659, 106.819605);
//        LatLng pos3 = new LatLng(-6.1816086, 106.9001859);
//
//        position1 = googleMap.addMarker(new MarkerOptions()
//                .position(pos1)-6.189812156957528
//                .title("GFK")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));
//
//        position2 = googleMap.addMarker(new MarkerOptions()
//                .position(pos2)
//                .title("Kuningan")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));
//
//        position3 = googleMap.addMarker(new MarkerOptions()
//                .position(pos3)
//                .title("Bolalob")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));
//
//    }

    public void addActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(true);
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
            intent.putExtra("PHONENUM_KEY", "0812345678");
            intent.putExtra("JUMLAHLAP_KEY", "2");
            intent.putExtra("OPENHOUR_KEY", "08:00");
            intent.putExtra("CLOSEHOUR_KEY", "22:00");
            intent.putExtra("PRICE_KEY", "Rp. 125.000");
        } else if (marker.equals(position3)) {
            Intent intent = new Intent(LocationByMapActivity.this, DetailLapanganActivity.class);
            intent.putExtra("NAMALAP_KEY", "GFK");
            intent.putExtra("LOKASI_KEY", "Kuningan");
            intent.putExtra("PHONENUM_KEY", "0812345678");
            intent.putExtra("JUMLAHLAP_KEY", "2");
            intent.putExtra("OPENHOUR_KEY", "08:00");
            intent.putExtra("CLOSEHOUR_KEY", "22:00");
            intent.putExtra("PRICE_KEY", "Rp. 125.000");
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getLocationByMap() {
        APILocationByMap client = Service.createService(APILocationByMap.class);
        Call<List<Lapangan>> call = client.getLocationByMap();
        call.enqueue(new Callback<List<Lapangan>>() {
            @Override
            public void onResponse(Call<List<Lapangan>> call, final Response<List<Lapangan>> response) {
                System.out.println("test");
                if (response.isSuccessful()) {
                    System.out.println("test1");
                    locationByMapList.addAll(response.body());
//                    progressBarMap.setVisibility(View.GONE);
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            for (int i = 0; i < 2; i++) {
                                System.out.println(response.body().get(i).getLatitude());
                                googleMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(
                                                Double.parseDouble(response.body().get(i).getLatitude()),
                                                Double.parseDouble(response.body().get(i).getLongitude())))
                                        .title(response.body().get(i).getFieldName())
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));
                            }
                        }
                    });
//                    int countMarker = locationByMapList.size();
//
//                    if (countMarker > 0){
//                        for (int i = 0; i < countMarker; i++){
//                            final LocationByMap tmpLocationByMap = locationByMapList.get(i);
//
//                            String longString = tmpLocationByMap.getLongitude();
//                            String latString = tmpLocationByMap.getLatitude();
//
//                            double lng = Double.parseDouble(longString);
//                            double lat = Double.parseDouble(latString);
//
//                            System.out.println(lng + "dan" +lat);
//                        }
//                    }
                } else {
                    Log.e("onResponse failure", "Code: " + response.code() + " , Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Lapangan>> call, Throwable t) {
                System.out.println("error cuy" + t.getLocalizedMessage());

            }
        });
    }
}
