package com.example.leidong.ldfit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.ldfit.R;
import com.example.leidong.ldfit.constants.Constants;
import com.example.leidong.ldfit.utils.FontUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leidong on 2018/3/13
 */

public class SplashActivity extends Activity {
    private static final String TAG = "SplashActivity";

    @BindView(R.id.tv_app_name)
    TextView mAppName;

    @BindView(R.id.activity_splash)
    LinearLayout mSplashActivityLayout;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        initWidgets();

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(Constants.SPLASH_ACTIVITY_ANIMATION_DURATION);
        mSplashActivityLayout.setAnimation(alphaAnimation);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask, Constants.SPLASH_ACTIVITY_ANIMATION_DURATION);
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        FontUtils.setFontFromAssets(mAppName, "fonts/galgab.ttf");
    }
}
