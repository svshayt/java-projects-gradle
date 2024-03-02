package com.svshayt.java_util_stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // Создание потока методом Stream.of
        var names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                        .collect(Collectors.joining(","));
        System.out.println(names);

        // Создание потока методом Arrays.stream
        String[] munsters = { "Herman", "Lily", "Eddie", "Marilyn", "Grandpa" };
        names = Arrays.stream(munsters)
                .collect(Collectors.joining(","));
        System.out.println(names);

        // Создание потока методом Stream.iterate
        List<BigDecimal> nums =
                Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE) )
                        .limit(10)
                        .collect(Collectors.toList());
        System.out.println(nums);

        Stream.iterate(LocalDate.now(), localDate -> localDate.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);

        // Создание потока случайных чисел типа double
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        // Создание потока из коллекции
        List<String> bradyBunch = Arrays.asList("Greg", "Marcia", "Peter", "Jan",
                "Bobby", "Cindy");
        names = bradyBunch.stream()
                        .collect(Collectors.joining(","));
        System.out.println(names);

        // Методы range и rangeClosed
        List<Integer> ints = IntStream.range(10, 15)
                .boxed() // Необходимо, чтобы коллектор мог преобразовать примитивы в List<T>
                .collect(Collectors.toList());
        System.out.println(ints);

        // поток rangeClosed включает конечное значение, а range нет
        List<Integer> intsClosed = IntStream.rangeClosed(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(intsClosed);
    }
}
