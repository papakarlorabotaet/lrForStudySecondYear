package ru.fishev.MySecondTestAppSpringBoot.model;

public enum System {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    SERVICE("Service 1");


    private final String name;
    System(String name) {
        this.name = name;

    }
}
