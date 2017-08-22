package bolalob.develops.stud11314025.availaballs.Service;

import bolalob.develops.stud11314025.availaballs.Model.LapanganDetailResult;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Voldarex on 8/15/2017.
 */

public interface APICreateLapangan {
    @FormUrlEncoded
    @POST("surveyer/create-futsal-field")
    Call<LapanganDetailResult> createLapangan(
            @Field("fieldName") String fieldName,
            @Field("detailLocation") String detailLocation,
            @Field("phone") String phone,
            @Field("numberOfField") String numberOfField,
            @Field("openingHours") String openingHours,
            @Field("closingHours") String closingHours,
            @Field("price") String price,
            @Field("account") String account,
            @Field("location") String location,
            @Field("days") String days,
            @Field("longitude") String longitude,
            @Field("latitude") String latitude);
}
