package com.example.leidong.ldfit.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.leidong.ldfit.R;
import com.example.leidong.ldfit.fragments.DiscoverFragment;
import com.example.leidong.ldfit.fragments.MyFragment;
import com.example.leidong.ldfit.fragments.NewsFragment;
import com.example.leidong.ldfit.fragments.TrainingFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements OnTabSelectListener {
    private static final String TAG = "MainActivity";

    private FragmentManager mFragmentManager;

    @BindView(R.id.content_container)
    FrameLayout mContentContainer;

    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initWidgets();

        initActions();
    }

    /**
     * 初始化动作
     */
    private void initActions() {
        mBottomBar.setOnTabSelectListener(this);
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mFragmentManager = getFragmentManager();
        TrainingFragment trainingFragment = new TrainingFragment();
        mFragmentManager.beginTransaction().replace(R.id.content_container, trainingFragment).commit();
    }

    @Override
    public void onTabSelected(int tabId) {
        switch(tabId){
            case R.id.tab_training:
                //Toast.makeText(MainActivity.this, "tab_training", Toast.LENGTH_LONG).show();
                TrainingFragment trainingFragment = new TrainingFragment();
                mFragmentManager = getFragmentManager();
                mFragmentManager.beginTransaction().replace(R.id.content_container, trainingFragment).commit();
                break;
            case R.id.tab_discover:
                //Toast.makeText(MainActivity.this, "tab_discover", Toast.LENGTH_LONG).show();
                mFragmentManager = getFragmentManager();
                DiscoverFragment discoverFragment = new DiscoverFragment();
                mFragmentManager.beginTransaction().replace(R.id.content_container, discoverFragment).commit();
                break;
            case R.id.tab_news:
                //Toast.makeText(MainActivity.this, "tab_news", Toast.LENGTH_LONG).show();
                mFragmentManager = getFragmentManager();
                NewsFragment newsFragment = new NewsFragment();
                mFragmentManager.beginTransaction().replace(R.id.content_container, newsFragment).commit();
                break;
            case R.id.tab_my:
                //Toast.makeText(MainActivity.this, "tab_my", Toast.LENGTH_LONG).show();
                mFragmentManager = getFragmentManager();
                MyFragment myFragment = new MyFragment();
                mFragmentManager.beginTransaction().replace(R.id.content_container, myFragment).commit();
                break;
            default:
                break;
        }
    }
}
