package com.lqs.design.patterns.iterator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:29
 * @do : 抽象聚合角色类
 */
public interface StudentAggregate {

    // 添加学生功能
    void addStudent(Student student);
    // 删除学生功能
    void removeStudent(Student student);
    // 获取迭代器对象功能
    StudentIterator getStudentIterator();

}
