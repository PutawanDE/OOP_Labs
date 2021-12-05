package com.PutawanDE.OOP_Lab08;

import java.util.*;

public class Lab08 {
    public static void main(String[] args) {
        SetFromHashmap<String> testSet1 = new SetFromHashmap<>();
        String[] testStr1 = new String[]{
                "ABC", "ABc", "abcd", "abc", "James", "Jack", "Robin",
                "Jake", "Zebra", "Zebras", "John", "Johnson", "Jackson",
                "Robinson", "Dennis", "Benedict", "zack", "Zack"
        };

        // Test ShortLex
        System.out.println("Test Shortlex Sort");
        Arrays.sort(testStr1, new ShortlexComparator());
        printArray(testStr1);

        testSet1.addAll(Arrays.asList(testStr1));
        testSet1.remove("zack");
        testSet1.remove("Robinson");

        // Test toArray
        String[] testStr2 = new String[testSet1.size()];
        testSet1.toArray(testStr2);
        Set<String> testSet2 = new HashSet<>(Arrays.asList(testStr2));

        // Test set compare, unequal size
        Comparator<Set<String>> setComparator = SetFromHashmap.setComparator(new ShortlexComparator());
        System.out.println("Test set compare with interoperability - unequal size");
        testSet2.add("Rose");
        System.out.println(setComparator.compare(testSet1, testSet2));

        // Test set compare - equal size
        testStr1 = new String[]{"abc", "abcd"};
        testStr2 = new String[]{"abc", "abc"};
        testSet1.clear();
        testSet2.clear();
        testSet1.addAll(Arrays.asList(testStr1));
        testSet2.addAll(Arrays.asList(testStr2));
        System.out.println("Test set compare with interoperability - equal size using ShortLex");
        System.out.println(setComparator.compare(testSet1, testSet2));
    }

    public static <E> void printArray(E[] arr) {
        for (E e : arr) {
            System.out.println(e);
        }
    }
}