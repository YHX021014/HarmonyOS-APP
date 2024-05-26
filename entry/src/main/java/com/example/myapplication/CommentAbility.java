package com.example.myapplication;

import com.example.myapplication.slice.CommentAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class CommentAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(CommentAbilitySlice.class.getName());
    }
}
