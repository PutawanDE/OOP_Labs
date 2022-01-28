package com.PutawanDE.OOP_LabF02;

public class PingHostThread extends PingHost implements Runnable {
    private int threadNum;

    public PingHostThread(String host, int port, int timeout, int threadNum) {
        super(host, port, timeout);
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        System.out.println("PingHostThread Number: " + threadNum + " start ping: " + host + " " + port);
        if (startPing()) {
            System.out.println("PingHostThread Number: " + threadNum + " " + host + " " + port + " is available.");
        } else {
            System.out.println("PingHostThread Number: " + threadNum + " " + host + " " + port + " is not reachable.");
        }
    }
}
