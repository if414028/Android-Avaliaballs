package bolalob.develops.stud11314025.availaballs.Widget;

import android.content.Context;
import android.content.SharedPreferences;

import bolalob.develops.stud11314025.availaballs.Model.Lapangan;


/**
 * Created by Okta on 01/08/2017.
 */

public class SharePreferencesManager {
    private static final String MyPREFERENCES = "MyPrefs";
    private static final String USER = "userKey";
    private static final String PASS = "passKey";

    private static final String NAMA_LAPANGAN = "namaLapanganKey";
    private static final String ALAMAT_LAPANGAN = "alamatLapanganKey";
    private static final String JUMLAH_LAPANGAN = "jumlahLapanganKey";
    private static final String HARGA_LAPANGAN = "hargaLapanganKey";
    private static final String KOTA = "kotaKey";
    private static final String PHONE = "phoneKey";
    private static final String HARI_BUKA = "hariBukaKey";
    private static final String JAM_BUKA = "jamBukaKey";
    private static final String JAM_TUTUP = "jamTutupKey";
    private static final String LONGITUDE = "longitudeKey";
    private static final String LATITUDE = "latitudeKey";

    public static void setLoginPreference(Context context, String user, String pass) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER, user);
        editor.putString(PASS, pass);
        editor.commit();
    }

    public static String getUser(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER, "");
    }

    public static void logout(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();

        editor.commit();
    }

    public static String getPass(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(PASS, "");
    }

    public static void setFirstStepCreateLapangan(Context context, String namaLapangan) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAMA_LAPANGAN, namaLapangan);
        editor.commit();
    }

    public static void setSecondStepCreateLapagan(Context context, Lapangan lapangan) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ALAMAT_LAPANGAN, lapangan.getDetailLocation());
        editor.putString(KOTA, lapangan.getLocation());
        editor.putString(PHONE, lapangan.getPhone());
        editor.putString(JUMLAH_LAPANGAN, lapangan.getNumberOfField());
        editor.putString(LONGITUDE, lapangan.getLongitude());
        editor.putString(LATITUDE, lapangan.getLatitude());
        editor.commit();
    }

    public static void setThirdStepCreateLapangan(Context context, Lapangan lapangan) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(HARI_BUKA, lapangan.getDays());
        editor.putString(JAM_BUKA, lapangan.getOpeningHours());
        editor.putString(JAM_TUTUP, lapangan.getClosingHours());
        editor.putString(HARGA_LAPANGAN, lapangan.getPrice());
        editor.commit();
    }

    public static Lapangan getAllData(Context context) {
        Lapangan lapangan = new Lapangan();

        SharedPreferences sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        lapangan.setFieldName(sharedPreferences.getString(NAMA_LAPANGAN, ""));
        lapangan.setDetailLocation(sharedPreferences.getString(ALAMAT_LAPANGAN, ""));
        lapangan.setPhone(sharedPreferences.getString(PHONE, ""));
        lapangan.setNumberOfField(sharedPreferences.getString(JUMLAH_LAPANGAN, ""));
        lapangan.setOpeningHours(sharedPreferences.getString(JAM_BUKA, "" + ":00"));
        lapangan.setClosingHours(sharedPreferences.getString(JAM_TUTUP, "" + ":00"));
        lapangan.setPrice(sharedPreferences.getString(HARGA_LAPANGAN, ""));
        lapangan.setLocation(sharedPreferences.getString(KOTA, ""));
        lapangan.setDays(sharedPreferences.getString(HARI_BUKA, ""));
        lapangan.setLongitude(sharedPreferences.getString(LONGITUDE, ""));
        lapangan.setLatitude(sharedPreferences.getString(LATITUDE, ""));

        return lapangan;
    }


}
