package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Tuser;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

import java.util.Objects;

import static com.example.myapplication.util.DataUtil.getTuser;

public class ModifyAbilitySlice extends AbilitySlice {

    private TextField uname;


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_modify);

        long uid = intent.getLongParam("uid" , -1) ;
        if(uid == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }

        TextField oldpwd = findComponentById(ResourceTable.Id_modify_page_old_password_id);
        TextField newpwd = findComponentById(ResourceTable.Id_modify_page_new_password_id);
        TextField repwd = findComponentById(ResourceTable.Id_modify_page_new_re_password_id);
        Button modify = findComponentById(ResourceTable.Id_modify_page_confirm_button_id);
        modify.setClickedListener(component -> {
            ToastDialog toastDialog = new ToastDialog(this);

            if(!Objects.equals(getTuser(uid).getPwd(), oldpwd.getText())) {
                toastDialog.setText("原密码输入错误").show();
            }
            else if(newpwd.getText() == null||"".equals((newpwd.getText()))){
                toastDialog.setText("新密码不能为空").show();
            }
            else if(Objects.equals(oldpwd.getText(), newpwd.getText())) {
                toastDialog.setText("新密码与旧密码相同，请更改").show();
            }
            else if(repwd.getText() == null||"".equals((repwd.getText()))){
                toastDialog.setText("确认密码不能为空").show();
            }
            else if(!repwd.getText().equals(newpwd.getText())){
                toastDialog.setText("两次密码需要一致").show();
            }
            else{
                getTuser(uid).setPwd(newpwd.getText());
                DataUtil.update_Tuser(uid,newpwd.getText());
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
