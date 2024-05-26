package com.example.myapplication;

import com.example.myapplication.slice.ModifyNameAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class ModifyNameAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(ModifyNameAbilitySlice.class.getName());
    }
}
