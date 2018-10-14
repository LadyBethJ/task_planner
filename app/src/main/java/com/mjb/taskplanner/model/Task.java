package com.mjb.taskplanner.model;

public class Task {

    private int id;
    private String name;
    private String list;
    private String date;
    private String hour;
    private int priority;
    private String notes;
    private int father;
    private String photo;
    private boolean done;

    public Task(String name, String list, String date, String hour) {
        this.name = name;
        this.list = list;
        this.date = date;
        this.hour = hour;
    }

    public Task(int id, String name, String list, String date, String hour, int priority, String notes, int father, String photo, boolean done) {
        this.id = id;
        this.name = name;
        this.list = list;
        this.date = date;
        this.hour = hour;
        this.priority = priority;
        this.notes = notes;
        this.father = father;
        this.photo = photo;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
