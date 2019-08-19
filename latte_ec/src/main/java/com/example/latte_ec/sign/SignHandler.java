package com.example.latte_ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.latte_core.app.AccountManager;
import com.example.latte_ec.database.DatabaseManager;
import com.example.latte_ec.database.UserProfile;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-19
 * Time: 17:09
 * 注册返回的相关数据之后可以根据自己项目情况而定
 */
public class SignHandler {
    public static void onSignIn(String response,ISignListener iSignListener){
        final JSONObject profileJson= JSON.parseObject(response).getJSONObject("data");
        final long userId=profileJson.getLong("userId");
        final String name=profileJson.getString("name");
        final String avatar=profileJson.getString("avatar");
        final String gender=profileJson.getString("gender");
        final String address=profileJson.getString("address");

        final UserProfile profile=new UserProfile(userId,name,avatar,gender,address);
        DatabaseManager.getInstance().getDao().insert(profile);
        //已经注册并成功登陆了
        AccountManager.setSignState(true);
        iSignListener.onSignInSuccess();
    }

    public static void onSignUp(String response,ISignListener iSignListener){
        final JSONObject profileJson= JSON.parseObject(response).getJSONObject("data");
        final long userId=profileJson.getLong("userId");
        final String name=profileJson.getString("name");
        final String avatar=profileJson.getString("avatar");
        final String gender=profileJson.getString("gender");
        final String address=profileJson.getString("address");

        final UserProfile profile=new UserProfile(userId,name,avatar,gender,address);
        DatabaseManager.getInstance().getDao().insert(profile);
        //已经注册并成功登陆了
        AccountManager.setSignState(true);
        iSignListener.onSignUpSuccess();
    }
}
