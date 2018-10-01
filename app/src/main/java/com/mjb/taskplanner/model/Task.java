package com.mjb.taskplanner.model;

public class Task {

    private String name;
    private String list;

    public Task(String name, String list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public String getList() {
        return list;
    }
}
