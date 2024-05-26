package com.example.myapplication.db;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Column;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "subscribe")
public class Subscribe extends OrmObject implements Serializable {
    //主键，评论ID
    @PrimaryKey(autoGenerate = true)
    @Column(name = "subscribe_id")
    private Long subscribe_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "forum_id")
    private Long forum_id;

    public Subscribe(Long user_id, Long forum_id) {
        this.user_id = user_id;
        this.forum_id = forum_id;
    }

    public Subscribe() {
    }

    public Long getSubscribe_id() {
        return subscribe_id;
    }

    public void setSubscribe_id(Long subscribe_id) {
        this.subscribe_id = subscribe_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getForum_id() {
        return forum_id;
    }

    public void setForum_id(Long forum_id) {
        this.forum_id = forum_id;
    }
}