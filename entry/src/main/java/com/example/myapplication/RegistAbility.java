package com.example.myapplication;

import com.example.myapplication.slice.RegistAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class RegistAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(RegistAbilitySlice.class.getName());
    }
}
