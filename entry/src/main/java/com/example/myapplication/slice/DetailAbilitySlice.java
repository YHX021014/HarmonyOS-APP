package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Follow;
import com.example.myapplication.db.Post;
import com.example.myapplication.db.Tuser;
import com.example.myapplication.util.PostUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;


import static com.example.myapplication.util.DataUtil.*;

public class DetailAbilitySlice extends AbilitySlice{

    Text t;
    Image subs,likes,collects;

    boolean flag_subscribe = false;

    boolean flag_like = false;
    boolean flag_collect = false;

    @Override
    protected void onStart(Intent intent){
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_detail);

        long post_id = intent.getLongParam("post_id" , -1) ;
        long uid = intent.getLongParam("uid",-1);
        if(post_id == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }
        if(uid == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        Post post = getPost(post_id);

        t = (Text) findComponentById(ResourceTable.Id_detail_page_subscribe_text_id);
        subs = (Image) findComponentById(ResourceTable.Id_detail_page_subscribe_btn_id);
        likes = (Image) findComponentById(ResourceTable.Id_detail_page_like_button_id);
        collects = (Image) findComponentById(ResourceTable.Id_detail_page_collect_button_id) ;

        flag_subscribe = find_follow(uid,getPost(post_id).getUser_id());
        if (!flag_subscribe){
            subs.setImageAndDecodeBounds(ResourceTable.Media_subscribe0);
            t.setText("关注ta");
        } else{
            subs.setImageAndDecodeBounds(ResourceTable.Media_subscribe1);
            t.setText("已关注");
        }

        likes.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                if (flag_like) {
                    likes.setImageAndDecodeBounds(ResourceTable.Media_praise1);
                    flag_like = false;
                } else {
                    likes.setImageAndDecodeBounds(ResourceTable.Media_praise2);
                    flag_like = true;
                }
            }
        });

        collects.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                if(flag_collect){
                    collects.setImageAndDecodeBounds(ResourceTable.Media_collect1);
                    flag_collect = false;
                }else{
                    collects.setImageAndDecodeBounds(ResourceTable.Media_collect2);
                    flag_collect = true;
                }
            }
        });


        subs.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                if (flag_subscribe){
                    deleteFollow(uid,getPost(post_id).getUser_id());
                    subs.setImageAndDecodeBounds(ResourceTable.Media_subscribe0);
                    t.setText("关注ta");

                    flag_subscribe = false;
                } else{
                    addFollow(new Follow( uid , getPost(post_id).getUser_id()) );
                    subs.setImageAndDecodeBounds(ResourceTable.Media_subscribe1);
                    t.setText("已关注");
                    flag_subscribe = true;
                }
            }
        });

        Image image = findComponentById(ResourceTable.Id_detail_page_image_id);
        image.setPixelMap(PostUtil.PostImagesArray[post.getImage_id()]);


        Tuser u = getTuser(post.getUser_id());
        Text User = findComponentById(ResourceTable.Id_detail_page_UserName_id);
        User.setText(u.getUser_NickName());

        Text title = findComponentById(ResourceTable.Id_detail_page_title_id);
        title.setText(post.getPost_title());

        Text text = findComponentById(ResourceTable.Id_detail_page_text_id);
        text.setText(post.getPost_text());


        Button B_comment = findComponentById(ResourceTable.Id_detail_page_comment_button_id);
        B_comment.setClickedListener(component -> {
            Intent in = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.CommentAbility")
                    .build();
            in.setParam("post_id", post.getPost_id());
            in.setParam("uid",uid);
            in.setOperation(operation);
            startAbility(in);
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }
}
