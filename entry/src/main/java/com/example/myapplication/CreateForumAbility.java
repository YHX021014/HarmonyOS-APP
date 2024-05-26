package com.example.myapplication;

import com.example.myapplication.slice.CreateForumAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class CreateForumAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(CreateForumAbilitySlice.class.getName());
    }
}
