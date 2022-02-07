package com.PutawanDE.OOP_LabF04;

import java.net.InetAddress;
import java.net.Socket;

public class LabF04 {
    public static void main(String[] args) {
        Socket s;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
            System.out.println();

            int count = 0;
            for (int i = 1; i <= 65535; i++) {
                try {
                    s = new Socket("127.0.0.1", i);
                    System.out.println("Port Open: " + i);
                    count++;
                } catch (Exception ignored) {
                }
            }
            System.out.println("Total: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
