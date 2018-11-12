package com.dong.green.dao.dataBase.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.dong.green.dao.dataBase.db.DaoSession;
import com.dong.green.dao.dataBase.db.ShopDao;
import com.dong.green.dao.dataBase.db.UserDao;
import com.dong.green.dao.dataBase.db.OrderDao;

/**
 * @packInfo:com.dong.green.dao.bean
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/11/9
 * Time: 10:07
 */
@Entity
public class Order {

    @Id(autoincrement = true)
    private Long id;


    /**
     * 网络返回的订单号
     */
    private String net_order_code;

    /**
     * 支付方法
     */
    private int pay_method;


    /**
     * 支付码
     */
    private String pay_code;


    private Long uid;
    @ToOne(joinProperty = "uid")
    private User user;


    @ToMany(referencedJoinProperty = "shopIdForOrder")
    private List<Shop> shopsList;


    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;


    /** Used for active entity operations. */
    @Generated(hash = 949219203)
    private transient OrderDao myDao;


    @Generated(hash = 696478586)
    public Order(Long id, String net_order_code, int pay_method, String pay_code,
            Long uid) {
        this.id = id;
        this.net_order_code = net_order_code;
        this.pay_method = pay_method;
        this.pay_code = pay_code;
        this.uid = uid;
    }


    @Generated(hash = 1105174599)
    public Order() {
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNet_order_code() {
        return this.net_order_code;
    }


    public void setNet_order_code(String net_order_code) {
        this.net_order_code = net_order_code;
    }


    public int getPay_method() {
        return this.pay_method;
    }


    public void setPay_method(int pay_method) {
        this.pay_method = pay_method;
    }


    public String getPay_code() {
        return this.pay_code;
    }


    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }


    public Long getUid() {
        return this.uid;
    }


    public void setUid(Long uid) {
        this.uid = uid;
    }


    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;


    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1390050865)
    public User getUser() {
        Long __key = this.uid;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 515172768)
    public void setUser(User user) {
        synchronized (this) {
            this.user = user;
            uid = user == null ? null : user.getId();
            user__resolvedKey = uid;
        }
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 77224614)
    public List<Shop> getShopsList() {
        if (shopsList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ShopDao targetDao = daoSession.getShopDao();
            List<Shop> shopsListNew = targetDao._queryOrder_ShopsList(id);
            synchronized (this) {
                if (shopsList == null) {
                    shopsList = shopsListNew;
                }
            }
        }
        return shopsList;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 332412601)
    public synchronized void resetShopsList() {
        shopsList = null;
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
    @Generated(hash = 965731666)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderDao() : null;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", net_order_code='" + net_order_code + '\'' +
                ", pay_method=" + pay_method +
                ", pay_code='" + pay_code + '\'' +
                ", uid=" + uid +
                ", user=" + getUser() +
                ", shopsList=" + getShopsList() +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", user__resolvedKey=" + user__resolvedKey +
                '}';
    }
}
