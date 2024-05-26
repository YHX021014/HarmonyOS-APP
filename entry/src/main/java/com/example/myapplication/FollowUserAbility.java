package com.example.myapplication;

import com.example.myapplication.slice.FollowUserAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class FollowUserAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(FollowUserAbilitySlice.class.getName());
    }
}
