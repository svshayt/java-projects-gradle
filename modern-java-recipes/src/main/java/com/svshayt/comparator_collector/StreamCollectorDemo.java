package com.svshayt.comparator_collector;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectorDemo {

    public static void main(String[] args) {


    }

    // Использование метода collect для возврата списка
    public List<String> evenLengthStrings(String... strings) {
        return Stream.of(strings)
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList()); // Собрать строки четной длины в список
    }

    // Использование метода collect для возврата немодифицируемой коллекции SortedSet
    public SortedSet<String> oddLengthStringSet(String... strings) {
        Collector<String, ?, SortedSet<String>> intoSet =
                Collector.of(TreeSet<String>::new, // Supplier, возвращающий новый контейнер TreeSet
                        SortedSet::add, // BiConsumer, добавляющий одну строку в TreeSet
                        (left, right) -> { // BinaryOperator, объединяющий два объекта SortedSet в один
                            left.addAll(right);
                            return left;
                        },
                        Collections::unmodifiableSortedSet); // Функция finisher, создающая немодифицируемое множество
        return Stream.of(strings)
                .filter(s -> s.length() % 2 != 0)
                .collect(intoSet);
    }
}
