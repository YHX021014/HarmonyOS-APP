package com.example.myapplication;

import com.example.myapplication.slice.FansUserAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class FansUserAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(FansUserAbilitySlice.class.getName());
    }
}
