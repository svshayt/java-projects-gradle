package com.svshayt.comparator_collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamWithPartitioningByOrGroupingByDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");

        // Разбиение строк по четности длины
        Map<Boolean, List<String>> lengthMap = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0)); // Разбиение на строки четной и нечетной длины
        lengthMap.forEach((key, value) -> System.out.printf("%5s: %s%n", key, value));

        // Группировка строк по длине
        List<String> strings2 = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");
        Map<Integer, List<String>> lengthMap2 = strings2.stream()
                .collect(Collectors.groupingBy(String::length)); // Группировка строк по длине
        lengthMap2.forEach((k, v) -> System.out.printf("%d: %s%n", k, v));
    }
}
