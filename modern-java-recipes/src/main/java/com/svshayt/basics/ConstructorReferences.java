package com.svshayt.basics;

import com.svshayt.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorReferences {
    public static void main(String[] args) {
        // Преобразование списка людей в список имен
        List<Person> people = new ArrayList<>();
        List<String> names = people.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());
        // или
        List<String> namesRef = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        // Преобразование строк в экземпляры класса Person
        List<String> stringNames = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Sparck Jones");

        List<Person> lambdaPeople = stringNames.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());
        // или
        List<Person> lambdaMethodPeople = stringNames.stream()
                .map(Person::new) // Создание объекта Person с помощью ссылки на конструктор
                .collect(Collectors.toList());
        System.out.println(lambdaMethodPeople);

        Person before = new Person("Grace Hopper");

        List<Person> people1 = Stream.of(before)
                .collect(Collectors.toList());
        Person after = people1.get(0);

        System.out.println(before == after); // true

        before.setName("Grace Murray Hopper");
        System.out.println("Grace Murray Hopper".equals(after.getName())); // true

        List<Person> people2 = Stream.of(before)
                .map(Person::new) // Используется копирующий конструктор
                .collect(Collectors.toList());
        after = people2.get(0);
        System.out.println(before == after); // false - Объекты разные
        System.out.println(before.equals(after)); // true - Объекты эквивалентные

        before.setName("Rear Admiral Dr. Grace Murray Hopper");
        System.out.println(before.equals(after)); // false

        var stringResult = stringNames.stream() // Создать поток строк
                .map(name -> name.split(" ")) // Отобразить на поток массивов строк
                .map(Person::new) // Отобразить на поток объектов Person
                .collect(Collectors.toList()); // Собрать в список объектов Person
        System.out.println(stringResult);

        Person[] people3 = stringNames.stream()
                .map(Person::new)
                .toArray(Person[]::new); // Ссылка на конструктор массива Person
        System.out.println(Arrays.asList(people3));
    }
}
