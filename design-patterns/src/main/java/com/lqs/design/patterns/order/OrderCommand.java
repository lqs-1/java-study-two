package com.lqs.design.patterns.order;

import java.util.Map;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:28
 * @do : 具体的命令类
 */
public class OrderCommand extends AbstractCommand{

    // 聚合接收者对象
    private SeniorChef receive;

    // 聚合订单对象
    private Order order;

    public OrderCommand(SeniorChef receive, Order order){
        this.receive = receive;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单：");
        // 餐品字典
        Map<String, Integer> foodDir = order.getFoodDir();

        for (String foodName : foodDir.keySet()) {
            receive.makeFood(foodName, foodDir.get(foodName)); // 制作餐品
        }
        System.out.println(order.getDiningTable() + "桌的饭准备完毕");

    }

}
