package com.example.myapplication;

import com.example.myapplication.slice.SubscribeForumAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class SubscribeForumAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(SubscribeForumAbilitySlice.class.getName());
    }
}
