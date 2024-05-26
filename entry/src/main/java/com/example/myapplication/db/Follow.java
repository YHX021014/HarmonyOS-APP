package com.example.myapplication.db;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Column;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "follow")
public class Follow extends OrmObject implements Serializable {
    //主键，评论ID
    @PrimaryKey(autoGenerate = true)
    @Column(name = "follow_id")
    private Long follow_id;


    @Column(name = "A_id")
    private Long A_id;

    @Column(name = "B_id")
    private Long B_id;

    public Follow(Long a_id, Long b_id) {
        A_id = a_id;
        B_id = b_id;
    }

    public Follow() {
    }

    public Long getA_id() {
        return A_id;
    }

    public void setA_id(Long a_id) {
        A_id = a_id;
    }

    public Long getB_id() {
        return B_id;
    }

    public void setB_id(Long b_id) {
        B_id = b_id;
    }

    public Long getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(Long follow_id) {
        this.follow_id = follow_id;
    }
}