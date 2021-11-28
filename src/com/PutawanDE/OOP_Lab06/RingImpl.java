package com.PutawanDE.OOP_Lab06;

public class RingImpl extends AccessoryImpl implements Ring {
    /**
     * Create a new Ring
     *
     * @param name  name of this Ring
     * @param owner Character who owns this Ring
     */
    public RingImpl(String name, CharacterImpl owner) {
        super(name + " Ring", owner, "Ring");
    }

    @Override
    public void activate(CharacterImpl opp, CharacterImpl wearer) {
        castSpell(opp, wearer);
    }

    @Override
    public void castSpell(CharacterImpl opp, CharacterImpl wearer) {
        if (checkOwnership(wearer)) {
            Spell spell = new Spell();
            wearer.attack(opp, spell.dmg);
        }
    }
}
