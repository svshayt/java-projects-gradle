package com.svshayt.basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InterfaceStaticMethods {
    public static void main(String[] args) {
        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore",
                "Dalton", "Brosnan", "Craig");

        var sorted = bonds.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);

        // Естественный порядок (лексикографический)
        var sorted1 = bonds.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(sorted1);

        // Обратный лексикографический порядок
        var sorted2 = bonds.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sorted2);

        // Сортировать по имени в нижнем регистре
        var sorted3 = bonds.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());
        System.out.println(sorted3);

        // Сортировать по длине имени
        var sorted4 = bonds.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sorted4);

        // Сортировать по длине, а при равной длине лексикографически
        var sorted5 = bonds.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println(sorted5);
    }
}
