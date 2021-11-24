package com.PutawanDE.OOP_Lab05;

public interface Character {
    void upLevel();

    void getStat();

    void equipAccessory(AccessoryImpl accessory);

    void unequipAccessory();

    void attack(CharacterImpl opp, float inflictingDmg);

    float dealtDamage(float damage);

}
