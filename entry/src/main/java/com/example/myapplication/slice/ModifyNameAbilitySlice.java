package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

import java.util.Objects;

import static com.example.myapplication.util.DataUtil.getTuser;

public class ModifyNameAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_modify_name);


        long uid = intent.getLongParam("uid" , -1) ;
        if(uid == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }


        TextField UserName = findComponentById(ResourceTable.Id_modify_name_page_newUserName_textfield_id);
        TextField NickName = findComponentById(ResourceTable.Id_modify_name_page_newNickName_textfield_id);

        Button button = findComponentById(ResourceTable.Id_modify_name_page_confirm_button_id);
        ToastDialog toastDialog = new ToastDialog(this);


        button.setClickedListener(component -> {

            if (UserName.getText() == null || "".equals((UserName.getText()))) {
                toastDialog.setText("用户名不能为空").show();
            }
            else if (NickName.getText() == null || "".equals((NickName.getText()))) {
                toastDialog.setText("昵称不能为空").show();
            }
            else if (Objects.equals(UserName.getText(), DataUtil.getTuser(uid).getUname())
                    && Objects.equals(NickName.getText(), DataUtil.getTuser(uid).getUser_NickName())) {
                toastDialog.setText("新用户名与新昵称至少要有一个与旧用户名与昵称不同").show();
            }
            else {
                DataUtil.getTuser(uid).setUname(UserName.getText());
                DataUtil.getTuser(uid).setUser_NickName(NickName.getText());

                DataUtil.update_Tuser(uid, UserName.getText(), NickName.getText());


                toastDialog.setText("修改成功").show();
                Intent in2 = new Intent();
                Operation operation2 = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.example.myapplication")
                        .withAbilityName("com.example.myapplication.BasicPageAbility")
                        .build();
                in2.setParam("uid",uid);
                in2.setOperation(operation2);
                startAbility(in2);


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
