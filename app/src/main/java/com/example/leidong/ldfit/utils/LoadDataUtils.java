package com.example.leidong.ldfit.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.leidong.ldfit.MyApplication;
import com.example.leidong.ldfit.models.MyRecommend;
import com.example.leidong.ldfit.models.MyTraining;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

/**
 * Created by leido on 2018/3/30.
 */

public class LoadDataUtils {
    private static String getJsonFile(String fileName, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String readLine = "";
        try {
            while((readLine = bufferedReader.readLine()) != null){
                stringBuilder.append(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().trim();
    }

    public static MyTraining.MyTrainingBean[] loadMyTrainingJson() {
        String jsonStr = getJsonFile("MyTrainingBeans.json", MyApplication.getContext());
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new StringReader(jsonStr));
        jsonReader.setLenient(true);

        MyTraining myTraining = gson.fromJson(jsonReader, MyTraining.class);
        List<MyTraining.MyTrainingBean> myTrainingBeansList = myTraining.getMyTraining();

        MyTraining.MyTrainingBean[] myTrainingBeans = new MyTraining.MyTrainingBean[myTrainingBeansList.size()];

        int i = 0;
        for (MyTraining.MyTrainingBean bean : myTrainingBeansList) {
            myTrainingBeans[i++] = bean;
        }
        return myTrainingBeans;
    }

    public static MyRecommend.MyRecommendBean[] loadMyRecommendJson() {
        String jsonStr = getJsonFile("MyRecommendBeans.json", MyApplication.getContext());
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new StringReader(jsonStr));
        jsonReader.setLenient(true);

        MyRecommend myRecommend = gson.fromJson(jsonReader, MyRecommend.class);
        List<MyRecommend.MyRecommendBean> myRecommendBeansList = myRecommend.getMyRecommend();

        MyRecommend.MyRecommendBean[] myRecommendBeans = new MyRecommend.MyRecommendBean[myRecommendBeansList.size()];

        int i = 0;
        for (MyRecommend.MyRecommendBean bean : myRecommendBeansList) {
            myRecommendBeans[i++] = bean;
        }
        return myRecommendBeans;
    }
}
