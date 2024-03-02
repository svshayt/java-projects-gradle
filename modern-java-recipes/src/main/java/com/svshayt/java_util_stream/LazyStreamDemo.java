package com.svshayt.java_util_stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LazyStreamDemo {

    public static void main(String[] args) {
        // Первое число от 200 до 400, делящееся на 3
        OptionalInt firstEvenDoubleDivBy3 = IntStream.range(100, 200)
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(firstEvenDoubleDivBy3); // Печатается Optional[204]

        // Явная обработка каждого элемента потока
        // Обработка потока завершается после обработки всего трех значений,
        // для чего требуются шесть операций.
        LazyStreamDemo demo = new LazyStreamDemo();
        firstEvenDoubleDivBy3 = IntStream.range(100, 200)
                .map(demo::multByTwo) // Ссылка на метод умножения на 2 с печатью
                .filter(demo::divByThree) // Ссылка не метод деления на 3 по модулю с печатью
                .findFirst();
        System.out.println(firstEvenDoubleDivBy3);
    }

    public int multByTwo(int n) { // Ссылка на метод умножения на 2 с печатью
        System.out.printf("В multByTwo с аргументом %d%n", n);
        return n * 2;
    }

    public boolean divByThree(int n) { // Ссылка не метод деления на 3 по модулю с печатью
        System.out.printf("В divByThree с аргументом %d%n", n);
        return n % 3 == 0;
    }
}
