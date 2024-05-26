package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.*;
import com.example.myapplication.util.ForumUtil;
import com.example.myapplication.util.PostUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;

import java.util.List;

import static com.example.myapplication.util.DataUtil.*;

public class ForumDetailAbilitySlice extends AbilitySlice {
    Image subs1;
    Text t;
    boolean flag_subscribe = false;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_forum_detail);
        long id = intent.getLongParam("forum_id" , -1) ;
        long uid = intent.getLongParam("uid" , -1) ;

        if(id == -1 ){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }




        subs1 = (Image) findComponentById(ResourceTable.Id_forum_detail_subscribe_btn_id);
        t = (Text) findComponentById(ResourceTable.Id_forum_detail_subscribe_text_id);


        flag_subscribe = find_subscribe(uid,getForum(id).getForum_id());
        if (!flag_subscribe){
            subs1.setImageAndDecodeBounds(ResourceTable.Media_subscribe0);
            t.setText("关注吧");
        } else{
            subs1.setImageAndDecodeBounds(ResourceTable.Media_subscribe1);
            t.setText("已关注");
        }



        subs1.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                if (flag_subscribe){
                    deleteSubscribe(uid,getForum(id).getForum_id());
                    subs1.setImageAndDecodeBounds(ResourceTable.Media_subscribe0);
                    t.setText("关注吧");
                    flag_subscribe = false;
                } else{
                    addSubscribe(new Subscribe(uid,getForum(id).getForum_id()));

                    subs1.setImageAndDecodeBounds(ResourceTable.Media_subscribe1);
                    t.setText("已关注");
                    flag_subscribe = true;
                }
            }
        });


        Button button =findComponentById(ResourceTable.Id_forum_detail_create_btn_id);
        button.setClickedListener(component -> {
            Intent in1 = new Intent();
            Operation operation1 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.CreatePostAbility")
                    .build();
            in1.setParam("uid",uid);
            in1.setOperation(operation1);
            startAbility(in1);
        });



        Forum forum =getForum(id);
        Image image = findComponentById(ResourceTable.Id_forum_detail_image_id);
        image.setPixelMap(ForumUtil.Forum_image_Array.get(forum.getForum_image_index()));

        Text forumName = findComponentById(ResourceTable.Id_forum_detail_forumName_id);
        forumName.setText(forum.getForum_name());

        Text introduction = findComponentById(ResourceTable.Id_forum_detail_introduction_id);
        introduction.setText(forum.getForum_introduction());



        TableLayout postlistTable = (TableLayout) findComponentById(ResourceTable.Id_index_forum_post_list_table);
        List<Post> posts = getPosts();
        getUITaskDispatcher().asyncDispatch(()->{
            for (Post post : posts) {
               if(post.getForum_id()==id) {
                   DependentLayout tempelate = (DependentLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_home_list, null, false);

                   Forum f = getForum(post.getForum_id());
                   Text forum_name = (Text) tempelate.findComponentById(ResourceTable.Id_home_page_post_forum_id);
                   forum_name.setText(f.getForum_name());

                   Tuser u = getTuser(post.getUser_id());
                   Text User = (Text) tempelate.findComponentById(ResourceTable.Id_home_page_Username_id);
                   User.setText(u.getUser_NickName());

                   //标题、点赞数、收藏数 渲染
                   Text title = (Text) tempelate.findComponentById(ResourceTable.Id_home_page_post_title_id);
                   Text like_count = (Text) tempelate.findComponentById(ResourceTable.Id_like_count_id);
                   Text collect_count = (Text) tempelate.findComponentById(ResourceTable.Id_collect_count_id);
                   title.setText(post.getPost_title());
                   like_count.setText(post.getLike_count());
                   collect_count.setText(post.getCollect_count());

                   postlistTable.addComponent(tempelate);

                   tempelate.setClickedListener(component -> {
                       Intent in1 = new Intent();
                       Operation operation1 = new Intent.OperationBuilder()
                               .withDeviceId("")
                               .withBundleName("com.example.myapplication")
                               .withAbilityName("com.example.myapplication.DetailAbility")
                               .build();
                       in1.setParam("post_id", post.getPost_id());
                       in1.setParam("uid",uid);
                       in1.setOperation(operation1);
                       startAbility(in1);
                   });
               }
            }
        });




    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
