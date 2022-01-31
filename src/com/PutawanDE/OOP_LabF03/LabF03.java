package com.PutawanDE.OOP_LabF03;

public class LabF03 {
    public static void main(String[] args) throws InterruptedException {
        TeamThread team1 = new TeamThread("team 1");
        TeamThread team2 = new TeamThread("team 2");
        TeamThread team3 = new TeamThread("team 3");

        team1.setDaemon(true);
        team2.setDaemon(true);
        team3.setDaemon(true);

        team1.start();
        team2.start();
        team3.start();

        team1.join();
        team2.join();
        team3.join();
        System.out.println("-----------------------------------");

        TeamThread gold = team1;
        TeamThread silver = team2;
        TeamThread bronze = team3;

        if (bronze.getTeamTime() < silver.getTeamTime()) {
            TeamThread temp = silver;
            silver = bronze;
            bronze = temp;
        }

        if (silver.getTeamTime() < gold.getTeamTime()) {
            TeamThread temp = gold;
            gold = silver;
            silver = temp;
        }

        if (silver.getTeamTime() > bronze.getTeamTime()) {
            TeamThread temp = bronze;
            bronze = silver;
            silver = temp;
        }

        System.out.println("Gold Medal: " + gold.getTeamName() + " time: " + gold.getTeamTime() +
                " win by " + (silver.getTeamTime() - gold.getTeamTime()) + " seconds");
        System.out.println("Silver Medal: " + silver.getTeamName() + " time: " + silver.getTeamTime() +
                " win by " + (bronze.getTeamTime() - silver.getTeamTime()) + " seconds");
        System.out.println("Bronze Medal: " + bronze.getTeamName() + " time: " + bronze.getTeamTime());
    }
}
