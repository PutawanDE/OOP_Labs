package com.PutawanDE.OOP_Lab06;

public interface Ring extends Accessory {
    /**
     * Attack other character using a spell
     *
     * @param user Character who uses this ring
     * @param opp  Character who is attacked
     */
    void castSpell(CharacterImpl user, CharacterImpl opp);
}
