package com.svshayt.comparator_collector;

import com.svshayt.models.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamWithPartitioningByAndMinMaxDemo {

    public static void main(String[] args) {
        // Разбиение строк по четности длины
        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");
        Map<Boolean, List<String>> lengthMap = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));
        lengthMap.forEach((key, value) -> System.out.printf("%5s: %s%n", key, value));

        // Подсчет количества строк в каждой категории
        Map<Boolean, Long> numberLengthMap = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0,
                        Collectors.counting())); // Подчиненный коллектор
        numberLengthMap.forEach((k, v) -> System.out.printf("%5s: %d%n", k, v));

        List<Employee> employees = Arrays.asList( // Коллекция работников
                new Employee("Cersei", 250_000, "Lannister"),
                new Employee("Jamie", 150_000, "Lannister"),
                new Employee("Tyrion", 1_000, "Lannister"),
                new Employee("Tywin", 1_000_000, "Lannister"),
                new Employee("Jon Snow", 75_000, "Stark"),
                new Employee("Robb", 120_000, "Stark"),
                new Employee("Eddard", 125_000, "Stark"),
                new Employee("Sansa", 0, "Stark"),
                new Employee("Arya", 1_000, "Stark"));
        Employee defaultEmployee = // Значение по умолчанию в случае, когда поток пуст
                new Employee("A man (or woman) has no name", 0, "Black and White");

        // Использование метода BinaryOperator.maxBy
        Optional<Employee> optionalEmp = employees.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println("Работник с максимальной зарплатой: " +
                optionalEmp.orElse(defaultEmployee));

        // Использование метода Stream.max
        optionalEmp = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary));
        System.out.println(optionalEmp);

        // Нахождение наибольшей зарплаты
        OptionalInt maxSalary = employees.stream()
                .mapToInt(Employee::getSalary)
                .max();
        System.out.println("Наибольшая зарплата равна " + maxSalary);

        //Использование метода Collectors.maxBy
        optionalEmp = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println(optionalEmp);

        // Использование метода Collectors.maxBy в роли подчиненного коллектора
        Map<String, Optional<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(
                                Comparator.comparingInt(Employee::getSalary))));
        map.forEach((house, emp) ->
                System.out.println(house + ": " + emp.orElse(defaultEmployee)));
    }
}
