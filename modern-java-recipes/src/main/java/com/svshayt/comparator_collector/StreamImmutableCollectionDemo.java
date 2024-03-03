package com.svshayt.comparator_collector;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamImmutableCollectionDemo {

    public static void main(String[] args) {

    }

    // Создание немодифицируемого списка или множества до Java 8
    @SafeVarargs
    public final <T> List<T> createImmutableListJava7(T... elements) {
        return Collections.unmodifiableList(Arrays.asList(elements));
    }

    @SafeVarargs
    public final <T> Set<T> createImmutableSetJava7(T... elements) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(elements)));
    }

    // Создание немодифицируемых списков и множеств в Java 8
    @SafeVarargs
    public final <T> List<T> createImmutableList(T... elements) {
        return Arrays.stream(elements)
                .collect(collectingAndThen(toList(),
                        Collections::unmodifiableList)); // «Завершитель» обертывает сгенерированную коллекцию
    }

    @SafeVarargs
    public final <T> Set<T> createImmutableSet(T... elements) {
        return Arrays.stream(elements)
                .collect(collectingAndThen(toSet(),
                        Collections::unmodifiableSet)); // «Завершитель» обертывает сгенерированную коллекцию
    }

    // Создание немодифицируемого отображения
    Map<String, Integer> map = Collections.unmodifiableMap(
            new HashMap<String, Integer>() {{
                put("have", 1);
                put("the", 2);
                put("high", 3);
                put("ground", 4);
            }});
}
