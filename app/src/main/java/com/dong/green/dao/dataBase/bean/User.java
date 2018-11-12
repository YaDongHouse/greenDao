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
public class User {

    @Id(autoincrement = true)
    Long id;

    /**
     * 会员名称
     */
    private String member_name;

    /**
     * 会员手机
     */

    private String member_phone;

    /**
     * 会员等级
     */
    private int member_level;

    /**
     *会员折扣
     */
    private String member_discount;

    @Generated(hash = 1274071162)
    public User(Long id, String member_name, String member_phone, int member_level,
            String member_discount) {
        this.id = id;
        this.member_name = member_name;
        this.member_phone = member_phone;
        this.member_level = member_level;
        this.member_discount = member_discount;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMember_name() {
        return this.member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_phone() {
        return this.member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public int getMember_level() {
        return this.member_level;
    }

    public void setMember_level(int member_level) {
        this.member_level = member_level;
    }

    public String getMember_discount() {
        return this.member_discount;
    }

    public void setMember_discount(String member_discount) {
        this.member_discount = member_discount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", member_name='" + member_name + '\'' +
                ", member_phone='" + member_phone + '\'' +
                ", member_level=" + member_level +
                ", member_discount='" + member_discount + '\'' +
                '}';
    }
}
