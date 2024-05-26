package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

public class SearchAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_search);

        long uid = intent.getLongParam("uid" , -1) ;
        if(uid == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        Button searchBtn = (Button) findComponentById(ResourceTable.Id_search_btn);
        TextField searchText = findComponentById(ResourceTable.Id_search_textfield);

        ToastDialog toastDialog = new ToastDialog(this);

        searchBtn.setClickedListener(component -> {

            if (searchText.getText() == null || "".equals((searchText.getText()))) {
                toastDialog.setText("吧名 不能为空").show();
            }
            else{
                try {
                    long forum_id = DataUtil.getForum(searchText.getText()).getForum_id();

                    toastDialog.setText("跳转成功").show();
                    Intent in1 = new Intent();
                    Operation operation1 = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.example.myapplication")
                            .withAbilityName("com.example.myapplication.ForumDetailAbility")
                            .build();
                    in1.setParam("forum_id", forum_id);
                    in1.setParam("uid",uid);
                    in1.setOperation(operation1);
                    startAbility(in1);
                }
                catch(RuntimeException e){
                    toastDialog.setText("未找到该专区").show();
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
