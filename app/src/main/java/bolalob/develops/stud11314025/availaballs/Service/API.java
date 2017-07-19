package bolalob.develops.stud11314025.availaballs.Service;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Okta on 05/07/2017.
 */

public interface API {
    @GET("bins/83m3z")
    Call<List<Lapangan>> getAllLapangan();
}
