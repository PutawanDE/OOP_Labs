package com.PutawanDE.OOP_Lab05;

public abstract class AccessoryImpl implements Accessory {
    protected CharacterImpl owner;
    protected String name;

    private final String type;

    public int level;

    public AccessoryImpl(String name, CharacterImpl owner, String type) {
        this.name = name;
        this.owner = owner;
        this.level = 1;
        this.type = type;
    }

    @Override
    public void upLevel(CharacterImpl upgrader) {
        if (!owner.getIsDead()) {
            if (upgrader == owner) {
                float lostMana = upgrader.getMaxMana() * 0.6f;
                if (upgrader.useMana(lostMana)) {
                    level++;
                    System.out.println("\n" + upgrader.getName() + " upgraded sword " + name + " to Lv." + level +
                            " with " + lostMana + " mana");
                }
            }
        }
    }

    @Override
    public void getStat() {
        System.out.println("Type: " + type + "Name/Lv.: " + name + "/" + level + " | Owner: " + owner.getName());
    }

    public boolean checkOwnership(CharacterImpl characterToCheck) {
        return characterToCheck == owner;
    }
    
    public abstract void activate(CharacterImpl opp, CharacterImpl wearer);
}
