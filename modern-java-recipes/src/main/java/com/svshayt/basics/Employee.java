package com.svshayt.basics;

public interface Employee {

    String getFirst();

    String getLast();

    void convertCaffeineToCodeForMoney();

    default String getName() { // Метод по умолчанию, имеющий реализацию
        return String.format("%s %s", getFirst(), getLast());
    }
}
