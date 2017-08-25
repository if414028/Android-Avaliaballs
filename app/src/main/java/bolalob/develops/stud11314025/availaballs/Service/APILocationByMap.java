package bolalob.develops.stud11314025.availaballs.Service;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Voldarex on 8/24/2017.
 */

public interface APILocationByMap {

    @GET("surveyer/maps")
    Call<List<Lapangan>> getLocationByMap();
}
