package com.PutawanDE.OOP_Lab05;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AssassinImpl extends CharacterImpl implements Assassin {
    private final String[] DISTRACTING_LINES = new String[]{
            "What's your favorite color?",
            "I'm behind you.",
            "You suck.",
            "I don't like sand.",
            "I am your father.",
            "I know your position.",
            "Hew Khao Laew"
    };

    private Random rand = new Random();

    public AssassinImpl(String name) {
        super(name, "Assassin");
    }

    @Override
    public void disguise(CharacterImpl opp) {
        if (isDead) return;

        super.currentCharType = opp.currentCharType;
        ScheduledExecutorService exec = new ScheduledThreadPoolExecutor(1);
        exec.schedule(() -> super.currentCharType = "Assassin", 30, TimeUnit.SECONDS);
    }

    @Override
    public void takeDown(CharacterImpl opp, float posX, float posY) {
        if (isDead) return;

        float xDiff = Math.abs(posX - opp.getPosX());
        float yDiff = Math.abs(posY - opp.getPosY());

        if (xDiff <= 2.0f && yDiff <= 2.0f) {
            opp.setDefense(0f);
            attack(opp, opp.getMaxHp());
        }
    }

    @Override
    public void distract() {
        if (isDead) return;

        System.out.println(DISTRACTING_LINES[rand.nextInt(DISTRACTING_LINES.length)]);
    }

    @Override
    public void vision(CharacterImpl opp) {
        if (isDead) return;

        System.out.println("Opponent Position: (" + opp.getPosX() + ", " + opp.getPosY() + ")");
    }
}
