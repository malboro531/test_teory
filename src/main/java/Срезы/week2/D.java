package Срезы.week2;

import org.junit.Assert;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D {
    public int age;
    public String name;

    public boolean equals(D d) {
        return this.age == d.age;
    }

    public static void main(String[] args) {
//        D obj1 = new D();
//        obj1.age = 10;
//
//        D obj2 = new D();
//        obj2.age = 10;
//
//// Сравнение с использованием equals
//        System.out.println(obj1.equals(obj2));
//
//// Получение хеш-кодов
//        System.out.println(obj1.hashCode());
//        System.out.println(obj2.hashCode());

//        List<String> list = new ArrayList<String>();
//        list.add("One");
//        list.add("Ten");
//        list.add("Three");
//        list.add("123");
//
//        Stream stream = list.stream();
//        stream.filter(x-> x.toString().length() == 3).forEach(System.out::println);

//        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        List<Integer> list2 = list1.stream()
//                .filter(n -> n % 2 == 0)
//                .map(n -> n * n)
//                .sorted()
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < list2.size() - 1; i++) {
//            System.out.println(list2.get(i));
//        }


//        long baseData = 15000;
//
//        double rate = 0.15;
//        long deposit = 100000;
//
//        double percent = deposit * rate;
//
//        DecimalFormat df = new DecimalFormat("0.00");
//        String formattedPercent = df.format(percent / 100);
//
//        long longPercent = (long) percent;
//
//        System.out.println(formattedPercent);
//        System.out.println(longPercent == baseData);
//        Assert.assertEquals(longPercent == 100, true);

    }
}
