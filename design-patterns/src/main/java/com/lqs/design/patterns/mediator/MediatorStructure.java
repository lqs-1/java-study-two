package com.lqs.design.patterns.mediator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:02
 * @do : 具体的中介者角色类
 */
public class MediatorStructure extends Mediator {
    // 聚合房主和租房者对象
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void constact(String message, Persion persion) {
        if (persion == houseOwner){
            tenant.getMessage(message);
        }else {
            houseOwner.getMessage(message);
        }
    }
}
