package com.PutawanDE.OOP_Lab05;

public class MageImpl extends CharacterImpl implements Mage {
    private float regenRate = 0.4f;

    public MageImpl(String name) {
        super(name, "Mage");
    }

    @Override
    public void castAtkSpell(Spell spell, CharacterImpl opp) {
        if (isDead) return;

        super.attack(opp, spell.dmg);
    }

    @Override
    public void castDefSpell(Spell spell) {
        if (isDead) return;

        super.setDefense(spell.def);
    }

    @Override
    public void regen() {
        if (isDead) return;

        hp = Math.min(regenRate * super.hp, super.getMaxHp());
    }
}
