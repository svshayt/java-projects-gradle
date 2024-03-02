package com.svshayt.basics;

import java.util.Arrays;
import java.util.List;

public class InterfaceDefaultMethods {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9);
        boolean removed = nums.removeIf(n -> n <= 0);
        System.out.println("Элементы " + (removed ? "были" : "НЕ были") + " удалены");
        nums.forEach(System.out::println);
    }
}
