package com.PutawanDE.OOP_Lab08;

import java.util.Comparator;

public class ShortlexComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 != n2) {
            return n1 - n2;
        } else {
            for (int i = 0; i < n1; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                if (c1 != c2) {
                    c1 = Character.toLowerCase(c1);
                    c2 = Character.toLowerCase(c2);

                    if (c1 != c2) {
                        return (int) c1 - (int) c2;
                    }
                }
            }
        }

        return 0;
    }

    @Override
    public Comparator<String> reversed() {
        return Comparator.super.reversed();
    }
}
