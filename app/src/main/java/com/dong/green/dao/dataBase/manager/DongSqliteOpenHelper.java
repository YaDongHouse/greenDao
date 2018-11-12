package com.dong.green.dao.dataBase.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.dong.green.dao.dataBase.bean.Order;
import com.dong.green.dao.dataBase.bean.Shop;
import com.dong.green.dao.dataBase.bean.User;
import com.dong.green.dao.dataBase.db.DaoMaster;
import com.dong.green.dao.dataBase.db.OrderDao;
import com.dong.green.dao.dataBase.db.ShopDao;
import com.dong.green.dao.dataBase.db.UserDao;
import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

/**
 * @packInfo:com.dong.green.dao.dataBase.manager
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/11/12
 * Time: 11:06
 */
public class DongSqliteOpenHelper extends DaoMaster.OpenHelper {

    public DongSqliteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public DongSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        },OrderDao.class,UserDao.class,ShopDao.class);
    }
}
