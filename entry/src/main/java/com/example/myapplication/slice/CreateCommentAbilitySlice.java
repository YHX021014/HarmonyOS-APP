package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Comment;
import com.example.myapplication.db.Forum;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

import static com.example.myapplication.util.ForumUtil.Forum_image_Array;

public class CreateCommentAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_create_comment);

        long post_id = intent.getLongParam("post_id" , -1) ;
        long uid = intent.getLongParam("uid",-1);
        if(post_id == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }
        if(uid == -1) {
            //表示没有找到对应元素
            terminateAbility();
            return;
        }


        TextField creatComment=findComponentById(ResourceTable.Id_create_comment_page_comment_TextField_id);
        Button create = findComponentById(ResourceTable.Id_create_comment_page_create_comment_button_id);

        create.setClickedListener(component -> {
            ToastDialog toastDialog = new ToastDialog(this);

            if (creatComment.getText() == null || "".equals((creatComment.getText()))) {
                toastDialog.setText("评论不能为空").show();
            } else {
                Comment newComment = new Comment();

                newComment.setComment_post_id(post_id);
                newComment.setComment_user_id(uid);
                newComment.setComment_text(creatComment.getText());

                DataUtil.addComment(newComment);
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
