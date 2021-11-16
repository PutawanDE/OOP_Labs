package com.PutawanDE.OOP_Lab03;

public class Character {
    public final float BASE_RUN_SPEED = 100f;
    public final float BARE_FIST_DAMAGE = 15f;

    private String name;

    private int level;
    private float hp;
    private float maxHp;
    private float mana;
    private float maxMana;
    private float runSpeed;
    private float maxRunSpeed;
    private boolean isDead;

    private Sword equippedSword;
    private Shield equippedShield;

    public Character(String name) {
        this.level = 1;
        this.name = name;
        updateCharacterStats();
        runSpeed = maxRunSpeed;
        mana = maxMana;
        printOutStats();
    }

    public String getName() {
        return name;
    }

    public float getMaxMana() {
        return maxMana;
    }

    public Sword getEquippedSword() {
        return equippedSword;
    }

    public Shield getEquippedShield() {
        return equippedShield;
    }

    public void upCharacterLevel() {
        if (isDead) return;
        float lostMana = maxMana;
        if (useMana(lostMana)) {
            level++;
            updateCharacterStats();
            System.out.println("\n" + name + " up level to Lv." + level +
                    " with " + lostMana + " mana");
            printOutStats();
        }
    }

    public void equipSword(Sword sword) {
        if (isDead) return;
        if (!sword.checkOwnership(this)) {
            System.out.println("Cannot equip. You don't own this.");
            return;
        }

        equippedSword = sword;
        updateWeaponStats();
        System.out.println(name + " equipped " + sword.getName());
    }

    public void equipShield(Shield shield) {
        if (isDead) return;
        if (!shield.checkOwnership(this)) {
            System.out.println("Cannot equip. You don't own this.");
            return;
        }

        equippedShield = shield;
        updateWeaponStats();
        System.out.println(name + " equipped " + shield.getName());
    }

    public void unequipSword() {
        if (isDead) return;
        System.out.println(name + " unequipped " + equippedSword.getName());
        equippedSword = null;
        updateWeaponStats();
    }

    public void unequipShield() {
        if (isDead) return;
        System.out.println(name + " unequipped " + equippedShield.getName());
        equippedShield = null;
        updateWeaponStats();
    }

    public void attack(Character opp) {
        if (isDead) return;

        System.out.println("\n" + name + " attacked " + opp.name);
        float inflictingDmg;
        if (equippedSword == null) inflictingDmg = BARE_FIST_DAMAGE;
        else inflictingDmg = equippedSword.getDamage();

        float dealtDamage = opp.dealtDamage(this, inflictingDmg);
        float gainedMana = dealtDamage * 0.4f;
        increaseMana(gainedMana);

        System.out.println(opp.getName() + " took " + dealtDamage + " dmg");
        System.out.println(name + " gained " + gainedMana + " mana");
        System.out.println();
        this.printOutCharStats();
        opp.printOutCharStats();
        System.out.println("--------------------------------------------------------");
    }

    public float dealtDamage(Character attacker, float damage) {
        float takenDmg;
        if (equippedShield == null) {
            takenDmg = damage;
        } else {
            takenDmg = damage - equippedShield.getDefense();
        }

        if (runSpeed >= attacker.runSpeed) {
            double r = Math.random();
            if (r <= 0.5) {
                takenDmg = 0f;
                System.out.println(this.name + " successfully dodged " + attacker.name + "'s attack.");
            }
        }

        if (hp > takenDmg) {
            hp -= takenDmg;
        } else {
            gameOver();
            takenDmg = hp;
        }

        return takenDmg;
    }

    private void gameOver() {
        hp = 0f;
        isDead = true;
        System.out.println("\n" + name + " is dead.");
    }

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

    public void updateWeaponStats() {
        float lostRunSpeed = 0f;
        if (equippedSword != null && equippedShield != null) {
            lostRunSpeed = equippedShield.getDecreaseRunSpeed()
                    + equippedSword.getDecreaseRunSpeed();
        } else if (equippedShield == null && equippedSword != null) {
            lostRunSpeed = equippedSword.getDecreaseRunSpeed();
        } else if (equippedShield != null && equippedSword == null) {
            lostRunSpeed = equippedShield.getDecreaseRunSpeed();
        }

        runSpeed = maxRunSpeed - lostRunSpeed;
    }

    private void updateCharacterStats() {
        maxHp = 100 + 10 * level;
        maxMana = 50 + 2 * level;
        maxRunSpeed = BASE_RUN_SPEED * (1f + 0.03f * level);
        hp = maxHp;
    }

    public void printOutStats() {
        printOutCharStats();
        printOutWeaponStats();
        System.out.println();
    }

    public void printOutCharStats() {
        System.out.print("Name: " + name + " Lv." + level);
        System.out.print(" | HP/maxHP: " + hp + "/" + maxHp);
        System.out.print(" | mana/maxMana: " + mana + "/" + maxMana);
        System.out.print(" | runSpd/maxRunSpd: " + runSpeed + "/" + maxRunSpeed + "\n");
    }

    public void printOutWeaponStats() {
        String swordStats = equippedSword != null ? equippedSword.getName() + "_"
                + equippedSword.getDamage() + "/-" + equippedSword.getDecreaseRunSpeed() : "none";
        String shieldStats = equippedShield != null ? equippedShield.getName() + "_"
                + equippedShield.getDefense() + "/-" + equippedShield.getDecreaseRunSpeed() : "none";

        System.out.println("Equipped Sword_dmg/-runSpd: " + swordStats + " | Equipped Shield_def/-runSpd: " + shieldStats);
    }
}
