package com.svshayt.java_util_function;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SupplierDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("...");

        // Реализация с помощью анонимного внутреннего класса
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };

        randomSupplier = () -> Math.random();
        randomSupplier = Math::random;
//        logger.info(randomSupplier);
        System.out.println(randomSupplier.getAsDouble());

        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoё", "Jayne", "Simon", "River", "Shepherd Book");

        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();

        System.out.println(first); // Печатается Optional.empty
        System.out.println(first.orElse("None")); // Печатается строка "None"

        // Коллекция с запятой-разделителем строится, даже если имя найдено
        System.out.println(first.orElse(String.format("Ничего не найдено в %s",
                names.stream().collect(Collectors.joining(", ")))));

        // Коллекция с запятой-разделителем строится, только когда Optional пусто
        System.out.println(first.orElseGet(() -> String.format("Ничего не найдено в %s",
                names.stream().collect(Collectors.joining(", ")))));
    }
}
