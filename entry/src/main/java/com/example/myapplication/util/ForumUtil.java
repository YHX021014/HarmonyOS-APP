package com.example.myapplication.util;

import com.example.myapplication.ResourceTable;

import java.util.ArrayList;

public class ForumUtil {

//    public static final int[] Forum_image_Array = {
//            ResourceTable.Media_forum_car_image,
//            ResourceTable.Media_forum_football_image,
//            ResourceTable.Media_forum_basketball_image,
//            ResourceTable.Media_forum_love_image,
//            ResourceTable.Media_forum_xingqiongtiedao_image
//    };
    public static final ArrayList<Integer> Forum_image_Array = new ArrayList<>();

    public static void init(){
        Forum_image_Array.add(ResourceTable.Media_forum_car_image);
        Forum_image_Array.add(ResourceTable.Media_forum_football_image);
        Forum_image_Array.add(ResourceTable.Media_forum_basketball_image);
        Forum_image_Array.add(ResourceTable.Media_forum_love_image);
        Forum_image_Array.add(ResourceTable.Media_forum_xingqiongtiedao_image);
    }




}
