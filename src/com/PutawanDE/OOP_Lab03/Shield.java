package com.PutawanDE.OOP_Lab03;

public class Shield {
    private String name;
    private Character owner;
    private int level;

    private float defense;
    private float decreaseRunSpeed;

    private final float BASE_SHIELD_DEFENSE = 40f;

    public Shield(Character owner, String name) {
        this.name = name + " of " + owner.getName();
        this.level = 1;
        this.owner = owner;
        updateStats(owner);
        System.out.println(owner.getName() + " forged shield " + name);
    }

    public String getName() {
        return name;
    }

    public float getDecreaseRunSpeed() {
        return decreaseRunSpeed;
    }

    public float getDefense() {
        return defense;
    }

    public boolean checkOwnership(Character c) {
        return c == owner;
    }

    public void upLevel(Character c) {
        if (!checkOwnership(c)) {
            System.out.println("Cannot upgrade. " + c.getName() + " doesn't own " + name + ".");
            return;
        }

        float lostMana = c.getMaxMana() * 0.5f;
        if (c.useMana(lostMana)) {
            level++;
            updateStats(c);
            System.out.println("\n" + c.getName() + " upgraded shield " + name + " to Lv." + level +
                    " with " + lostMana + " mana");
        }
    }

    private void updateStats(Character c) {
        defense = BASE_SHIELD_DEFENSE * (1f + 0.05f * level);
        decreaseRunSpeed = c.BASE_RUN_SPEED * 0.15f * level;
        if (c.getEquippedShield() == this) c.updateWeaponStats();
    }
}
