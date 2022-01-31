package com.PutawanDE.OOP_LabF03;

public class TeamThread extends Thread {
    private final int NUM_TEAM_MATES = 4;
    private final String teamName;
    private float teamTime;

    public TeamThread(String name) {
        this.teamName = name;
    }

    public float getTeamTime() {
        return teamTime;
    }

    public String getTeamName() {
        return teamName;
    }

    public void run() {
        for (int i = 0; i < NUM_TEAM_MATES; i++) {
            float swimmerTime = (float) (Math.random() * 100.0f);
            teamTime += swimmerTime;
            System.out.println(teamName + ": swimmer " + (i + 1) +
                    " time: " + swimmerTime + " lap: " + teamTime);
        }
    }
}
