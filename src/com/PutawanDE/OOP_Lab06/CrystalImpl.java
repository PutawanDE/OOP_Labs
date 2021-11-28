package com.PutawanDE.OOP_Lab06;

public class CrystalImpl extends AccessoryImpl implements Crystal {
    private final float BASE_DEFENSE = 20f;

    /**
     * Create a new Crystal
     *
     * @param name  name of this crystal
     * @param owner Character who owns this
     */
    public CrystalImpl(String name, CharacterImpl owner) {
        super(name + " Crystal", owner, "Crystal");
    }

    @Override
    public void activate(CharacterImpl opp, CharacterImpl wearer) {
        if (checkOwnership(wearer)) {
            protect(opp, wearer);
        }
    }

    @Override
    public void protect(CharacterImpl opp, CharacterImpl wearer) {
        if (opp.orgCharType.equals("Mage")) {
            wearer.setDefense(BASE_DEFENSE);
        }
    }
}
