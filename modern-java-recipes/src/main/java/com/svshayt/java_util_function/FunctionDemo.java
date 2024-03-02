package com.svshayt.java_util_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoё", "Jayne", "Simon", "River", "Shepherd Book");

        // Отображение строки на ее длину
        List<Integer> nameLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .collect(Collectors.toList());
        System.out.println(nameLengths);

        var nameLengths1 = names.stream()
                .map(s -> s.length()) // String::length
                .collect(Collectors.toList());
        System.out.println(nameLengths1);

        var nameLengths2 = names.stream()
                .mapToInt(String::length)
                .toArray();
        System.out.println(Arrays.toString(nameLengths2));
    }
}
