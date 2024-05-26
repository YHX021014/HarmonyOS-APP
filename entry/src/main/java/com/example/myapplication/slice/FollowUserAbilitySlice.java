package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Follow;
import com.example.myapplication.db.Forum;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;
import ohos.agp.window.dialog.ToastDialog;

import java.util.List;

import static com.example.myapplication.util.DataUtil.*;

public class FollowUserAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_follow_user);

        long uid = intent.getLongParam("uid" , -1) ;
        if(uid == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        TableLayout followlistTable = (TableLayout) findComponentById(ResourceTable.Id_follow_user_list_table);
        List<Follow> follows = getFollows();

        getUITaskDispatcher().asyncDispatch(()-> {
            for (Follow follow : follows) {
                if(follow.getA_id()==uid){
                    DependentLayout tempelate = (DependentLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_user_list, null, false);

                    Text UserName = tempelate.findComponentById(ResourceTable.Id_user_list_page_userName_id);
                    Text NickName = tempelate.findComponentById(ResourceTable.Id_user_list_page_nickName_id);

                    UserName.setText(getTuser(follow.getB_id()).getUname());
                    NickName.setText(getTuser(follow.getB_id()).getUser_NickName());
                    followlistTable.addComponent(tempelate);


                    tempelate.setClickedListener(component -> {
                        ToastDialog toastDialog = new ToastDialog(this);
                        toastDialog.setText(uid+"").show();
                        Intent in1 = new Intent();
                        Operation operation1 = new Intent.OperationBuilder()
                                .withDeviceId("")
                                .withBundleName("com.example.myapplication")
                                .withAbilityName("com.example.myapplication.UserDetailAbility")
                                .build();
                        in1.setParam("uid", follow.getB_id());
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
