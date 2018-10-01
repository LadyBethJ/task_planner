package com.mjb.taskplanner.model;

public class Task {

    private String name;
    private String list;
    private String date;
    private String hour;

    public Task(String name, String list, String date, String hour) {
        this.name = name;
        this.list = list;
        this.date = date;
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public String getList() {
        return list;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }
}
