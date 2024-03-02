package com.svshayt.basics;

// MyInterface – функциональный интерфейс, содержащий статический метод
// и метод по умолчанию
@FunctionalInterface
public interface MyInterface {

    int myMethod(); // Единственный абстрактный метод
    // int myOtherMethod(); // Если раскомментировать эту строку, интерфейс перестанет быть функциональным

    default String sayHello() {
        return "Hello, World";
    }

    static void myStaticMethod() {
        System.out.println("Это статичесий метод интерфейса");
    }
}
