package com.svshayt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;

// Класс Team с полями id, name и salary
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance();
    private int id;
    private String name;
    private double salary;

    // ... конструкторы, методы чтения и установки ...
    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name=’" + name + '\'' +
                ", salary=" + nf.format(salary) +
                '}';
    }
}
