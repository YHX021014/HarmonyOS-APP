package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Forum;
import com.example.myapplication.db.Subscribe;
import com.example.myapplication.util.DataUtil;
import com.example.myapplication.util.ForumUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;

import java.util.List;

import static com.example.myapplication.util.DataUtil.getForums;
import static com.example.myapplication.util.DataUtil.getSubscribes;

public class SubscribeForumAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_subscribe_forum);

        long uid = intent.getLongParam("uid" , -1) ;
        if(uid == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        TableLayout forumlistTable = (TableLayout) findComponentById(ResourceTable.Id_subscribe_forum_page_list_table);

        List<Subscribe> subscribes = getSubscribes();
        getUITaskDispatcher().asyncDispatch(()->{
            for(Subscribe subscribe : subscribes) {
                if(uid == subscribe.getUser_id()) {
                    DependentLayout tempelate = (DependentLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_forum_list, null, false);
                    //贴吧名称、贴吧简介、贴吧关注量
                    Text forum_name = (Text) tempelate.findComponentById(ResourceTable.Id_forum_name);
                    Text introduction = (Text) tempelate.findComponentById(ResourceTable.Id_forum_inf);
                    Text subscribe_count = (Text) tempelate.findComponentById(ResourceTable.Id_subscribe_count);

                    introduction.setText(DataUtil.getForum(subscribe.getForum_id()).getForum_introduction());
                    forum_name.setText(DataUtil.getForum(subscribe.getForum_id()).getForum_name());
                    subscribe_count.setText(DataUtil.getForum(subscribe.getForum_id()).getForum_subscribe_count());

                    //贴吧图片渲染
                    Image image = (Image) tempelate.findComponentById(ResourceTable.Id_forum_img);
                    image.setPixelMap(ForumUtil.Forum_image_Array.get(DataUtil.getForum(subscribe.getForum_id()).getForum_image_index()));

                    forumlistTable.addComponent(tempelate);

                    tempelate.setClickedListener(component -> {
                        Intent in = new Intent();
                        Operation operation = new Intent.OperationBuilder()
                                .withDeviceId("")
                                .withBundleName("com.example.myapplication")
                                .withAbilityName("com.example.myapplication.ForumDetailAbility")
                                .build();
                        in.setParam("forum_id", subscribe.getForum_id());
                        in.setParam("uid", uid);
                        in.setOperation(operation);
                        startAbility(in);
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
