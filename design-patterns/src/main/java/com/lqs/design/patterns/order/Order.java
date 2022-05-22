package com.lqs.design.patterns.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:22
 * @do : 订单类
 */
public class Order {

    // 餐桌号码
    private Integer diningTable;

    // 所下的餐品和份数
    private Map<String, Integer> foodDir = new HashMap<>();

    public Integer getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(Integer diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String foodName, Integer foodNum){
        foodDir.put(foodName, foodNum);
    }
}
