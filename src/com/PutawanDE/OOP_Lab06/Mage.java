package com.PutawanDE.OOP_Lab06;

public interface Mage extends Character {
    /**
     * Attack the opponent using this spell
     * effect: will call the attack method with opp and spell's damage
     * as params
     *
     * @param spell Spell to be used in attacking
     * @param opp   Character who is attacked
     */
    void castAtkSpell(Spell spell, CharacterImpl opp);

    /**
     * Increase this character's defense using this spell
     * effect: set this character's defense field to this spell's defense
     *
     * @param spell Spell to be used to increase the defense
     */
    void castDefSpell(Spell spell);

    /**
     * Increase this character's HP by 0.4 of current hp
     * effects: set this character's hp field accordingly
     */
    void regen();
}
