package com.svshayt.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferences {
    public static void main(String[] args) {
        // Использование ссылки на метод для доступа к println
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(x -> System.out.println(x)); // С помощью лямбда-выражения
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(System.out::println); // С помощью ссылки на метод

        // Присваивание ссылки на метод переменной типа функционального интерфейса
        Consumer<Integer> printer = System.out::println;
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(printer);

        // Ссылка на статический метод
        Stream.generate(Math::random) // Статический метод
                .limit(10)
                .forEach(System.out::println); // Метод экземпляра

        // Вызов метода экземпляра с несколькими аргументами через имя класса
        List<String> strings =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        System.out.println(sorted);

        List<String> sortedRef = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortedRef);

        // Вызов метода length объекта типа String с помощью ссылки на метод
        Stream.of("this", "is", "a", "list", "of", "strings")
                .map(String::length)
                .forEach(System.out::println);

        // Лямбда-выражения, эквивалентные ссылкам на методы
        Stream.of("this", "is", "a", "list", "of", "strings")
                .map(s -> s.length())
                .forEach(x -> System.out.println(x));
    }
}
