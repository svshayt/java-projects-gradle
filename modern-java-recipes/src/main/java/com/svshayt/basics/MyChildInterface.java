package com.svshayt.basics;

// После расширения функциональный интерфейс перестает
//быть функциональным
//@FunctionalInterface - не работает
public interface MyChildInterface extends MyInterface {

    int anotherMethod(); // Дополнительный абстрактный метод
}
