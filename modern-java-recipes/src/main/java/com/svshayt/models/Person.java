package com.svshayt.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;

    // Копирующий конструктор класса Person
    public Person(Person p) {
        this.name = p.name;
    }

    // Этот конструктор принимает ноль или более строковых аргументов и
    // конкатенирует их через пробел.
    public Person(String... names) {
        this.name = Arrays.stream(names)
                .collect(Collectors.joining(" "));
    }
}

