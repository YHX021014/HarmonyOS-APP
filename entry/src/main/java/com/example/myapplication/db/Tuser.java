package com.example.myapplication.db;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Column;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;
import ohos.javax.xml.namespace.QName;

import java.io.Serializable;

//表示当前类为实体映射类 & 添加可传输标识
@Entity(tableName = "tuser")
public class Tuser extends OrmObject implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @Column(name = "uid")
    private Long uid ;
    @Column(name = "uname")
    private String uname ;
    @Column(name = "pwd")
    private String pwd ;
    @Column(name = "User_NickName")
    private String User_NickName;



    public Tuser() {
    }

    public Tuser(String uname,String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public Tuser(String uname, String pwd, String user_NickName) {
        this.uname = uname;
        this.pwd = pwd;
        User_NickName = user_NickName;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser_NickName() {
        return User_NickName;
    }

    public void setUser_NickName(String user_NickName) {
        User_NickName = user_NickName;
    }
}
