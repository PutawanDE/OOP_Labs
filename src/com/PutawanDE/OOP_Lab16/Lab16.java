package com.PutawanDE.OOP_Lab16;

public class Lab16 {
    public static void main(String[] args) {
        TwitterFeed feed = new TwitterFeed();
        Observer<String> followerA = new FollowerA();
        Observer<String> followerB = new FollowerB();
        Observer<String> followerC = new FollowerC();

        feed.subscribe(followerA);
        feed.subscribe(followerB);
        feed.subscribe(followerC);

        feed.tweet("Hello World!!");
        System.out.println();
        feed.tweet("Good morning");
        System.out.println();
        feed.tweet("Have a nice day");
        System.out.println();
    }
}
