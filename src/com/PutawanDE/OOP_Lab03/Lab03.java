package com.PutawanDE.OOP_Lab03;

public class Lab03 {
    public static void main(String[] args) {
        Character c1 = new Character("Jack");
        Character c2 = new Character("John");

        Sword sw1 = new Sword(c1, "Excalibur");
        Sword sw2 = new Sword(c2, "Lightsaber");

        c1.equipSword(sw1);
        c2.equipSword(sw2);

        Shield shield1 = new Shield(c1, "Golden Shield");

        c2.equipShield(shield1);
        c1.equipShield(shield1);

        c1.upCharacterLevel();
        c2.upCharacterLevel();
        c1.attack(c2);
        c2.attack(c1);
        c1.attack(c2);
        c2.attack(c1);
        c1.attack(c2);
        c2.attack(c1);
        c1.attack(c2);
        c2.attack(c1);
        sw1.upLevel(c1);
        c1.attack(c2);
        c2.attack(c1);
        c1.attack(c2);
        c1.unequipShield();
        c1.upCharacterLevel();
        c2.attack(c1);
    }
}
