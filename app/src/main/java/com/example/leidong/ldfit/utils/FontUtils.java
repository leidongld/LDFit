package com.example.leidong.ldfit.utils;

import android.graphics.Typeface;
import android.widget.TextView;

import com.example.leidong.ldfit.MyApplication;

/**
 * Created by leido on 2018/3/13.
 */

public class FontUtils {
    public static void setFontFromAssets(TextView textView, String fontPath){
        Typeface typeface = Typeface.createFromAsset(MyApplication.getAssetManager(), fontPath);
        textView.setTypeface(typeface);
    }
}
