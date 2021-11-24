package com.PutawanDE.OOP_Lab05;

public class CrystalImpl extends AccessoryImpl implements Crystal {
    private final float BASE_DEFENSE = 20f;

    public CrystalImpl(String name, CharacterImpl owner) {
        super(name + " Crystal", owner, "Crystal");
    }

    @Override
    public void activate(CharacterImpl opp, CharacterImpl wearer) {
        protect(opp, wearer);
    }

    @Override
    public void protect(CharacterImpl opp, CharacterImpl wearer) {
        if (opp.orgCharType.equals("Mage")) {
            wearer.setDefense(20f);
        }
    }
}
