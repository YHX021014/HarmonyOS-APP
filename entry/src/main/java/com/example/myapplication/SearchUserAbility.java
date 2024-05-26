package com.example.myapplication;

import com.example.myapplication.slice.SearchUserAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class SearchUserAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(SearchUserAbilitySlice.class.getName());




    }
}
