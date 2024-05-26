package com.example.myapplication;

import com.example.myapplication.slice.BasicPageAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class BasicPageAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(BasicPageAbilitySlice.class.getName());
    }
}
