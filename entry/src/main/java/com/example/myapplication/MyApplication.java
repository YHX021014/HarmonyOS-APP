package com.example.myapplication;

import com.example.myapplication.util.DataUtil;
import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {
    @Override
    public void onInitialize() {

        super.onInitialize();
        DataUtil.initialDataBase(this);
    }
}
