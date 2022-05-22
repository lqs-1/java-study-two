package com.lqs.design.patterns.iterator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:24
 * @do : 抽象迭代器角色接口
 */
public interface StudentIterator {

    // 判断是否还有元素
    boolean hasNext();
    // 获取下一个元素
    <T> T next();
}
