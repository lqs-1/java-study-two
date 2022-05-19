package com.lqs.design.patterns.combination;

/**
 * @author : 李奇凇
 * @date : 2022/5/19 下午4:37
 * @do : 菜单项类    属于叶子节点
 */
public class MenuItem extends MenuComponent{

    public MenuItem(String name, Integer level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        // 打印菜单的名称
        System.out.println(name);
    }
}
