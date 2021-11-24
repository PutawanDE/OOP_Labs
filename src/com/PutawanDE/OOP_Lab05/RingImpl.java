package com.PutawanDE.OOP_Lab05;

public class RingImpl extends AccessoryImpl implements Ring {
    public RingImpl(String name, CharacterImpl owner) {
        super(name + " Ring", owner, "Ring");
    }

    @Override
    public void activate(CharacterImpl opp, CharacterImpl wearer) {
        castSpell(opp, wearer);
    }

    @Override
    public void castSpell(CharacterImpl opp, CharacterImpl wearer) {
        if (wearer.equals(owner)) {
            Spell spell = new Spell();
            wearer.attack(opp, spell.dmg);
        }
    }
}
