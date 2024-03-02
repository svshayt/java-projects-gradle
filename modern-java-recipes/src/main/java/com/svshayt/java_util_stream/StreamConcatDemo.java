package com.svshayt.java_util_stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcatDemo {
    public static void main(String[] args) {
        // Конкатенация двух потоков
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        List<String> strings = Stream.concat(first, second) // Сначала элементы потока first, потом элементы потока second
                .collect(Collectors.toList());
        List<String> stringList = Arrays.asList("a", "b", "c", "X", "Y", "Z");
        System.out.println(stringList.equals(strings));

        // Конкатенация нескольких потоков
        Stream<String> first2 = Stream.of("a", "b", "c").parallel();
        Stream<String> second2 = Stream.of("X", "Y", "Z");
        Stream<String> third2 = Stream.of("alpha", "beta", "gamma");
        List<String> strings2 = Stream.concat(Stream.concat(first2, second2), third2)
                .collect(Collectors.toList());
        List<String> stringList2 = Arrays.asList("a", "b", "c",
                "X", "Y", "Z", "alpha", "beta", "gamma");
        System.out.println(stringList2.equals(strings2));

        // Конкатенация с помощью метода reduce
        Stream<String> first3 = Stream.of("a", "b", "c").parallel();
        Stream<String> second3 = Stream.of("X", "Y", "Z");
        Stream<String> third3 = Stream.of("alpha", "beta", "gamma");
        Stream<String> fourth3 = Stream.empty();
        List<String> strings3 = Stream.of(first3, second3, third3, fourth3)
                .reduce(Stream.empty(), Stream::concat) // Вызов reduce с пустым потоком и бинарным оператором
                .collect(Collectors.toList());
        List<String> stringList3 = Arrays.asList("a", "b", "c",
                "X", "Y", "Z", "alpha", "beta", "gamma");
        System.out.println(stringList3.equals(strings3));

        // Применение flatMap для конкатенации потоков
        Stream<String> first4 = Stream.of("a", "b", "c").parallel();
        Stream<String> second4 = Stream.of("X", "Y", "Z");
        Stream<String> third4 = Stream.of("alpha", "beta", "gamma");
        Stream<String> fourth4 = Stream.empty();
        List<String> strings4 = Stream.of(first4, second4, third4, fourth4)
                .flatMap(Function.identity())
                .collect(Collectors.toList());
        List<String> stringList4 = Arrays.asList("a", "b", "c",
                "X", "Y", "Z", "alpha", "beta", "gamma");
        System.out.println(stringList4.equals(strings4));

        // Параллельный или нет?
        Stream<String> first5 = Stream.of("a", "b", "c").parallel();
        Stream<String> second5 = Stream.of("X", "Y", "Z");
        Stream<String> third5 = Stream.of("alpha", "beta", "gamma");
        Stream<String> total5 = Stream.concat(Stream.concat(first5, second5), third5);
        System.out.println(total5.isParallel());

        Stream<String> first6 = Stream.of("a", "b", "c").parallel();
        Stream<String> second6 = Stream.of("X", "Y", "Z");
        Stream<String> third6 = Stream.of("alpha", "beta", "gamma");
        Stream<String> fourth6 = Stream.empty();
        Stream<String> total6 = Stream.of(first6, second6, third6, fourth6)
                .flatMap(Function.identity());
        System.out.println(total6.isParallel());

        var total7 = total6.parallel();
        System.out.println(total7.isParallel());
    }
}
