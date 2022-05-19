package com.lqs.design.patterns.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/19 下午4:28
 * @do : 菜单类  属于树枝节点
 */
public class Menu extends MenuComponent{

    // 菜单可以有多个子菜单或者多个子菜单项
    private List<MenuComponent> menuComponentList = new ArrayList<>();


    public Menu(String name, Integer level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public void print() {
        // 打印菜单名称
        System.out.println(name);
        // 打印子菜单名称或者子菜单项名称
        for (MenuComponent menuComponent : menuComponentList) {
            menuComponent.print();
        }
    }
}
