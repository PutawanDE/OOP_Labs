package com.PutawanDE.OOP_LabF01;

import java.util.ArrayList;

public class LabF01 {
    public static void main(String[] args) {
        StudentsHashTable sht = new StudentsHashTable();

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(630610737, "Tanat Tangun", "CPE"));
        studentList.add(new Student(630610734, "Tanadol", "CPE"));
        studentList.add(new Student(630610752, "Phurich", "CPE"));
        studentList.add(new Student(630610751, "Phurich", "CPE"));
        studentList.add(new Student(630610100, "Sam Samson", "CE"));
        studentList.add(new Student(630610320, "Bill James", "ME"));


        for (Student student : studentList) {
            sht.put(student.id, student);
        }

        for (Student student : studentList) {
            System.out.println(sht.get(student.id));
        }

        System.out.println(sht);
    }
}
