package com.example.myapplication.provider;

import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.PageSliderProvider;

import java.util.List;

public class BasicPageSliderProvider extends PageSliderProvider {

    private List<Integer> list;//集合用于存放布局文件
    private AbilitySlice abilitySlice;//需要传递过来一个页面对象

    public BasicPageSliderProvider(List<Integer> list, AbilitySlice abilitySlice) {
        this.list = list;
        this.abilitySlice = abilitySlice;
    }


    @Override
    public int getCount() {
        return list.size();//返回数量
    }

    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        Integer index = list.get(i);
        Component page = LayoutScatter.getInstance(abilitySlice).parse(index,null,false);//得到当前页面的对像
        componentContainer.addComponent(page);//将布局添加到组件容器中
        return page;
    }

    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent((Component) o);//销毁前一个页面
    }

    @Override
    public boolean isPageMatchToObject(Component component, Object o) {
        return true;//返回true
    }

}
