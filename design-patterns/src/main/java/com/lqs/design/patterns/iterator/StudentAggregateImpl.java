package com.lqs.design.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:32
 * @do : 具体的聚合角色类
 */
public class StudentAggregateImpl implements StudentAggregate{

    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        // 获取迭代器对象功能
        return new StudentIteratorImpl(list);
    }
}
