package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Forum;
import com.example.myapplication.db.Post;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

import static com.example.myapplication.util.ForumUtil.Forum_image_Array;

public class CreatePostAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_create_post);


        long uid = intent.getLongParam("uid",-1);
        if(uid == -1) {
            //表示没有找到对应元素
            terminateAbility();
            return;
        }



        TextField title = findComponentById(ResourceTable.Id_create_post_page_title_textField_id);
        TextField text = findComponentById((ResourceTable.Id_create_post_page_text_textField_id));
        TextField forum = findComponentById((ResourceTable.Id_create_post_page_forum_textField_id));
        Button create = findComponentById(ResourceTable.Id_create_post_page_create_button_id);

        create.setClickedListener(component -> {
            ToastDialog toastDialog = new ToastDialog(this);

            if (title.getText() == null || "".equals((title.getText()))) {
                toastDialog.setText("帖子标题不能为空").show();
            }
            else if (text.getText() == null || "".equals((text.getText()))) {
                toastDialog.setText("帖子内容不能为空").show();
            }
            else if (forum.getText() == null || "".equals((forum.getText()))) {
                toastDialog.setText("帖子所属贴吧分区不能为空").show();
            }

            else {
                Post newpost = new Post();
                newpost.setCollect_count(0+"");
                newpost.setLike_count(0+"");

                newpost.setPost_title(title.getText());
                newpost.setPost_text(text.getText());

                try {
                    newpost.setForum_id(DataUtil.getForum(forum.getText()).getForum_id());
                    System.out.println(newpost.getForum_id()+"");

                    newpost.setUser_id(uid);
                    System.out.println(newpost.getUser_id());

                    DataUtil.addPost(newpost);
                    toastDialog.setText("创建成功").show();
                    System.out.println("创建成功");
                    terminateAbility();
                }catch(RuntimeException e){
                    toastDialog.setText("未找到此分区").show();
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
