package com.svshayt.stream_lambda_method_ref;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        // Возврат полной коллекции и фильтрация null
        List<String> strings = Arrays.asList(
                "this", null, "is", "a", null, "list", "of", "strings", null);
        List<String> nonNullStrings = strings.stream()
                .filter(Objects::nonNull) // Фильтрация элементов, равных null
                .collect(Collectors.toList());
        System.out.println(nonNullStrings);

        List<String> stringsNotNull =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
        System.out.println(Objects.deepEquals(stringsNotNull, nonNullStrings));


        // Вычисление суммы чисел в списке
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9);
        int total = 0; // Локальная переменная total
        for (int n : nums) { // Традиционный цикл for-each
            total += n;
        }
        total = 0;
//        nums.forEach(n -> total += n); // Модификация локальной переменной в лямбда-выражении: НЕ КОМПИЛИРУЕТСЯ
        total = nums.stream() // Преобразование потока в IntStream и вызов sum
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println(total);


        // Порождение потока случайных чисел
        Random r = new Random();
        r.ints(5) // Пять случайных целых чисел
                .sorted()
                .forEach(System.out::println);
        r.doubles(5, 0, 0.5) // Пять случайных чисел типа double от 0 (включая) до 0.5 (не включая)
                .sorted()
                .forEach(System.out::println);
        List<Long> longs = r.longs(5)
                .boxed() // Обертывание long типом Long, чтобы числа можно было собрать в коллекцию
                .collect(Collectors.toList());
        System.out.println(longs);
        List<Integer> listOfInts = r.ints(5, 10, 20)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);  // Другая форма collect, без вызова boxed
        System.out.println(listOfInts);
    }

    // Фильтрация null в любом списке
    public <T> List<T> getNonNullElements(List<T> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
