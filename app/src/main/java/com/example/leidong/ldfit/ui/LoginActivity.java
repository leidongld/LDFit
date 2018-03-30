package com.example.leidong.ldfit.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.leidong.ldfit.R;
import com.example.leidong.ldfit.constants.Constants;
import com.example.leidong.ldfit.security.AuthenticateUtils;
import com.example.leidong.ldfit.storage.MySharedPreferences;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leido on 2018/3/13.
 */

public class LoginActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";

    @BindView(R.id.et_username)
    EditText mUsername;

    @BindView(R.id.et_password1)
    EditText mPassword1;

    @BindView(R.id.et_password2)
    EditText mPassword2;

    @BindView(R.id.bt_login)
    Button mButton;

    @BindView(R.id.ll_username)
    LinearLayout mUsernameLayout;

    @BindView(R.id.ll_password1)
    LinearLayout mPasswordLayout1;

    @BindView(R.id.ll_password2)
    LinearLayout mPasswordLayout2;

    private MySharedPreferences mMySharedPreferences;
    private boolean mRegisteredFlag;

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
        mMySharedPreferences = MySharedPreferences.getMySharedPreferences(LoginActivity.this);
        mRegisteredFlag = mMySharedPreferences.load(Constants.IS_REGISTERED ,false);
        if(mRegisteredFlag){
            mPasswordLayout2.setVisibility(View.GONE);
        }
        else{
            mButton.setText(Constants.REGISTER);
        }
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_login:
                if(mRegisteredFlag){
                    clickLoginBtn();
                }
                else{
                    clickRegisterBtn();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 还未注册，点击按钮进行信息的注册
     */
    private void clickRegisterBtn() {
        String username = mUsername.getText().toString().trim();
        String password1 = mPassword1.getText().toString().trim();
        String password2 = mPassword2.getText().toString().trim();
        if(AuthenticateUtils.isUsernameFormatLegal(username)
                && AuthenticateUtils.isPasswordFormatLegal(password1)
                && password1.equals(password2)){
             mMySharedPreferences.save(Constants.IS_REGISTERED, true);
             mMySharedPreferences.save(Constants.USERNAME, username);
             mMySharedPreferences.save(Constants.PASSWORD, password1);

             Intent intent = new Intent(LoginActivity.this, MainActivity.class);
             startActivity(intent);
             finish();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(Constants.WARNING);
            builder.setMessage(Constants.FORMAT_ERROR);
            builder.setPositiveButton(Constants.OK, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mUsername.setText(null);
                    mPassword1.setText(null);
                    mPassword2.setText(null);
                }
            });
            builder.setNegativeButton(Constants.CANCEL, null);
            builder.create();
            builder.show();
        }
    }

    /**
     * 已经注册信息点击登陆按钮进行登陆
     */
    private void clickLoginBtn() {
        String password = mPassword1.getText().toString().trim();
        String username = mUsername.getText().toString().trim();
        if(password.equals(AuthenticateUtils.getPassword())
                && username.equals(AuthenticateUtils.getUsername()))
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(Constants.WARNING);
            builder.setMessage(Constants.USERNAME_OR_PASSWORD_ERROR);
            builder.setPositiveButton(Constants.OK, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mUsername.setText(null);
                    mPassword1.setText(null);
                }
            });
            builder.setNegativeButton(Constants.CANCEL, null);
            builder.create();
            builder.show();
        }
    }
}
