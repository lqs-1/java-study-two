package com.lqs.design.patterns.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:33
 * @do : 服务员类（属于请求者角色）
 */
public class Waitor {
    // 持有多个命令对象
    private List<AbstractCommand> commandList = new ArrayList<>();

    public void setCommand(AbstractCommand command){
        // 将cmd对象存储到集合中
        commandList.add(command);
    }

    // 发起命令的功能
    public void orderUp(){
        System.out.println("美女服务员：大哥，新订单来了。。。。");
        // 遍历集合
        for (AbstractCommand abstractCommand : commandList) {
            if (abstractCommand != null){
                abstractCommand.execute();
            }
        }
    }

}
