package com.lqs.design.patterns.flyweight;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:33
 * @do : 享元模式测试,享元模式就是将一部分公开一部分不公开，共享的意思，比如俄罗斯方块有各种形状，但是，颜色不同，所以，我们将图形的颜色公开设置
 *       将工厂类设置为单例模式，那么，每次获取的都是同一个工厂对象，所以工厂对象里面的享元池不会重新赋值，只会赋值一次，这样就解决了重复创建相同对象，
 *       我们要创建一个红色或者白色的图像的时候，就是从享元池中获取的对象然后再对他的公开的设置进行设置，保证永远都是用一个对象
 */
public class FlyweightPatternsTest {

    public static void main(String[] args) {
        // 获取I图形对象
        AbstractBox iBox = BoxFactory.getInstance().getShape("I");
        AbstractBox iBox2 = BoxFactory.getInstance().getShape("I");
        iBox2.display("黑色");
        iBox.display("红色");

        System.out.println(iBox);
        System.out.println(iBox2);

        System.out.println(iBox == iBox2);


    }

}
