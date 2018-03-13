package com.example.leidong.ldfit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leidong.ldfit.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        initActions();


    }

    /**
     * 初始化动作
     */
    private void initActions() {

    }

    /**
     * 初始化控件
     */
    private void initWidgets() {

    }
}
