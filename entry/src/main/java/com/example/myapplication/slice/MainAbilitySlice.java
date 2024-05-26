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

import java.util.concurrent.atomic.AtomicBoolean;

public class MainAbilitySlice extends AbilitySlice {
    Button login_regist ,login ;
    TextField username , pwd ;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        login = findComponentById(ResourceTable.Id_login_log);
        username = findComponentById(ResourceTable.Id_login_username);
        pwd = findComponentById(ResourceTable.Id_login_pwd);

        ToastDialog toastDialog = new ToastDialog(this) ;

        Tuser default_user = new Tuser();
        default_user.setPwd("1");
        default_user.setUname("1");
        DataUtil.addTuser(default_user);

        login.setClickedListener(component -> {

            Tuser tuser = new Tuser();
            tuser.setUname(username.getText());
            tuser.setPwd(pwd.getText());
            tuser = DataUtil.login(tuser);

            if(tuser==null){
                toastDialog.setText("登陆失败").show();
            }
            else{
                toastDialog.setText("登录成功").show();

                Intent in1 = new Intent();
                Operation operation1 = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.example.myapplication")
                        .withAbilityName("com.example.myapplication.BasicPageAbility")
                        .build();

                //3、把operation设置到intent中
                in1.setParam("uid",tuser.getUid());

                in1.setOperation(operation1);
                startAbility(in1);


            }
        });


        //1、先得到注册按钮
        login_regist = findComponentById(ResourceTable.Id_login_regis) ;
        //2、添加点击事件
        login_regist.setClickedListener(component -> {
            Intent in = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.RegistAbility")
                    .build();

        //3、把operation设置到intent中
            in.setOperation(operation);
            startAbility(in);
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
