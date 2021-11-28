package com.PutawanDE.OOP_Lab06;

public interface Assassin extends Character {
    /**
     * effects: Temporarily Set the currentCharType field of this character
     * to opponent's currentCharType for 5 seconds
     * effects: print out "Disguise ended" after 5 seconds
     *
     * @param opp Character to be disguised as
     */
    void disguise(CharacterImpl opp);

    /**
     * If the opponent(opp) is within range (2.0 in x, y axes), kill them.
     * effects: attack the opponent with max damage
     * effects: no defense for the opponent
     *
     * @param opp  opponent to be taken down
     * @param posX x position of opp
     * @param posY y position of opp
     */
    void takeDown(CharacterImpl opp, float posX, float posY);

    /**
     * effects: print out random lines to distract other player
     */
    void distract();

    /**
     * effects: print out the opponent's position
     *
     * @param opp opponent whose location is wanted to be known
     */
    void vision(CharacterImpl opp);
}
