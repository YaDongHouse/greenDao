package com.dong.green.dao.dataBase.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @packInfo:com.dong.green.dao.bean
 * @author: yadong.qiu
 * Created by 邱亚东
 * Date: 2018/11/9
 * Time: 10:08
 */
@Entity
public class Shop {
    @Id(autoincrement = true)
    private Long id;

    /**
     * 商品名称
     */
    private String shop_name;

    /**
     * 商品条码
     */
    private String shop_code;

    /**
     * 商品价格
     */
    private String shop_price;

    /**
     * 商品数量
     */
    private int shop_number;

    /**
     * 此处自定义shopIdForOrder，用于和Orders中对应
     */
    private Long shopIdForOrder;

    @Generated(hash = 2028975951)
    public Shop(Long id, String shop_name, String shop_code, String shop_price,
            int shop_number, Long shopIdForOrder) {
        this.id = id;
        this.shop_name = shop_name;
        this.shop_code = shop_code;
        this.shop_price = shop_price;
        this.shop_number = shop_number;
        this.shopIdForOrder = shopIdForOrder;
    }

    @Generated(hash = 633476670)
    public Shop() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShop_name() {
        return this.shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_code() {
        return this.shop_code;
    }

    public void setShop_code(String shop_code) {
        this.shop_code = shop_code;
    }

    public String getShop_price() {
        return this.shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public int getShop_number() {
        return this.shop_number;
    }

    public void setShop_number(int shop_number) {
        this.shop_number = shop_number;
    }

    public Long getShopIdForOrder() {
        return this.shopIdForOrder;
    }

    public void setShopIdForOrder(Long shopIdForOrder) {
        this.shopIdForOrder = shopIdForOrder;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_code='" + shop_code + '\'' +
                ", shop_price='" + shop_price + '\'' +
                ", shop_number=" + shop_number +
                ", shopIdForOrder=" + shopIdForOrder +
                '}';
    }
}
