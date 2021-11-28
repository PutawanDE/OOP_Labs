package com.PutawanDE.OOP_Lab06;

public interface Accessory {
    /**
     * Up accessory's level using the upgrader's Mana
     * effects: use the upgrader's mana by 0.6 of their maxMana
     * effects: print out describing who upgrades what to what level using
     * how much mana
     *
     * @param upgrader Character who wants to upgrade the accessory
     */
    void upLevel(CharacterImpl upgrader);

    /**
     * Print out this accessory's stat
     * effects: print out this accessory's stat- Type, Name,
     * Level, Owner's name
     */
    void getStat();
}
