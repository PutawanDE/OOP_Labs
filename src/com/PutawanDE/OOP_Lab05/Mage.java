package com.PutawanDE.OOP_Lab05;

public interface Mage extends Character {
    void castAtkSpell(Spell spell, CharacterImpl opp);
    void castDefSpell(Spell spell);
    void regen();
}
