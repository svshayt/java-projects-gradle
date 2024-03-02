package com.svshayt.java_util_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMatchDemo {
    public static void main(String[] args) {
        var demo = new StreamMatchDemo();

        System.out.println(demo.isPrime(1001));

        // Для простоты используем allMatch
        var result = IntStream.of(2, 3, 5, 7, 11, 13, 17, 19)
                .allMatch(demo::isPrime);
        System.out.println(result);

        // Тест с составными числами
        var result2 = Stream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20)
                .anyMatch(demo::isPrime);
        System.out.println(result2);

        // Для пустого потока методы allMatch и noneMatch возвращают true, а метод anyMatch –
        // false независимо от переданного предиката. Предикат вообще не вычисляется, если
        // поток пустой.
    }

    public boolean isPrime(int num) {
        int limit = (int) (Math.sqrt(num) + 1); // Максимальное проверяемое число
        return num == 2 || num > 1 && IntStream.range(2, limit) // Использование noneMatch
                .noneMatch(divisor -> num % divisor == 0);
    }
}
