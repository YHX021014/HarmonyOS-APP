package com.example.myapplication.db;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Column;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "post")
public class Post extends OrmObject implements Serializable {

    //主键，帖子ID
    @PrimaryKey(autoGenerate = true)
    @Column(name = "post_id")
    private Long post_id ;

    //发布用户ID
    @Column(name = "user_id")
    private Long user_id;

    //贴子的标题..
    @Column(name = "post_title")
    private String post_title ;

    //贴子的文本内容
    @Column(name = "text")
    private String post_text ;

    //贴子的点赞数量
    @Column(name = "like_count")
    private String like_count ;

    //贴子的收藏数量
    @Column(name = "collect_count")
    private String collect_count ;

    //帖子的图片的编号
    @Column(name = "image_id")
    private Integer image_id;

    //帖子归属于的吧的编号
    @Column(name = "forum_id")
    private Long forum_id;

    /**
     * 构造函数
     * @param post_title
     * @param text
     * @param ID_user
     * @param ID_forum
     * @param ID_image
     */
    public Post(String post_title, String text, Long ID_user, Long ID_forum, Integer ID_image, String ID_like_count, String ID_collect_count) {
        this.post_title = post_title;
        this.post_text = text;
        this.user_id = ID_user;
        this.forum_id = ID_forum;
        this.image_id = ID_image;
        this.like_count = ID_like_count;
        this.collect_count = ID_collect_count;
    }

    public Post() {
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public String getLike_count() {return like_count;}

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(String collect_count) {
        this.collect_count = collect_count;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public Long getForum_id() {
        return forum_id;
    }

    public void setForum_id(Long forum_id) {
        this.forum_id = forum_id;
    }
}
