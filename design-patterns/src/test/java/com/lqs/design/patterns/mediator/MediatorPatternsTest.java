package com.lqs.design.patterns.mediator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:05
 * @do : 中介者模式测试，同事类要知道中介是谁，中介者也要知道同时类有哪些
 */
public class MediatorPatternsTest {

    public static void main(String[] args) {
        // 创建中介者对象
        MediatorStructure mediatorStructure = new MediatorStructure();

        // 创建租房者对象
        Tenant tenant = new Tenant("lqs", mediatorStructure);

        // 创建房主对象
        HouseOwner houseOwner = new HouseOwner("lqising", mediatorStructure);

        // 中介者要知道具体的房主和租房者
        mediatorStructure.setTenant(tenant);
        mediatorStructure.setHouseOwner(houseOwner);

        tenant.constact("我要买房");

        houseOwner.constact("好的");
    }

}
