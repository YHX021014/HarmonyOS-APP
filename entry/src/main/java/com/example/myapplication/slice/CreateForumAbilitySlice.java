package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Forum;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

import static com.example.myapplication.util.ForumUtil.Forum_image_Array;

public class CreateForumAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_create_forum);


        TextField name = findComponentById(ResourceTable.Id_createForum_page_textfield_forumName_id);
        TextField introduction = findComponentById((ResourceTable.Id_createForum_page_textfield_forumIntroduction_id));



        Button create = findComponentById(ResourceTable.Id_create_forum_page_create_button_id);

        create.setClickedListener(component -> {
            ToastDialog toastDialog = new ToastDialog(this);

            if (name.getText() == null || "".equals((name.getText()))) {
                toastDialog.setText("贴吧名字不能为空").show();
            } else if (introduction.getText() == null || "".equals((introduction.getText()))) {
                toastDialog.setText("简介不能为空").show();
            } else {
                Forum newforum = new Forum();
                newforum.setForum_introduction(introduction.getText());
                newforum.setForum_name(name.getText());
                newforum.setForum_image_index(Forum_image_Array.size());
                Forum_image_Array.add((ResourceTable.Media_forum_basketball_image));
                DataUtil.addForum(newforum);
                toastDialog.setText("创建成功").show();
                terminateAbility();
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
