package com.PutawanDE.OOP_Lab06;

public abstract class AccessoryImpl implements Accessory {
    protected CharacterImpl owner;
    protected String name;

    private final String type;

    public int level;

    /**
     * Create a new accessory
     *
     * @param name  name of this accessory
     * @param owner Character who owns this accessory
     * @param type  type of this accessory: "Ring", or "Crystal"
     */
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

    /**
     * Check whether this accessory belongs to this character
     *
     * @param characterToCheck Character to be checked
     * @return true when this accessory is owned by characterToCheck
     */
    public boolean checkOwnership(CharacterImpl characterToCheck) {
        return characterToCheck == owner;
    }

    /**
     * Activate the accessory's action
     *
     * @param opp    opponent Character
     * @param wearer Character who is wearing this accessory
     */
    public abstract void activate(CharacterImpl opp, CharacterImpl wearer);
}
