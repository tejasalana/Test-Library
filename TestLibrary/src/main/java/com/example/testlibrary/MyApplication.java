package com.example.testlibrary;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

public class MyApplication extends Application implements LifecycleObserver {

    private static final String TAG = "teja";

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onForeground() {
        Log.d(TAG, "onEnterForeground: Application in foreground");
        Toast.makeText(getApplicationContext(),"App Foregrounded",Toast.LENGTH_SHORT).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onBackground() {
        Log.d(TAG, "onEnterBackground: Application in background");
        Toast.makeText(getApplicationContext(),"App Backgrounded",Toast.LENGTH_SHORT).show();
    }
}
