package com.PutawanDE.OOP_Lab16;

public class FollowerC implements Observer<String> {
    @Override
    public void notify(String message) {
        System.out.println("New tweet for Follower C: " + message);
        System.out.println("Follower C replied, สาธุุ");
        System.out.println("-------------------------------------");
    }
}
