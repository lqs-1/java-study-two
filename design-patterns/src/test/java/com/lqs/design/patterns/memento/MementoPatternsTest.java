package com.lqs.design.patterns.memento;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午3:19
 * @do : 备忘录模式测试
 */
public class MementoPatternsTest {

    public static void main(String[] args) {
        System.out.println("--------------------大战boss之前----------------------");
        // 创建游戏角色对象
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        // 创建游戏角色管理内部状态进行备份
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        System.out.println("--------------------大战boss之后----------------------");
        // 大战
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("--------------------恢复之后----------------------");
        gameRole.recoverState(roleStateCaretaker.getMemento());
        gameRole.stateDisplay();

    }


}
