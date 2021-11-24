package com.PutawanDE.OOP_Lab05;

public interface Assassin extends Character {
    void disguise(CharacterImpl opp);
    void takeDown(CharacterImpl opp, float posX, float posY);
    void distract();
    void vision(CharacterImpl opp);
}
