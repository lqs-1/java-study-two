package com.lqs.design.patterns.iterator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:35
 * @do : 迭代器模式测试
 */
public class IteratorPatternsTest {

    public static void main(String[] args) {
        // 创建聚合对象
        StudentAggregateImpl studentAggregate = new StudentAggregateImpl();
        // 添加元素
        studentAggregate.addStudent(new Student("lqs", "1"));
        studentAggregate.addStudent(new Student("wlqs", "2"));
        studentAggregate.addStudent(new Student("wlq", "3"));
        studentAggregate.addStudent(new Student("wls", "4"));
        studentAggregate.addStudent(new Student("wqs", "5"));
        studentAggregate.addStudent(new Student("elqs", "6"));
        studentAggregate.addStudent(new Student("rlqs", "7"));

        // 遍历集合对象

        // 获取迭代器对象
        StudentIterator studentIterator = studentAggregate.getStudentIterator();
        // 遍历
        while(studentIterator.hasNext()){
            // 获取元素
            Student next = studentIterator.next();
            System.out.println(next);
        }

    }

}
