package com.example.leidong.ldfit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.leidong.ldfit.R;

import butterknife.ButterKnife;

/**
 * Created by leido on 2018/3/13.
 */

public class LoginActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

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
