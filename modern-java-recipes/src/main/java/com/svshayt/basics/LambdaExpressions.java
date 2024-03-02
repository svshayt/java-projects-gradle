package com.svshayt.basics;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class LambdaExpressions {
    public static void main(String[] args) {
        // Анонимный внутренний класс, реализующий интерфейс Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("внутри Runnable в анонимном внутреннем классе");
            }
        }).start();

        // Использование лямбда-выражения в конструкторе Thread
        new Thread(() -> System.out.println("внутри конструктора Thread с использованием лямбды")).start();

        // Присваивание лямбда-выражения переменной
        Runnable runnable = () -> System.out.println("лямбда-выражение, реализующее метод run");
        new Thread(runnable).start();

        // Реализация FilenameFilter с помощью анонимного внутреннего класса
        File directory = new File("./learning/modern-java-recipes/src/main/java/com/svshayt/lambda");

        String[] names = directory.list(new FilenameFilter() {
            // метод возвращает список имен файлов, удовлетворяющих условию фильтрации
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println(Arrays.asList(names));

        // Лямбда-выражение, реализующее интерфейс FilenameFilter
        String[] lambdaNames = directory.list((dir, name) -> name.endsWith(".java"));
        System.out.println(Arrays.asList(lambdaNames));

        // Лямбда-выражение с явно заданными типами данных
        String[] lambdaTypeNames = directory.list((File dir, String name) -> name.endsWith(".java"));
        System.out.println(Arrays.asList(lambdaTypeNames));

        // Блочное лямбда-выражение
        String[] lambdaTypeBlockNames = directory.list((File dir, String name) -> {
            return name.endsWith(".java");
        });
        System.out.println(Arrays.asList(lambdaTypeBlockNames));
    }
}
