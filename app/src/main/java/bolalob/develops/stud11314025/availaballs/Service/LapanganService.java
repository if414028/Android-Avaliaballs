package bolalob.develops.stud11314025.availaballs.Service;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.LapanganResult;
import bolalob.develops.stud11314025.availaballs.Model.ResultObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Okta on 05/07/2017.
 */

public interface LapanganService {
    @GET("surveyer/get-all-futsal-field")
    Call<LapanganResult> getAllLapangan(@Query("page") String page);
}
