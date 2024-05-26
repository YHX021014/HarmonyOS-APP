package com.example.myapplication.db;


import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Column;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "forum")
public class Forum extends OrmObject implements Serializable {

    //主键，贴吧ID
    @PrimaryKey(autoGenerate = true)
    @Column(name = "forum_id")
    private Long forum_id ;

    //贴吧的名字
    @Column(name = "forum_name")
    private String forum_name ;

    //贴吧的简介
    @Column(name = "forum_introduction")
    private String forum_introduction ;

    //贴吧关注量
    @Column(name = "forum_subscribe_count")
    private String forum_subscribe_count ;

    //贴吧的图片标号
    @Column(name = "forum_image_index")
    private int forum_image_index ;

    public Forum(String forum_name, String forum_introduction, String forum_subscribe_count, Integer forum_image_index) {
        this.forum_name = forum_name;
        this.forum_introduction = forum_introduction;
        this.forum_subscribe_count = forum_subscribe_count;
        this.forum_image_index = forum_image_index;
    }

    public Forum() {
        this.forum_subscribe_count=0+"";
    }

    public Long getForum_id() {
        return forum_id;
    }

    public void setForum_id(Long forum_id) {
        this.forum_id = forum_id;
    }

    public String getForum_name() {
        return forum_name;
    }

    public void setForum_name(String forum_name) {
        this.forum_name = forum_name;
    }

    public String getForum_introduction() {
        return forum_introduction;
    }

    public void setForum_introduction(String forum_introduction) {
        this.forum_introduction = forum_introduction;
    }

    public String getForum_subscribe_count() {
        return forum_subscribe_count;
    }

    public void setForum_subscribe_count(String forum_subscribe_count) {
        this.forum_subscribe_count = forum_subscribe_count;
    }

    public Integer getForum_image_index() {
        return forum_image_index;
    }

    public void setForum_image_index(Integer forum_image_index) {
        this.forum_image_index = forum_image_index;
    }
}
