package com.example.latte_core.util.timer;

import java.util.TimerTask;

/**
 * Created by Android Studio.
 * User: wzxai
 * Date: 2019-8-14
 * Time: 19:32
 */
public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener;

    public BaseTimerTask(ITimerListener mITimerListener) {
        this.mITimerListener = mITimerListener;
    }

    @Override
    public void run() {
        if(mITimerListener!=null){
            mITimerListener.onTimer();
        }
    }
}
