package com.dong.green.dao;

import android.app.Application;
import android.content.Context;

import com.dong.green.dao.dataBase.db.DaoSession;
import com.dong.green.dao.dataBase.manager.DbManager;
import com.github.yuweiguocn.library.greendao.MigrationHelper;

/**
 * @packInfo:com.dong.green.dao.dataBase
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/11/12
 * Time: 11:15
 */
public class App extends Application {
    private static Context appContext;
    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        daoSession = DbManager.getInstance().getDaoSession();
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static void setDbDebug(boolean debug){
        MigrationHelper.DEBUG = debug;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
