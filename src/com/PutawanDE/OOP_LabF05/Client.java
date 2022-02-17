package com.PutawanDE.OOP_LabF05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        try (Socket socket = new Socket("localhost", port)) {
            InetAddress ip = InetAddress.getLocalHost();
            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            String ip_port = "IP address: " + ip.getHostAddress() + " Port: " + port;
            pr.println(ip_port);
            pr.println(ip.getHostName());
            pr.flush();

            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            String receive = bf.readLine();
            System.out.println("Server: " + receive);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
