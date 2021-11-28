package com.PutawanDE.OOP_Lab06;

public interface Crystal extends Accessory {
    /**
     * Reduce the damage from Spell
     * effects: set the wearer's defense field to 20, if the attack is a Mage
     *
     * @param attacker the character who attacks
     * @param wearer   the character who is wearing this Crystal
     */
    void protect(CharacterImpl attacker, CharacterImpl wearer);
}
