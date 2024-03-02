package com.svshayt.java_util_stream;

import java.util.stream.IntStream;

public class StreamPeekDemo {
    public static void main(String[] args) {


    }

    // Удвоение, фильтрация и суммирование целых чисел
    public int sumDoublesDivisibleBy3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .sum();
    }

    // Добавление тождественного отображения для печати
    public int sumV2DoublesDivisibleBy3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .map(n -> { // Тождественное отображение, которое печатает и возвращает элемент
                    System.out.println(n);
                    return n;
                })
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .sum();
    }

    // Несколько методов peek
    public int sumV3DoublesDivisibleBy3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .peek(n -> System.out.printf("original: %d%n", n)) // Печатать значение до удвоения
                .map(n -> n * 2)
                .peek(n -> System.out.printf("doubled : %d%n", n)) // Печатать значение после удвоения, но до фильтрации
                .filter(n -> n % 3 == 0)
                .peek(n -> System.out.printf("filtered: %d%n", n)) // Печатать значение после фильтрации, но до суммирования
                .sum();
    }
}
