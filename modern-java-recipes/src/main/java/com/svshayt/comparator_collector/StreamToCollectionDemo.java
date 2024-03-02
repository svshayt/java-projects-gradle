package com.svshayt.comparator_collector;

import com.svshayt.models.Actor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToCollectionDemo {

    public static void main(String[] args) {
        // Создание списка
        List<String> superHeroes =
                Stream.of("Mr. Furious", "The Blue Raja", "The Shoveler",
                                "The Bowler", "Invisible Boy", "The Spleen", "The Sphinx")
                        .collect(Collectors.toList());
        System.out.println(superHeroes);

        // Создание множества
        Set<String> villains =
                Stream.of("Casanova Frankenstein", "The Disco Boys",
                                "The Not-So-Goodie Mob", "The Suits", "The Suzies",
                                "The Furriers", "The Furriers") // Повторяющееся имя, в процессе преобразования во множество удаляется
                        .collect(Collectors.toSet());
        System.out.println(villains);

        // Создание связного списка
        List<String> actors =
                Stream.of("Hank Azaria", "Janeane Garofalo", "William H. Macy",
                                "Paul Reubens", "Ben Stiller", "Kel Mitchell", "Wes Studi")
                        .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(actors);

        // Создание массива
        String[] wannabes =
                Stream.of("The Waffler", "Reverse Psychologist", "PMS Avenger")
                        .toArray(String[]::new); // Ссылка на конструктор массива в качестве Supplier
        System.out.println(Arrays.asList(wannabes));

        // Создание отображения
//        Set<Actor> actors = mysteryMen.getActors();
        Set<Actor> actorsSet = Set.of(new Actor("Alex", "Manager"), new Actor("John", "Banker"));
        Map<String, String> actorMap = actorsSet.stream()
                .collect(Collectors.toMap(Actor::getName, Actor::getRole)); // Функции, порождающие ключи и значения
        actorMap.forEach((key, value) ->
                System.out.printf("%s played %s%n", key, value));
    }

}
