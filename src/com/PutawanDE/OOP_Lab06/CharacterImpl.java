package com.PutawanDE.OOP_Lab06;

public class CharacterImpl implements Character {
    // Stats
    private String name;
    private int level;
    public float hp;
    public float maxHp;
    public float mana;
    private float maxMana;
    private float defense;

    public String orgCharType;
    public String currentCharType;

    // Position
    private float posX;
    private float posY;

    private AccessoryImpl equippedAccessory;
    protected boolean isDead;

    /**
     * Create a new character
     *
     * @param name            name of this character
     * @param currentCharType character type
     */
    public CharacterImpl(String name, String currentCharType) {
        this.level = 1;
        this.name = name;
        this.currentCharType = currentCharType;
        orgCharType = currentCharType;
        updateCharacterStats();
        hp = maxHp;
        mana = maxMana;
        getStat();
        posX = 0f;
        posY = 0f;
    }

    /**
     * Set defense of this character
     *
     * @param defense new defense to set to
     */
    public void setDefense(float defense) {
        this.defense = defense;
    }

    /**
     * get maxHP of this character
     *
     * @return maxHP of this character
     */
    public float getMaxHp() {
        return maxHp;
    }

    /**
     * get maxMana of this character
     *
     * @return maxMana of this character
     */
    public float getMaxMana() {
        return maxMana;
    }

    /**
     * get name of this character
     *
     * @return name of this character
     */
    public String getName() {
        return name;
    }

    /**
     * get x position of this character
     *
     * @return x position of this character
     */
    public float getPosX() {
        return posX;
    }


    /**
     * get y position of this character
     *
     * @return y position of this character
     */
    public float getPosY() {
        return posY;
    }

    /**
     * get status of this character- Dead, or Alive
     *
     * @return true when this character is dead
     */
    public boolean getIsDead() {
        return isDead;
    }

    @Override
    public void upLevel() {
        if (isDead) return;
        float lostMana = maxMana;
        if (useMana(lostMana)) {
            level++;
            updateCharacterStats();
            hp = maxHp;
            System.out.println("\n" + name + " up level to Lv." + level +
                    " with " + lostMana + " mana");
            getStat();
        }
    }

    @Override
    public void getStat() {
        printOutCharStats();
        printOutAccessoryStats();
        System.out.println();
    }

    @Override
    public void equipAccessory(AccessoryImpl accessory) {
        if (!isDead) {
            System.out.println(name + " equipped " + accessory.name);
            equippedAccessory = accessory;
        }
    }

    @Override
    public void unequipAccessory() {
        if (!isDead) {
            updateCharacterStats();
            System.out.println(name + " unequipped " + equippedAccessory.name);
            equippedAccessory = null;
        }
    }

    @Override
    public void attack(CharacterImpl opp, float inflictingDmg) {
        if (isDead) return;

        System.out.println("\n" + name + " attacked " + opp.name);

        float dealtDamage = opp.dealtDamage(inflictingDmg);
        float gainedMana = dealtDamage * 0.4f;
        increaseMana(gainedMana);

        System.out.println(opp.name + " took " + dealtDamage + " dmg");
        System.out.println(name + " gained " + gainedMana + " mana");
        System.out.println();
        this.getStat();
        opp.getStat();
        System.out.println("--------------------------------------------------------");
    }

    @Override
    public float dealtDamage(float damage) {
        float takenDmg;
        takenDmg = damage - defense;

        if (hp > takenDmg) {
            hp -= takenDmg;
        } else {
            gameOver();
            takenDmg = hp;
        }

        return takenDmg;
    }

    /**
     * Activate the equipped accessory's action
     * effects: print out who uses what
     *
     * @param opp opponent Character
     */
    public void useAccessory(CharacterImpl opp) {
        if (equippedAccessory != null) {
            System.out.println(name + " uses " + equippedAccessory.name);
            equippedAccessory.activate(opp, this);
        }
    }

    private void gameOver() {
        hp = 0f;
        isDead = true;
        System.out.println("\n" + name + " is dead.");
    }

    /**
     * Drain this character's mana by an amount
     * effects: If mana is not enough, print out not enough.
     * effects: Set mana field to new amount
     *
     * @param lostMana an amount of mana which is lost
     * @return whether the character has enough mana to use
     */
    boolean useMana(float lostMana) {
        if (isDead) return false;
        else if (mana >= lostMana) {
            mana = Math.max(0, mana - lostMana);
            return true;
        } else {
            System.out.println("Not enough Mana. Need: " + lostMana);
            return false;
        }
    }

    private void increaseMana(float gainedMana) {
        mana = Math.min(mana + gainedMana, maxMana);
    }

    private void updateCharacterStats() {
        maxHp = 100 + 10 * level;
        maxMana = 50 + 2 * level;
        defense = 0f;
    }

    /**
     * Print out Character's stat
     * effects: print out name, HP/MaxHp, mana/maxMana, Type
     */
    public void printOutCharStats() {
        System.out.print("Name: " + name + " Lv." + level);
        System.out.print(" | HP/maxHP: " + hp + "/" + maxHp);
        System.out.print(" | mana/maxMana: " + mana + "/" + maxMana + "\n");
        System.out.println("Occ: " + currentCharType);
    }

    /**
     * Print out equipped accessory's stat
     * effects: print out the equipped accessory's stat-
     * Type, Name, Level, Owner's name
     * effects: print out "No equipped Accessory" if equippedAccessory is null
     */
    public void printOutAccessoryStats() {
        if (equippedAccessory != null) equippedAccessory.getStat();
        else System.out.println("No equipped Accessory");
    }
}
