package com.svshayt.java_util_stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFindFirstDemo {

    public static void main(String[] args) {
        // Нахождение первого четного числа
        Optional<Integer> firstEven = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println(firstEven); // Печатается Optional[4]

        // Применение findFirst к пустому потоку
        Optional<Integer> firstEvenGT10 = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .filter(n -> n > 10)
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println(firstEvenGT10); // Печатается Optional.empty

        // Использование firstEven с параллельным потоком
        firstEven = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .parallel()
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println(firstEven); // Всегда печатается Optional[4]

        List<String> wordList = Arrays.asList(
                "this", "is", "a", "stream", "of", "strings");
        Set<String> words = new HashSet<>(wordList);
        Set<String> words2 = new HashSet<>(words);
        // Теперь добавим и удалим столько элементов, чтобы вызвать повторное хэширование
        IntStream.rangeClosed(0, 50).forEachOrdered(i ->
                words2.add(String.valueOf(i)));
        words2.retainAll(wordList);
        // Множества равны, но порядок элементов различен
        System.out.println(words.equals(words2));
        System.out.println("До : " + words);
        System.out.println("После: " + words2);

        // Результат будет выглядеть примерно так:
        // true
        // До : [a, strings, stream, of, this, is]
        // После: [this, is, strings, stream, of, a]
        // Порядок различается, поэтому findFirst дает разные результаты.


        var demo = new StreamFindFirstDemo();

        Optional<Integer> any = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered() // Порядок нас не волнует
                .parallel() // Для распараллеливания используем обычный пул разветвления-соединения
                .map(demo::delay) // Вводим случайную задержку
                .findAny(); // Возвращаем первый элемент независимо от порядка следования
        System.out.println("Any: " + any);

        // Применение findAny к последовательному и к параллельному потокам
        Optional<Integer> any2 = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .map(demo::delay)
                .findAny(); // Последовательный поток (по умолчанию)

        System.out.println("Sequential Any: " + any2);
        var any3 = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .parallel()
                .map(demo::delay)
                .findAny(); // Параллельный поток
        System.out.println("Parallel Any: " + any3);
    }

    public Integer delay(Integer n) {
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException ignored) {
            // Единственное исключение в Java, которое можно безопасно перехватить и проигнорировать
        }
        return n;
    }
}
