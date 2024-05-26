package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.myapplication.db.Forum;
import com.example.myapplication.db.Post;
import com.example.myapplication.db.Tuser;
import com.example.myapplication.provider.BasicPageSliderProvider;
import com.example.myapplication.util.DataUtil;
import com.example.myapplication.util.ForumUtil;
import com.example.myapplication.util.PostUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.myapplication.util.DataUtil.*;
import static com.example.myapplication.util.DataUtil.getTuser;

public class BasicPageAbilitySlice extends AbilitySlice {
    Button modify_inf,modify_name,log_out;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_basic_page);

        long uid = intent.getLongParam("uid" , -1) ;
        if(uid == -1){
            //表示没有找到对应元素
            terminateAbility();
            return;
        }


        //1、初始化TabList
        TabList tabList = (TabList) findComponentById(ResourceTable.Id_tab_list);
        //添加数据
        String[] title = {"首页","专区","消息","我的"};
        //将数据添加到tab当中
        for (String s : title) {
            TabList.Tab tab = tabList.new Tab(this);
            tab.setText(s);
            tabList.addTab(tab);
        }

        //2、初始化pageSlider
        List<Integer> list = new ArrayList<>();
        list.add(ResourceTable.Layout_ability_home);
        list.add(ResourceTable.Layout_ability_category);
        list.add(ResourceTable.Layout_ability_message);
        list.add(ResourceTable.Layout_ability_Mine);
        PageSlider pageSlider = findComponentById(ResourceTable.Id_page_slider);
        pageSlider.setProvider(new BasicPageSliderProvider(list,this));//设置Provider

        //3、Tablist与PageSlider的联动
        tabList.addTabSelectedListener(new TabList.TabSelectedListener() {
            @Override
            public void onSelected(TabList.Tab tab) {//重要重写这个方法
                //获取点击的菜单索引
                int position = tab.getPosition();
                //设置pageslider的索引与菜单索引一致
                pageSlider.setCurrentPage(position);
                if(position==0)
                {
                    //首页
                    initIndex(pageSlider,uid);
                }
                else if(position ==1)
                {
                    //分类
                    initCatrgory(pageSlider,uid);
                }
                else if(position==2)
                {
                    //消息
                    initMessage(pageSlider,uid);
                }
                else if(position==3)
                {
                    //我的
                    initMine(pageSlider,uid);
                }
            }

            @Override
            public void onUnselected(TabList.Tab tab) {}

            @Override
            public void onReselected(TabList.Tab tab) {}
        });

        //4、4PageSlider联动TabList
        pageSlider.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int i, float v, int i1) { }

            @Override
            public void onPageSlideStateChanged(int i) { }

            @Override
            public void onPageChosen(int i) {//主要重写此方法
                if (tabList.getSelectedTabIndex() != i){
                    tabList.selectTabAt(i);
                }
            }
        });

        //5、默认选中第一个菜单，加载PageSlider的第一个页面
        tabList.selectTabAt(0);
    }

    private void initMine(PageSlider pageSlider, Long uid) {

        Text user = findComponentById(ResourceTable.Id_Mine_name);
        user.setText(DataUtil.getTuser(uid).getUser_NickName());


        //跳转至修改用户信息界面
        modify_name = findComponentById(ResourceTable.Id_modify_name) ;
        modify_name.setClickedListener(component -> {
            Intent intent4 = new Intent();
            Operation operation4 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.ModifyNameAbility")
                    .build();
            intent4.setParam("uid",getTuser(uid).getUid());
            intent4.setOperation(operation4);
            startAbility(intent4);
        });

        //跳转至修改密码界面
        modify_inf = findComponentById(ResourceTable.Id_modify_inf) ;
        modify_inf.setClickedListener(component -> {
            Intent intent3 = new Intent();
            Operation operation3 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.ModifyAbility")
                    .build();
            intent3.setParam("uid",getTuser(uid).getUid());
            intent3.setOperation(operation3);
            startAbility(intent3);
        });

        //跳转至登陆界面
        log_out = findComponentById(ResourceTable.Id_log_out) ;
        log_out.setClickedListener(component -> {
            Intent intent = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.MainAbility")
                    .build();
            intent.setOperation(operation);
            startAbility(intent);
        });


    }

    private void initMessage(PageSlider pageSlider,long uid) {
        Button buttonMyFollow = findComponentById(ResourceTable.Id_message_page_myFollow_button_id);
        Button buttonMyFans = findComponentById(ResourceTable.Id_message_page_myFans_button_id);
        Button buttonSearchUser = findComponentById(ResourceTable.Id_message_page_searchUser_button_id);
        buttonMyFollow.setClickedListener(component -> {
            Intent in1 = new Intent();
            Operation operation1 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.FollowUserAbility")
                    .build();
            in1.setParam("uid",uid);
            in1.setOperation(operation1);
            startAbility(in1);
        });
        buttonMyFans.setClickedListener(component -> {
            Intent in2 = new Intent();
            Operation operation2 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.FansUserAbility")
                    .build();
            in2.setParam("uid",uid);
            in2.setOperation(operation2);
            startAbility(in2);
        });
        buttonSearchUser.setClickedListener(component -> {
            Intent in3 = new Intent();
            Operation operation3 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.SearchUserAbility")
                    .build();
            in3.setOperation(operation3);
            startAbility(in3);
        });


    }

    private void initCatrgory(PageSlider pageSlider,long uid) {
        TableLayout forumlistTable = (TableLayout) findComponentById(ResourceTable.Id_index_forum_list_table);

        Button buttonCreate = findComponentById(ResourceTable.Id_category_page_button_create_forum_id);
        Button buttonSubscribe = findComponentById(ResourceTable.Id_category_page_button_subscribe_forum_id);
        Button buttonSearch = findComponentById(ResourceTable.Id_category_page_button_search_forum_id);



        //跳转至创建贴吧页面
        buttonCreate.setClickedListener(component -> {
            Intent in1 = new Intent();
            Operation operation1 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.CreateForumAbility")
                    .build();
            in1.setOperation(operation1);
            startAbility(in1);
        });

        //跳转至关注贴吧页面
        buttonSearch.setClickedListener(component -> {
            Intent in2 = new Intent();
            Operation operation2 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.SearchAbility")
                    .build();
            in2.setParam("uid",uid);

            in2.setOperation(operation2);
            startAbility(in2);


        });

        //跳转至搜索贴吧页面
        buttonSubscribe.setClickedListener(component -> {
            Intent in3 = new Intent();
            Operation operation3 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.SubscribeForumAbility")
                    .build();
            in3.setParam("uid",uid);
            in3.setOperation(operation3);
            startAbility(in3);
        });


        List <Forum> forums = getForums();
        getUITaskDispatcher().asyncDispatch(()->{
            for(Forum forum:forums) {
                DependentLayout tempelate = (DependentLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_forum_list, null, false);

                //贴吧名称、贴吧简介、贴吧关注量
                Text forum_name = (Text)tempelate.findComponentById(ResourceTable.Id_forum_name);
                Text introduction = (Text)tempelate.findComponentById(ResourceTable.Id_forum_inf);
                Text subscribe_count = (Text)tempelate.findComponentById(ResourceTable.Id_subscribe_count);

                introduction.setText(forum.getForum_introduction());
                forum_name.setText(forum.getForum_name());
                subscribe_count.setText(forum.getForum_subscribe_count());

                //贴吧图片渲染
                Image image = (Image) tempelate.findComponentById(ResourceTable.Id_forum_img);
                image.setPixelMap(ForumUtil.Forum_image_Array.get(forum.getForum_image_index()));

                forumlistTable.addComponent(tempelate);

                tempelate.setClickedListener(component -> {
                    Intent in = new Intent();
                    Operation operation = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.example.myapplication")
                            .withAbilityName("com.example.myapplication.ForumDetailAbility")
                            .build();
                    in.setParam("forum_id",forum.getForum_id());
                    in.setParam("uid",uid);
                    in.setOperation(operation);
                    startAbility(in);
                });

            }
        });
    }

    private void initIndex(PageSlider pageSlider,long uid) {
        TableLayout postlistTable = (TableLayout) findComponentById(ResourceTable.Id_index_passage_list_table);
        List <Post> posts = getPosts();

        TextField searchTextField = (TextField) findComponentById(ResourceTable.Id_home_search_textfield);
        searchTextField.setFocusChangedListener((component, b) -> {
            //当搜索输入框获得焦点 导航到SearchAbilitySlic
            if (b){
                Intent in2 = new Intent();
                Operation operation2 = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.example.myapplication")
                        .withAbilityName("com.example.myapplication.SearchAbility")
                        .build();
                in2.setParam("uid",uid);
                in2.setOperation(operation2);
                startAbility(in2);
            }
        });

        Button button =findComponentById(ResourceTable.Id_home_page_create_post_button);
        button.setClickedListener(component -> {
            Intent in1 = new Intent();
            Operation operation1 = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication")
                    .withAbilityName("com.example.myapplication.CreatePostAbility")
                    .build();
            in1.setParam("uid",uid);
            in1.setOperation(operation1);
            startAbility(in1);
        });


        getUITaskDispatcher().asyncDispatch(()->{
            for (Post post : posts) {
                DependentLayout tempelate = (DependentLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_home_list, null, false);

                Forum f =getForum(post.getForum_id());
                Text forum = (Text)tempelate.findComponentById(ResourceTable.Id_home_page_post_forum_id);
                forum.setText(f.getForum_name());

                Tuser u = getTuser(post.getUser_id());
                Text User = (Text)tempelate.findComponentById(ResourceTable.Id_home_page_Username_id);
                User.setText(u.getUser_NickName());

                //标题、点赞数、收藏数 渲染
                Text title = (Text)tempelate.findComponentById(ResourceTable.Id_home_page_post_title_id);
                Text like_count = (Text)tempelate.findComponentById(ResourceTable.Id_like_count_id);
                Text collect_count = (Text)tempelate.findComponentById(ResourceTable.Id_collect_count_id);
                title.setText(post.getPost_title());
                like_count.setText(post.getLike_count());
                collect_count.setText(post.getCollect_count());

                postlistTable.addComponent(tempelate);

                tempelate.setClickedListener(component -> {
                    Intent in = new Intent();
                    Operation operation = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.example.myapplication")
                            .withAbilityName("com.example.myapplication.DetailAbility")
                            .build();
                    in.setParam("post_id",post.getPost_id());
                    in.setParam("uid",uid);
                    in.setOperation(operation);
                    startAbility(in);

                });
            }
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
