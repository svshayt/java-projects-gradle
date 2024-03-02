package com.svshayt.java_util_stream;

import com.svshayt.models.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReductionOperationsDemo {
    public static void main(String[] args) {
        // Операции редукции для потока IntStream
        String[] strings = "this is an array of strings".split(" ");

        long count = Arrays.stream(strings)
                .map(String::length) // count – метод Stream, поэтому необходимо преобразовать в IntStream
                .count();
        System.out.println("Всего существует " + count + " строк");

        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length) // sum и average определены только для потоков значений примитивного типа
                .sum();
        System.out.println("Суммарная длина равна " + totalLength);

        OptionalDouble ave = Arrays.stream(strings)
                .mapToInt(String::length) // sum и average определены только для потоков значений примитивного типа
                .average();
        System.out.println("Средняя длина равна " + ave);

        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length) // sum и average определены только для потоков значений примитивного типа
                .max(); // max и min без компаратора определены только для потоков значений примитивного типа
        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length) // sum и average определены только для потоков значений примитивного типа
                .min(); // max и min без компаратора определены только для потоков значений примитивного типа
        System.out.println("Максимальная и минимальная длины равны " + max + " и " + min);

        // Суммирование чисел с помощью reduce
        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + y).orElse(0); // Значение sum равно 55
        System.out.println(sum);

        // Суммирование чисел с помощью reduce
        int sum2 = IntStream.rangeClosed(1, 10)
                .reduce(Integer::sum).orElse(0); // Значение sum равно 55
        System.out.println(sum2);

        // Печать значений x и y
        int sum3 = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%d, y=%d%n", x, y);
                    return x + y;
                }).orElse(0);

        // Удвоение значений в процессе суммирования (НЕПРАВИЛЬНО)
        int doubleSum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + 2 * y).orElse(0);
        System.out.println(doubleSum);

        // Удвоение значений в процессе суммирования (ПРАВИЛЬНО)
        int doubleSum2 = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> x + 2 * y);
        System.out.println(doubleSum2);
        int doubleSum3 = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> {
                    System.out.printf("x=%d, y=%d%n", x, y);
                    return x + 2 * y;
                });
        System.out.println(doubleSum3);

        // Выполнение редукции с помощью бинарного оператора
        int sum10 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);
        System.out.println(sum10);

        // Нахождение максимума с помощью редукции
        Integer max10 = Stream.of(3, 1, 4, 1, 5, 9)
                .reduce(Integer.MIN_VALUE, Integer::max); // Нейтральным элементом max является минимальное целое число
        System.out.println("Максимальное значение равно " + max10);

        String s = Stream.of("this", "is", "a", "list")
                .reduce("", String::concat);
        System.out.println(s); // Печатается thisisalist

        // Собирание строк с помощью StringBuilder
        String s2 = Stream.of("this", "is", "a", "list")
                .collect(() -> new StringBuilder(), // Поставщик результата
                        (stringBuilder, str) -> stringBuilder.append(str), // Добавить к результату одно значение
                        (sb1, sb2) -> sb1.append(sb2) // Объединить два результата
                )
                .toString();
        System.out.println(s2);

        // Собирание строк с помощью ссылок на методы
        String s3 = Stream.of("this", "is", "a", "list")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
        System.out.println(s3);

        // Соединение строк с помощью класса Collectors
        String s4 = Stream.of("this", "is", "a", "list")
                .collect(Collectors.joining());
        System.out.println(s4);

        // Помещение объектов Book в структуру Map с помощью аккумулятора
        List<Book> books = List.of(new Book(3, "tt3"), new Book(1, "tt1"), new Book(2, "tt2"));
        HashMap<Integer, Book> bookHashMap = books.stream()
                .reduce(new HashMap<Integer, Book>(), // Нейтральное значение для putAll
                        (map, book) -> { // Поместить одну книгу в Map методом put
                            map.put(book.getId(), book);
                            return map;
                        },
                        (map1, map2) -> { // Объединить две структуры Map методом putAll
                            map1.putAll(map2);
                            return map1;
                        }
                );
        bookHashMap.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
