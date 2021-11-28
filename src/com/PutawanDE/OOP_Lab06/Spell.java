package com.PutawanDE.OOP_Lab06;

public class Spell {
    protected float dmg = 50f;
    protected float def = 40f;

    /**
     * Print out the spell's stat
     * effects: print out damage, and defense
     */
    protected void getStats() {
        System.out.println("Dmg: " + dmg + "Def: " + def);
    }
}
