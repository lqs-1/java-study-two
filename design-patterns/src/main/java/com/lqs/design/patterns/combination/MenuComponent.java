package com.lqs.design.patterns.combination;

/**
 * @author : 李奇凇
 * @date : 2022/5/19 下午4:17
 * @do : 菜单组件  属于抽象根节点
 *       这种组合模式，应用于树形结构的系统
 *       比如：目录，菜单等等
 *
 *       节点分为：根节点，树枝节点， 叶子节点
 *       根节点：是没有上层节点的
 *       树枝节点：拥有下层节点,根节点也属于树枝节点
 *       叶子节点：没有下层节点，且不能有下层节点，如果文件夹里面的文件
 */
public abstract class MenuComponent {
    // 菜单组件的名称
    protected String name;
    // 菜单组件的层级
    protected Integer level;

    // 添加子菜单
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException(); // 默认实现，抛出异常，因为叶子节点不能添加子菜单
    }

    // 删除子菜单
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException(); // 默认实现，抛出异常，因为叶子节点没有子菜单
    }

    // 获取指定的子菜单
    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException(); // 默认实现，抛出异常，因为叶子节点没有子菜单
    }

    // 获取菜单或者菜单项的名字
    public String getName(){
        return name;
    }

    // 打印菜单名称（包含子菜单和子菜单项)
    public abstract void print();

}
