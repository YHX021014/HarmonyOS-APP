package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

public class SearchUserAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_search_user);




        TextField search = findComponentById(ResourceTable.Id_search_user_page_userNsme_textField_id);
        Button button =findComponentById(ResourceTable.Id_search_user_page_search_button_id);

        ToastDialog toastDialog = new ToastDialog(this);



        button.setClickedListener(component -> {

            if (search.getText() == null || "".equals((search.getText()))) {
                toastDialog.setText("用户名不能为空").show();
            }
            else{
                try {
                    long uid = DataUtil.getTuser(search.getText()).getUid();
                    toastDialog.setText("跳转成功").show();
                    Intent in1 = new Intent();
                    Operation operation1 = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.example.myapplication")
                            .withAbilityName("com.example.myapplication.UserDetailAbility")
                            .build();
                    in1.setParam("uid", uid);
                    in1.setOperation(operation1);
                    startAbility(in1);
                }
                catch(RuntimeException e){
                    toastDialog.setText("未找到该用户").show();
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
