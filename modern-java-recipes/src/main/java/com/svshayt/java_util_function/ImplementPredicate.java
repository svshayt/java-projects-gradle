package com.svshayt.java_util_function;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImplementPredicate {
    public static final Predicate<String> LENGTH_FIVE = s -> s.length() == 5;
    public static final Predicate<String> STARTS_WITH_S = s -> s.startsWith("S");

    // Нахождение строк заданной длины
    public String getNamesOfLength(int length, String[] names) {
        return Arrays.stream(names)
                .filter(s -> s.length() == length)
                .collect(Collectors.joining(", "));
    }

    // Нахождение строк с заданным префиксом
    public String getNamesStartingWith(String str, String[] names) {
        return Arrays.stream(names)
                .filter(s -> s.startsWith(str))
                .collect(Collectors.joining(", "));
    }

    public String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }
}
