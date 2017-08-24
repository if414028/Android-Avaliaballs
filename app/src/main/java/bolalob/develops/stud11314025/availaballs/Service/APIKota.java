package bolalob.develops.stud11314025.availaballs.Service;

import bolalob.develops.stud11314025.availaballs.Model.KotaResult;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Voldarex on 8/23/2017.
 */

public interface APIKota {

    @GET("surveyer/location")
    Call<KotaResult> getListKota();

}
