package com.github.weiranyi.entity;

/**
 * @author: https://github.com/weiranyi
 * @description student类
 * @date: 2021/4/9 1:24 下午
 * @Version 1.0
 */

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //重写equals方法
    @Override
    // 压制hashCode的错
    @SuppressFBWarnings("HE_EQUALS_USE_HASHCODE")
    public boolean equals(Object student) {
        if (student == null) {
            return false;
        }
        // 判断当前类的对象是否就是student类的对象
        if (this == student) {
            // 是同一个对象
            return true;
        }
        // 是否是同一个类
        if (this.getClass() != student.getClass()) {
            return false;
        }
        Student another = (Student) student;
        // 对象的比较变为字符串的对象 .toLowerCase()转小写，可忽略大写
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }

    @Override
    public int compareTo(Student another) {
        if (this.score < another.score) {
            return -1;
        } else if (this.score == another.score) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)", name, score);
    }
}
