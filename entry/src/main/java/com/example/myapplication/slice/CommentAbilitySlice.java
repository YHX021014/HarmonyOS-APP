package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Comment;
import com.example.myapplication.db.Post;
import com.example.myapplication.db.Tuser;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;

import java.util.List;

import static com.example.myapplication.util.DataUtil.*;

public class CommentAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_comment);

        long post_id = intent.getLongParam("post_id" , -1) ;
        long uid = intent.getLongParam("uid",-1);
        if(uid == -1) {
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        if(post_id == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        Button Button_create_comment =findComponentById(ResourceTable.Id_comment_page_create_comment_button);
        Button_create_comment.setClickedListener(component -> {
            Intent in = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.CreateCommentAbility")
                    .build();
            in.setParam("post_id",post_id);
            in.setParam("uid",uid);
            in.setOperation(operation);
            startAbility(in);
        });


        TableLayout commentlistTable = (TableLayout) findComponentById(ResourceTable.Id_post_comment_list_table);
        List<Comment> comments = getComments();
        getUITaskDispatcher().asyncDispatch(()-> {
            for (Comment comment : comments) {
                if (comment.getComment_post_id()==post_id) {
                    int i = 0;
                    DependentLayout tempelate = (DependentLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_comment_list, null, false);
                    Tuser u = getTuser(comment.getComment_user_id());
                    Text User = (Text) tempelate.findComponentById(ResourceTable.Id_comment_list_userName_id);
                    User.setText(u.getUser_NickName());

                    Text text = (Text) tempelate.findComponentById(ResourceTable.Id_comment_list_comment_id);
                    text.setText(comment.getComment_text());

                    Text like_count = (Text) tempelate.findComponentById(ResourceTable.Id_comment_list_like_id);
                    like_count.setText(comment.getComment_like_count()+"");
                    commentlistTable.addComponent(tempelate);

                    Image likes = (Image) tempelate.findComponentById(ResourceTable.Id_comment_likes_button_id);


                    likes.setClickedListener(new Component.ClickedListener() {
                        boolean flag_like = false;
                        @Override
                        public void onClick(Component component) {
                            if (flag_like) {
                                likes.setImageAndDecodeBounds(ResourceTable.Media_praise1);
                                like_count.setText(comment.getComment_like_count()+"");
                                flag_like = false;
                            } else {
                                likes.setImageAndDecodeBounds(ResourceTable.Media_praise2);
                                like_count.setText((comment.getComment_like_count()+1)+"");
                                flag_like = true;
                            }
                        }
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
