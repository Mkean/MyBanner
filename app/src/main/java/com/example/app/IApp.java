package com.example.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:王庆
 * date：On 2018/7/17
 */
public class IApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
