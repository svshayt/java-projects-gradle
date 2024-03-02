package com.svshayt.comparator_collector;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamToMapDemo {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(1, "Modern Java Recipes", 49.99),
                new Book(2, "Java 8 in Action", 49.99),
                new Book(3, "Java SE8 for the Really Impatient", 39.99),
                new Book(4, "Functional Programming in Java", 27.64),
                new Book(5, "Making Java Groovy", 45.99),
                new Book(6, "Gradle Recipes for Android", 23.76)
        );

        Map<Integer, Book> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getId, book -> book)); // Тождественное лямбда-выражение: возвращает тот же элемент, что получает
        System.out.println(bookMap);

        Map<Integer, Book> bookMap2 = books.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity())); // Статический метод identity интерфейса Function делает то же самое
        System.out.println(bookMap2);

        Map<Integer, Book> bookMap3 = books.stream()
                .collect(Collectors.toMap(Book::getId, UnaryOperator.identity())); // Статический метод identity интерфейса UnaryOperator делает то же самое
        System.out.println(bookMap3);
    }
}

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class Book {
    private Integer id;
    private String name;
    private double price;
}
