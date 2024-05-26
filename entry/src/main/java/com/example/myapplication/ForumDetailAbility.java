package com.example.myapplication;

import com.example.myapplication.slice.ForumDetailAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class ForumDetailAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(ForumDetailAbilitySlice.class.getName());
    }
}
