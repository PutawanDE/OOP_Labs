package com.PutawanDE.OOP_Lab07;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class lab07 {
    public static void main(String[] args) {
        SetFromHashmap<Integer> s = new SetFromHashmap<>();
//        s.add(5);
        // Test Add
        System.out.println("TEST ADD");
        if (s.add(5)) {
            System.out.println("Adding 5. 5 was not in this set.");
        } else {
            System.out.println("5 is already in this set.");
        }

        if (s.add(5)) {
            System.out.println("Adding 5. 5 was not in this set.");
        } else {
            System.out.println("5 is already in this set.");
        }
        System.out.println("------------------------------");

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);

        // Test containsAll
        System.out.println("TEST containsAll");
        System.out.println("ArrayList is subset of this set? " + s.containsAll(arrayList));
        arrayList.add(9);
        System.out.println("ArrayList is subset of this set? " + s.containsAll(arrayList));
        System.out.println("------------------------------");

        s.add(10);
        s.add(15);

        // Test remove
        System.out.println("TEST remove");
        if (s.remove(5)) {
            System.out.println("Removing 5. 5 was in this set.");
        } else {
            System.out.println("5 is not in this set.");
        }

        if (s.add(5)) {
            System.out.println("Adding 5. 5 was not in this set.");
        } else {
            System.out.println("5 is already in this set.");
        }
        System.out.println("------------------------------");

        // Test removeAll
        System.out.println("TEST removeAll");
        arrayList.add(10);
        arrayList.add(15);
        System.out.println("s - arrayList. Is s changed? " + s.removeAll(arrayList));
        System.out.println("------------------------------");

        // Test contains
        System.out.println("TEST contains");
        System.out.println("Does s have 10? " + s.contains(10));
        System.out.println("Does s have 5? " + s.contains(5));
        System.out.println("------------------------------");

        // Test empty
        System.out.println("TEST isEmpty");
        System.out.println("Is s empty? " + s.isEmpty());
        System.out.println("------------------------------");

        // Test clear
        System.out.println("TEST clear");
        s.add(6556);
        s.add(1212);
        System.out.println("Is s empty? " + s.isEmpty());
        s.clear();
        System.out.println("Is s empty? " + s.isEmpty());
        System.out.println("------------------------------");

        // Test retainAll
        System.out.println("TEST retainAll");
        arrayList.add(100);
        arrayList.add(1000);
        arrayList.add(5000);
        s.add(100);
        s.add(1000);
        s.add(5000);
        s.add(8000);
        s.add(-64);
        System.out.println("Is s changed? " + s.retainAll(arrayList));
        System.out.println("------------------------------");

        // Test size
        System.out.println("TEST retainAll");
        System.out.println("s size: " + s.size());
        System.out.println("------------------------------");

        // Test iterator
        System.out.println();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Object n = it.next();
            System.out.println(n);
        }

        // Test other types
        SetFromHashmap<Float> floatSet = new SetFromHashmap<>();
        floatSet.add(515.5f);

        SetFromHashmap<String> strSet = new SetFromHashmap<>();
        strSet.add("Hello World");

        SetFromHashmap<Float> b = new SetFromHashmap<>();
        b.add(5f);
        System.out.println(floatSet.containsAll(b));
        b.remove(5f);
        b.add(515.5f);
        System.out.println(floatSet.containsAll(b));

    }
}
