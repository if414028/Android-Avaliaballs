package bolalob.develops.stud11314025.availaballs.Service;

import bolalob.develops.stud11314025.availaballs.Model.LapanganDetailResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Voldarex on 8/9/2017.
 */

public interface APIDetailLapangan {
    @GET("surveyer/detail-field")
    Call<LapanganDetailResult> getLapangan(@Query("idFutsalField") int id);
}
