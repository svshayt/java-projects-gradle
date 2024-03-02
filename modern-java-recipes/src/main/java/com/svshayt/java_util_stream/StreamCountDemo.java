package com.svshayt.java_util_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCountDemo {
    public static void main(String[] args) {
        // Подсчет элементов в потоке
        long count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5).count();
        System.out.println(count);
        System.out.printf("В потоке %d элементов%n", count); // Печатается В потоке 9 элементов

        // Подсчет элементов с помощью метода Collectors.counting
        count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .collect(Collectors.counting());
        System.out.printf("В потоке %d элементов%n", count);

        List<String> strings = Arrays.asList(
                "this", "is", "a", "list", "of", "strings");
        // Подсчет строк в группах по длине
        Map<Boolean, Long> numberLengthMap = strings.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() % 2 == 0, // Предикат
                        Collectors.counting())); // Подчиненный коллектор
        numberLengthMap.forEach((k, v) -> System.out.printf("%5s: %d%n", k, v));
    }
}
