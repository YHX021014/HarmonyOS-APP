package com.example.myapplication;

import com.example.myapplication.slice.CreateCommentAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class CreateCommentAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(CreateCommentAbilitySlice.class.getName());
    }
}
