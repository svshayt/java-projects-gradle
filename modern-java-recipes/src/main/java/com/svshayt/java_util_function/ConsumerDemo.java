package com.svshayt.java_util_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        // Реализация с анонимным внутренним классом
        strings.forEach(
                new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                }
        );

        // Лямбда-выражение
        strings.forEach(s -> System.out.println(s));

        // Ссылка на метод
        strings.forEach(System.out::println);
    }
}
