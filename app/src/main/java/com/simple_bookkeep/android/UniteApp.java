package com.simple_bookkeep.android;

import android.app.Application;

import com.simple_bookkeep.android.db.DBManager;

public class UniteApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.initDB(getApplicationContext());
    }
}
