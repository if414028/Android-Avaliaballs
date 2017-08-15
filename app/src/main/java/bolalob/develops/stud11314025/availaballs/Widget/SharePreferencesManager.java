package bolalob.develops.stud11314025.availaballs.Widget;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Okta on 01/08/2017.
 */

public class SharePreferencesManager {
    private static final String MyPREFERENCES = "MyPrefs" ;
    private static final String USER = "userKey";
    private static final String PASS = "passKey";

    private static final String PHOTO = "photoKey";

    private static final String NAMA_LAPANGAN = "namaLapanganKey";
    private static final String ALAMAT_LAPANGAN = "alamatLapanganKey";
    private static final String JUMLAH_LAPANGAN = "jumlahLapanganKey";
    private static final String HARGA_LAPANGAN = "hargaLapanganKey";

    private static final String KOTA = "kotaKey";

    private static final String PHONE_ONE = "phoneOneKey";
    private static final String PHONE_TWO = "phoneTwoKey";
    private static final String PHONE_THREE = "phoneThreeKey";

    private static final String HARI_SENIN = "hariSeninKey";
    private static final String HARI_SELASA = "hariSelasaKey";
    private static final String HARI_RABU = "hariRabuKey";
    private static final String HARI_KAMIS = "hariKamisKey";
    private static final String HARI_JUMAT = "hariJumatKey";
    private static final String HARI_SABTU = "hariSabtuKey";
    private static final String HARI_MINGGU = "hariMingguKey";

    private static final String JAM_BUKA = "jamBukaKey";
    private static final String JAM_TUTUP = "jamTutupKey";

    private static final String LONGITUDE = "longitudeKey";
    private static final String LATITUDE = "latitudeKey";


    public static void setLoginPreference (Context context, String user, String pass){
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER, user);
        editor.putString(PASS, pass);
        editor.commit();
    }

    public static String getUser(Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return  sharedpreferences.getString(USER, "");
    }

    public static void logout(Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();

        editor.commit();
    }

    public static String getPass(Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return  sharedpreferences.getString(PASS, "");
    }

    public static void setFirstStepCreateLapangan(Context context, String namaLapangan){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAMA_LAPANGAN, namaLapangan);
        editor.commit();
    }

    public static void setSecondStepCreateLapangan(Context context, String alamatLapangan, String kota,
                                                   String phoneOne, String phoneTwo, String phoneThree,
                                                   String jumlahLapangan, String longitude, String latitude){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ALAMAT_LAPANGAN, alamatLapangan);
        editor.putString(KOTA, kota);
        editor.putString(PHONE_ONE, phoneOne);
        editor.putString(PHONE_TWO, phoneTwo);
        editor.putString(PHONE_THREE, phoneThree);
        editor.putString(JUMLAH_LAPANGAN, jumlahLapangan);
        editor.putString(LONGITUDE, longitude);
        editor.putString(LATITUDE, latitude);
        editor.commit();
    }

    public static void setThirdStepCreateLapangan(Context context, String hariSenin, String hariSelasa,
                                                  String hariRabu, String hariKamis, String hariJumat,
                                                  String hariSabtu, String hariMinggu, String jamBuka,
                                                  String jamTutup, String hargaLapangan){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(HARI_SENIN, hariSenin);
        editor.putString(HARI_SELASA, hariSelasa);
        editor.putString(HARI_RABU, hariRabu);
        editor.putString(HARI_KAMIS, hariKamis);
        editor.putString(HARI_JUMAT, hariJumat);
        editor.putString(HARI_SABTU, hariSabtu);
        editor.putString(HARI_MINGGU, hariMinggu);
        editor.putString(JAM_BUKA, jamBuka);
        editor.putString(JAM_TUTUP, jamTutup);
        editor.putString(HARGA_LAPANGAN, hargaLapangan);
        editor.commit();

    }
}
