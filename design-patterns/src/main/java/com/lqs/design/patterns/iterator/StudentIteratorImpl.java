package com.lqs.design.patterns.iterator;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:26
 * @do : 具体迭代器角色类
 */
public class StudentIteratorImpl implements StudentIterator{


    private List<Student> list;
    private int position = 0; // 用来记录遍历时候的位置

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public <T> T next() {
        // 从集合中获取指定位置的元素
        Student currentStudent = list.get(position);
        position ++ ;
        return (T) currentStudent;
    }
}
