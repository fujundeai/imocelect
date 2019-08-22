package com.example.latte_core.delegates;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-13
 * Time: 14:44
 */
public abstract class LatteDelegate extends PermissionCheckerDelegate {
    public <T extends LatteDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }
}
