package com.lqs.design.patterns.strategy;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:11
 * @do : 环境类（促销类，销售员）
 */
public class SaleMan {

    // 聚合策略
    private AbstractStrategy strategy;

    // 构造方法赋值
    public SaleMan(AbstractStrategy strategy){
        this.strategy = strategy;
    }

    // 由销售员展示促销活动信息给用户
    public void saleManShow(){
        strategy.show();
    }



}
