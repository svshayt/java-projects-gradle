package com.svshayt.java_util_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxedStreamDemo {
    public static void main(String[] args) {
        // Преобразование потока строк в список
        List<String> strings = Stream.of("this", "is", "a", "list", "of", "strings")
                .collect(Collectors.toList());

//        Преобразование потока int в список Integer (НЕ КОМПИЛИРУЕТСЯ)
//        IntStream.of(3, 1, 4, 1, 5, 9)
//                .collect(Collectors.toList()); // не компилируется

        // Во-первых, воспользоваться методом boxed интерфейса Stream, чтобы преобразовать IntStream в Stream<Integer>
        // Использование метода boxed
        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);

        // Другой способ – воспользоваться методом mapToObj для преобразования каж-
        //дого значения примитивного типа в экземпляр класса-обертки
        // Использование метода mapToObj
        List<Integer> ints2 = IntStream.of(3, 1, 4, 1, 5, 9)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(ints2);

        // <R> R collect(Supplier<R> supplier,
        // ObjIntConsumer<R> accumulator,
        // BiConsumer<R,R> combiner)

        // В этом примере поставщиком является конструктор класса ArrayList<Integer>,
        //аккумулятором – метод add, описывающий, как добавить в список один
        //элемент, а комбинатором (используется только в случае параллельных опера-
        //ций) – метод addAll, который объединяет два списка в один. Вариант collect
        //с тремя аргументами применяется не часто, но понимать, как он работает, по-
        //лезно.

        // Использование варианта collect с тремя аргументами
        List<Integer> ints3 = IntStream.of(3, 1, 4, 1, 5, 9)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(ints3);

        // Преобразование IntStream в массив
        int[] intArray = IntStream.of(3, 1, 4, 1, 5, 9).toArray();
        // или
//        int[] intArray2 = IntStream.of(3, 1, 4, 1, 5, 9).toArray(int[]::new);
    }
}
