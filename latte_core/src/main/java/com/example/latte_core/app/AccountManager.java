package com.example.latte_core.app;

import com.example.latte_core.util.storage.LattePreference;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-19
 * Time: 13:12
 */
public class AccountManager {
    private enum SignTag{
        SIGN_TAG;
    }

    //保存用户登录状态，登录后调用
    public static void setSignState(boolean state){
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    public static boolean isSignIn(){
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if(isSignIn()){
            checker.onSignIn();
        }else {
            checker.onNotSignIn();
        }
    }

}
