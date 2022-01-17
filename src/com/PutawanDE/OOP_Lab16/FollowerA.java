package com.PutawanDE.OOP_Lab16;

public class FollowerA implements Observer<String> {
    @Override
    public void notify(String message) {
        System.out.println("New tweet for Follower A: " + message);
        System.out.println("Follower A replied, How are you today?");
        System.out.println("-------------------------------------");
    }
}
