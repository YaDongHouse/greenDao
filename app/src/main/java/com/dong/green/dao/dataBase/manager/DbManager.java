package com.dong.green.dao.dataBase.manager;

import com.dong.green.dao.App;
import com.dong.green.dao.dataBase.db.DaoMaster;
import com.dong.green.dao.dataBase.db.DaoSession;

/**
 * @packInfo:com.dong.green.dao.dataBase.manager
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/11/12
 * Time: 11:12
 */
public class DbManager {

    private static final String DB_NAME = "pad-record.db";
    private static DbManager instance;
    private DaoSession daoSession;


    private DbManager() {
        //MigrationHelper.DEBUG = true; //如果你想查看日志信息，请将DEBUG设置为true
        DongSqliteOpenHelper sqliteOpenHelper = new DongSqliteOpenHelper(App.getAppContext(),DB_NAME,null);
        DaoMaster daoMaster = new DaoMaster(sqliteOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }


    public static DbManager getInstance() {
        if (instance == null){
            synchronized (DbManager.class){
                if (instance == null){
                    instance = new DbManager();
                }
            }
        }
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
