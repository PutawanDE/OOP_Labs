package com.PutawanDE.OOP_Lab16;

public class FollowerB implements Observer<String> {
    @Override
    public void notify(String message) {
        System.out.println("New tweet for Follower B: " + message);
        System.out.println("Follower B replied, Glad ur alive.");
        System.out.println("-------------------------------------");
    }
}
