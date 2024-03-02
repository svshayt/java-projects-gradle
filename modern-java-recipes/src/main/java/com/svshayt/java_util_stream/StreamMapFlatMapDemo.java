package com.svshayt.java_util_stream;

import com.svshayt.models.Customer;
import com.svshayt.models.Order;

import java.util.Arrays;
import java.util.List;

public class StreamMapFlatMapDemo {
    public static void main(String[] args) {
        Customer sheridan = new Customer("Sheridan");
        Customer ivanova = new Customer("Ivanova");
        Customer garibaldi = new Customer("Garibaldi");
        sheridan.addOrder(new Order(1))
                .addOrder(new Order(2))
                .addOrder(new Order(3));
        ivanova.addOrder(new Order(4))
                .addOrder(new Order(5));
        List<Customer> customers = Arrays.asList(sheridan, ivanova, garibaldi);

        // Применение map для отображения Customer на name
        customers.stream() // Stream<Customer>
                .map(Customer::getName) // Stream<String>
                .forEach(System.out::println); // Sheridan, Ivanova, Garibaldi

        // Применение map для отображения Customer на orders
        customers.stream()
                .map(Customer::getOrders) // Stream<List<Order>>
                .forEach(System.out::println); // [Order{id=1}, Order{id=2}, Order{id=3}], [Order{id=4}, Order{id=5}], []
        customers.stream()
                .map(customer -> customer.getOrders().stream()) // Stream<Stream<Order>>
                .forEach(System.out::println);

        // Применение flatMap к заказам
        customers.stream() // Stream<Customer>
                .flatMap(customer -> customer.getOrders().stream()) // Stream<Order>
                .forEach(System.out::println); // Order{id=1}, Order{id=2}, Order{id=3}, Order{id=4}, Order{id=5}
    }
}
