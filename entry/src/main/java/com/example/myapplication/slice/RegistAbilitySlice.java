package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Tuser;
import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;

public class RegistAbilitySlice extends AbilitySlice {
    //定义输入框与按钮
    private TextField uname ,pwd , repwd;

    @Override
    public void onStart(Intent intent) {

        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_regist);


        uname = findComponentById(ResourceTable.Id_regist_uname);
        pwd = findComponentById(ResourceTable.Id_regist_pwd);
        repwd = findComponentById(ResourceTable.Id_regist_repwd);
        Button regist = findComponentById(ResourceTable.Id_regist_regis);
        regist.setClickedListener(component -> {
            ToastDialog toastDialog = new ToastDialog(this);
            if(uname.getText() == null || "".equals((uname.getText()))){
                toastDialog.setText("用户名不能为空").show();
            }
            else if(pwd.getText() == null||"".equals((pwd.getText()))){
                toastDialog.setText("密码不能为空").show();
            }
            else if(repwd.getText() == null||"".equals((repwd.getText()))){
                toastDialog.setText("确认密码不能为空").show();
            }
            else if(!repwd.getText().equals(pwd.getText())){
                toastDialog.setText("两次密码需要一致").show();
            }
            else {
                Tuser tuser = new Tuser();
                tuser.setPwd(pwd.getText());
                tuser.setUname(uname.getText());
                DataUtil.addTuser(tuser);
                toastDialog.setText("注册成功").show();
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
