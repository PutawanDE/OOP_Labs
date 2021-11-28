package com.PutawanDE.OOP_Lab06;

public interface Character {
    /**
     * Up this character's level using their mana
     * effects: drain all mana
     * effects: increase maxMana, maxHP according to level
     * effects: reset this character's defense
     * effects: set HP to maxHP
     * effects: print out describing who up level to what level using
     * how much mana and print out the stats
     */
    void upLevel();

    /**
     * Print out this character's stat and equipped accessory's stat
     * effects: print out this character's stat and equipped accessory's stat
     */
    void getStat();

    /**
     * Equip this accessory for this character
     * effects: set their field equippedAccessory to the equipped accessory
     * effects: print out who equipped what
     *
     * @param accessory an accessory to be equipped
     */
    void equipAccessory(AccessoryImpl accessory);

    /**
     * Unequipped the equipped accessory for this character
     * effects: set their field equippedAccessory to null
     * effects: print out who unequipped what
     */
    void unequipAccessory();

    /**
     * Attack the opponent and gain Mana from attacking
     * effects: print out who attacked who, dealtDamage of the opponent,
     * gained mana
     * effects: get the resulting stats of both characters
     *
     * @param opp           Character to be attacked
     * @param inflictingDmg damage inflicting on the opponent
     */
    void attack(CharacterImpl opp, float inflictingDmg);

    /**
     * Defending the attack and dealt damage
     * effects: If the resulting hp is less than, or equal to  0, then set this
     * character's isDead field to true
     *
     * @param damage inflicting damage from other's attack
     * @return the actual damage after defending
     */
    float dealtDamage(float damage);

}
