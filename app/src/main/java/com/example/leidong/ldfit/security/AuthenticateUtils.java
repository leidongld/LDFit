package com.example.leidong.ldfit.security;

import com.example.leidong.ldfit.MyApplication;
import com.example.leidong.ldfit.constants.Constants;
import com.example.leidong.ldfit.storage.MySharedPreferences;

/**
 * Created by leido on 2018/3/18.
 */

public class AuthenticateUtils {
    /**
     * 获取登录密码
     * @return
     */
    public static String getPassword() {
        MySharedPreferences mySp = MySharedPreferences.getMySharedPreferences(MyApplication.getContext());
        return mySp.load(Constants.PASSWORD, "");
    }

    /**
     * 获取登陆应户名
     * @return
     */
    public static String getUsername(){
        MySharedPreferences mySp = MySharedPreferences.getMySharedPreferences(MyApplication.getContext());
        return mySp.load(Constants.USERNAME, "");
    }

    /**
     * 判断注册的用户名是否合法
     * @param username
     * @return
     */
    public static boolean isUsernameFormatLegal(String username) {
        return username.length() > 0;
    }

    /**
     * 判断注册的密码是否合法
     * @param password
     * @return
     */
    public static boolean isPasswordFormatLegal(String password) {
        return password.matches("^.*[a-zA-Z]+.*$")
                && password.matches("^.*[0-9]+.*$")
                && password.length() >= Constants.MIN_PASSWORD_LENGTH;
    }
}
