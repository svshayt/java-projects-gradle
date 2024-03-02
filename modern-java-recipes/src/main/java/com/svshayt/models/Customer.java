package com.svshayt.models;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

// Отношение один ко многим
@ToString
public class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Customer addOrder(Order order) {
        orders.add(order);
        return this;
    }
}
