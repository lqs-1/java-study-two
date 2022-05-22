package com.lqs.design.patterns.memento;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午3:12
 * @do : 备忘录对象管理对象
 */
public class RoleStateCaretaker {

    // 声明RoleStateMemento类型变量
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
