package bolalob.develops.stud11314025.availaballs.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import bolalob.develops.stud11314025.availaballs.Activity.DetailLapanganActivity;

/**
 * Created by Voldarex on 7/26/2017.
 */

public class BroadcastReceiver extends android.content.BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        String namalap = intent.getStringExtra("NAMALAP_KEY");
        String lokasilap = intent.getStringExtra("LOKASI_KEY");
        String photolap = intent.getStringExtra("PHOTO_KEY");
        String phonenumlap = intent.getStringExtra("PHONENUM_KEY");
        String jumlahlap = intent.getStringExtra("JUMLAHLAP_KEY");
        String openhourlap = intent.getStringExtra("OPENHOUR_KEY");
        String closehourlap = intent.getStringExtra("CLOSEHOUR_KEY");
        String pricelap = intent.getStringExtra("PRICE_KEY");


        Intent main = new Intent(context, DetailLapanganActivity.class);
        main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        main.putExtra("NAMALAP_LAP", namalap);
        main.putExtra("LOKASI_LAP",lokasilap);
        main.putExtra("PHOTO_LAP",photolap);
        main.putExtra("PHONENUM_LAP",phonenumlap);
        main.putExtra("JUMLAHLAP_LAP",jumlahlap);
        main.putExtra("OPENHOUR_LAP",openhourlap);
        main.putExtra("CLOSEHOUR_LAP",closehourlap);
        main.putExtra("PRICE_LAP",pricelap);
        context.startActivity(main);
    }
}
