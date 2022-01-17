package com.PutawanDE.OOP_Lab16;

import java.util.LinkedList;
import java.util.List;

public class TwitterFeed implements Observable<String> {
    private List<Observer<String>> followers = new LinkedList<>();

    @Override
    public void subscribe(Observer<String> observer) {
        followers.add(observer);
    }

    public void tweet(String message) {
        System.out.println("New tweet!! " + message);
        System.out.println("-------------------------------------");
        for (Observer<String> follower : followers) {
            follower.notify(message);
        }
    }
}
