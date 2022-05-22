package com.lqs.design.patterns.order;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:18
 * @do : 命令模式测试
 *       命令模式：
 *       一个服务员可以发多条命令，一个订单可以有很多菜品，一个厨师可以做很多菜
 */
public class OrderPatternsTest {

    public static void main(String[] args) {
        // 创建地一个订单对象
        Order order = new Order();
        order.setDiningTable(1);
        order.setFood("西红柿", 2);
        order.setFood("可乐",10);


        // 创建地二个订单对象
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("肉丝", 1);
        order2.setFood("可乐",9);


        // 创建接收者对象，厨师对象
        SeniorChef receive = new SeniorChef();
        // 创建命令对象
        AbstractCommand command = new OrderCommand(receive, order);
        AbstractCommand command2 = new OrderCommand(receive, order2);

        // 创建调用者，服务员对象
        Waitor waitor = new Waitor();
        waitor.setCommand(command);
        waitor.setCommand(command2);

        // 让服务员发起命令
        waitor.orderUp();

    }

}
