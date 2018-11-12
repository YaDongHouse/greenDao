package com.dong.green.dao.dataBase.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.dong.green.dao.dataBase.db.DaoSession;
import com.dong.green.dao.dataBase.db.ShopDao;
import com.dong.green.dao.dataBase.db.ShopInfoDao;

/**
 * @packInfo:com.dong.green.dao.dataBase.bean
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/11/12
 * Time: 14:55
 */
@Entity
public class ShopInfo {

    @Id(autoincrement = true)
    private Long id;

    /**
     * 用于和Order做对应
     */
    private Long shopInfoId;

    /**
     * 该商品买了几件
     */
    private int shopNumber;

    private Long sid;
    @ToOne(joinProperty = "sid")
    private Shop shop;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1593490988)
    private transient ShopInfoDao myDao;
    @Generated(hash = 1222879553)
    public ShopInfo(Long id, Long shopInfoId, int shopNumber, Long sid) {
        this.id = id;
        this.shopInfoId = shopInfoId;
        this.shopNumber = shopNumber;
        this.sid = sid;
    }
    @Generated(hash = 1227838148)
    public ShopInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getShopInfoId() {
        return this.shopInfoId;
    }
    public void setShopInfoId(Long shopInfoId) {
        this.shopInfoId = shopInfoId;
    }
    public int getShopNumber() {
        return this.shopNumber;
    }
    public void setShopNumber(int shopNumber) {
        this.shopNumber = shopNumber;
    }
    public Long getSid() {
        return this.sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
    @Generated(hash = 909476750)
    private transient Long shop__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 786029646)
    public Shop getShop() {
        Long __key = this.sid;
        if (shop__resolvedKey == null || !shop__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ShopDao targetDao = daoSession.getShopDao();
            Shop shopNew = targetDao.load(__key);
            synchronized (this) {
                shop = shopNew;
                shop__resolvedKey = __key;
            }
        }
        return shop;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1849061178)
    public void setShop(Shop shop) {
        synchronized (this) {
            this.shop = shop;
            sid = shop == null ? null : shop.getId();
            shop__resolvedKey = sid;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 506319059)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getShopInfoDao() : null;
    }


    @Override
    public String toString() {
        return "ShopInfo{" +
                "id=" + id +
                ", shopInfoId=" + shopInfoId +
                ", shopNumber=" + shopNumber +
                ", sid=" + sid +
                ", shop=" + getShop() +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", shop__resolvedKey=" + shop__resolvedKey +
                '}';
    }
}
