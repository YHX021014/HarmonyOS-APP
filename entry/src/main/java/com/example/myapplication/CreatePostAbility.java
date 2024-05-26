package com.example.myapplication;

import com.example.myapplication.slice.CreatePostAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class CreatePostAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(CreatePostAbilitySlice.class.getName());
    }
}
