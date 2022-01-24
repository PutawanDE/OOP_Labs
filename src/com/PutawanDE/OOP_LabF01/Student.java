package com.PutawanDE.OOP_LabF01;

public class Student {
    protected int id;
    protected String name;
    protected String major;

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "ID:" + id + " Name:" + name + " Major:" + major;
    }
}
