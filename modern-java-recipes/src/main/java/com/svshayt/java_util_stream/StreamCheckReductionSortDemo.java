package com.svshayt.java_util_stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamCheckReductionSortDemo {
    public static void main(String[] args) {
        // Суммирование BigDecimal с помощью reduce
        BigDecimal total = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val)); // Использование метода add класса BigDecimal в качестве BinaryOperator
        System.out.println("Сумма равна " + total);

        // Суммирование BigDecimal с помощью reduce
        BigDecimal total2 = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Использование метода add класса BigDecimal в качестве BinaryOperator
        System.out.println("Сумма равна " + total2);

        // Сортировка строк по длине
        List<String> strings = Arrays.asList(
                "this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList()); // Получается [“a”, “is”, “of”, “this”, “list”, “strings”]
        System.out.println(sorted);

        // это часть теста Junit
        // Проверка правильности сортировки потока строк
        strings.stream()
                .reduce((prev, curr) -> {
//                    assertTrue(prev.length() <= curr.length());
                    System.out.println(prev.length() <= curr.length()); // Проверить, что пара отсортирована правильно
                    return curr; // curr становится следующим значением prev
                });

        // это часть теста Junit
        // Проверка правильности сортировки потока строк
        sorted.stream()
                .reduce((prev, curr) -> {
//                    assertTrue(prev.length() <= curr.length());
                    System.out.println(prev.length() <= curr.length()); // Проверить, что пара отсортирована правильно
                    return curr; // curr становится следующим значением prev
                });
    }
}
