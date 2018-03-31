package com.ntf4a.dream.ntf4a;

import android.app.Application;

/**
 * Application
 * Created by dream on 2018/2/25.
 */

public class ApplicationNTF4A extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Application getApplication(){
        return  application;
    }
}
