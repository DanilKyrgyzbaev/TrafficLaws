package com.pdd.trafficlaws.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Utils {

  public static float convertPixelsToDp(float px, Context context) {
    Resources resources = context.getResources();
    DisplayMetrics metrics = resources.getDisplayMetrics();
    float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    return dp;
  }

  public static float convertDpToPixels(Context context, float dp) {
    return dp * context.getResources().getDisplayMetrics().density;
  }
}
