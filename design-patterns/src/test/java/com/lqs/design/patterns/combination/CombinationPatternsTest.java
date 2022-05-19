package com.lqs.design.patterns.combination;

/**
 * @author : 李奇凇
 * @date : 2022/5/19 下午4:39
 * @do : 组合模式的测试,组合模式将叶子节点和树枝节点的所的方法抽取到抽象类中，这样可以面向抽象编程
 *       叶子节点或者是树枝节点不能使用的方法，自己做异常处理
 */
public class CombinationPatternsTest {

    public static void main(String[] args) {
        // 创建二级菜单
        MenuComponent level2Menu1 = new Menu("用户管理", 2);
        // 添加子菜单或者菜单项
        level2Menu1.add(new Menu("个人管理1", 3));
        level2Menu1.add(new MenuItem("用户修改1", 3));


        // 创建二级菜单
        MenuComponent level2Menu2 = new Menu("账户管理", 2);
        // 添加子菜单或者菜单项
        level2Menu2.add(new Menu("个人管理2", 3));
        level2Menu2.add(new MenuItem("用户修改2", 3));


        // 创建二级菜单
        MenuComponent level2Menu3 = new Menu("周围管理", 2);
        // 添加子菜单或者菜单项
        level2Menu3.add(new Menu("个人管理3", 3));
        level2Menu3.add(new MenuItem("用户修改3", 3));


        // 创建根节点
        MenuComponent rootMenu = new Menu("系统管理", 1);
        rootMenu.add(level2Menu1);
        rootMenu.add(level2Menu2);
        rootMenu.add(level2Menu3);

        // 获取第二个子节点的信息
        MenuComponent child = rootMenu.getChild(2);
        child.print();

        System.out.println("-----------------------------------");

        // 获取根节点的信息
        rootMenu.print();
    }

}
