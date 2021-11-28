package com.PutawanDE.OOP_Lab06;

public class Lab06 {
    public static void main(String[] args) {
        AssassinImpl a = new AssassinImpl("Mark");
        MageImpl b = new MageImpl("Porter");

        Spell sp = new Spell();

        a.attack(b, 10f);
        a.disguise(b);
        a.distract();
        b.castAtkSpell(sp, a);
        b.castDefSpell(sp);

        CrystalImpl r = new CrystalImpl("Elder's ", a);
        a.equipAccessory(r);
        a.useAccessory(b);

        a.vision(b);
        a.takeDown(b, 0f, 0f);
    }
}
