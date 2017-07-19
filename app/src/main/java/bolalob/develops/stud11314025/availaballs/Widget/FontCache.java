package bolalob.develops.stud11314025.availaballs.Widget;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by Okta on 14/06/2017.
 */
public class FontCache {

    public static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(Context context, String fontName) {
        Typeface typeface = fontCache.get(fontName);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            fontCache.put(fontName, typeface);
        }
        return typeface;
    }
}
