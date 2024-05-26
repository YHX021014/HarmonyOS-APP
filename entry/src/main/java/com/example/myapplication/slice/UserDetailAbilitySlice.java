package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Forum;
import com.example.myapplication.db.Post;
import com.example.myapplication.db.Tuser;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.TableLayout;
import ohos.agp.components.Text;

import java.util.List;

import static com.example.myapplication.util.DataUtil.*;

public class UserDetailAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_user_detail);
        long uid = intent.getLongParam("uid",-1);
        if(uid == -1) {
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        Text NickName = findComponentById(ResourceTable.Id_user_detail_page_user_nickName_text_id);
        Text Name = findComponentById(ResourceTable.Id_user_detail_page_user_uname_text_id);

        Name.setText(DataUtil.getTuser(uid).getUname());
        NickName.setText(DataUtil.getTuser(uid).getUser_NickName());



        TableLayout postlistTable = (TableLayout) findComponentById(ResourceTable.Id_user_detail_post_list_table);
        List<Post> posts = getPosts();
        getUITaskDispatcher().asyncDispatch(()->{
            for (Post post : posts) {
                if(post.getUser_id()==uid) {
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
