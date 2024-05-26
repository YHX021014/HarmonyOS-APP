package com.example.myapplication.db;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Column;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "comment")
public class Comment extends OrmObject implements Serializable {
    //主键，评论ID
    @PrimaryKey(autoGenerate = true)
    @Column(name = "comment_id")
    private Long comment_id;

    //评论内容
    @Column(name = "comment_text")
    private String comment_text;

    //发布评论的用户id
    @Column(name = "comment_user_id")
    private Long comment_user_id;

    //评论所属帖子的ID
    @Column(name = "comment_post_id")
    private Long comment_post_id;

    //评论点赞量
    @Column(name = "comment_like_count")
    private Integer comment_like_count;

    public Comment(Long comment_user_id, String comment_text, Long comment_post_id, Integer comment_like_count) {
        this.comment_user_id = comment_user_id;
        this.comment_text = comment_text;
        this.comment_post_id = comment_post_id;
        this.comment_like_count = comment_like_count;
    }

    public Comment() {
        comment_like_count = 0;
    }

    public Comment(Long comment_user_id, Long comment_post_id) {
        this.comment_user_id = comment_user_id;
        this.comment_post_id = comment_post_id;
        comment_like_count = 0;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Long getComment_post_id() {
        return comment_post_id;
    }

    public void setComment_post_id(Long comment_post_id) {
        this.comment_post_id = comment_post_id;
    }

    public Integer getComment_like_count() {
        return comment_like_count;
    }

    public void setComment_like_count(Integer comment_like_count) {
        this.comment_like_count = comment_like_count;
    }

    public Long getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(Long comment_user_id) {
        this.comment_user_id = comment_user_id;
    }
}
