package com.example.leidong.ldfit;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

/**
 * Created by leidong on 2018/3/13
 */

public class MyApplication extends Application {
    private static Context context;
    private static AssetManager assetManager;

    @Override
    public void onCreate(){
        super.onCreate();

        context = getApplicationContext();

        assetManager = getAssets();
    }

    public static Context getContext(){
        return context;
    }

    public static AssetManager getAssetManager(){
        return assetManager;
    }
}
