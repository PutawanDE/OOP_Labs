package com.PutawanDE.OOP_Lab05;

public class Lab05 {
    public static void main(String[] args) {
        CharacterImpl a = new AssassinImpl("Mark");
        CharacterImpl b = new MageImpl("Porter");

        a.attack(b, 10f);

    }
}
