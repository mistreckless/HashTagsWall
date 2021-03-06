package com.upreckless.support.hashtagswall.util;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

class ResolutionUtil {

    public static int dpToPx(Context c, float dipValue) {
        DisplayMetrics metrics = c.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
