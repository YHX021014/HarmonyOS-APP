package com.example.myapplication.db;

import ohos.data.orm.OrmDatabase;
import ohos.data.orm.annotation.Column;
import ohos.data.orm.annotation.Database;

@Database(entities = {Tuser.class, Post.class, Forum.class, Comment.class,Follow.class,Subscribe.class} , version = 1)
public abstract class LuntanStore extends OrmDatabase {

}
