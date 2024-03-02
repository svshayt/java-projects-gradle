package com.svshayt.java_util_stream;

import java.util.stream.Stream;

public class StringToStreamDemo {
    public static void main(String[] args) {
        var demo = new StringToStreamDemo();

        //Тестирование метода проверки на палиндром
        var result = Stream.of("Madam, in Eden, I’m Adam",
                        "Go hang a salami; I’m a lasagna hog",
                        "Flee to me, remote elf!",
                        "A Santa pets rats as Pat taps a star step at NASA")
                .allMatch(demo::isPalindrome);
        System.out.println(result);

        System.out.println(demo.isPalindrome("Это НЕ палиндром"));
    }

    // Проверка на палиндром в Java 7 и более ранних версиях
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String forward = sb.toString().toLowerCase();
        String backward = sb.reverse().toString().toLowerCase();
        return forward.equals(backward);
    }

    //Проверка на палиндром с помощью потоков Java 8
    public boolean isPalindromeJava8(String s) {
        String forward = s.toLowerCase().codePoints() // Возвращается IntStream
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }
}
