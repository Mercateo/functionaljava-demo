package com.mercateo.demo.functionaljava;


public class Task {
    private final String name;
    private final Integer priority;

    public Task(String name, Integer priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }
}