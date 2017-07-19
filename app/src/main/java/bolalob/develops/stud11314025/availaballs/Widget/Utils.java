package bolalob.develops.stud11314025.availaballs.Widget;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by ahmad.syafii on 7/19/2017.
 */

public class Utils {

    public static boolean checkSupportCamera(Context ctx) {
        if (ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

}
