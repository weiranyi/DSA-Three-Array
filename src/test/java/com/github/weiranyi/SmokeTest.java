package com.github.weiranyi;

import com.github.weiranyi.entity.Array;
import com.github.weiranyi.entity.Student;
import org.junit.jupiter.api.Test;

public class SmokeTest {
    @Test
    public void test() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(5);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);


        Array<Student> arr2 = new Array<>();
        arr2.addLast(new Student("亦蔚然1", 100));
        arr2.addLast(new Student("亦蔚然2", 66));
        arr2.addLast(new Student("亦蔚然3", 88));
        System.out.println(arr2);
    }
}
