package com.PutawanDE.OOP_LabF05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        ServerSocket ss;
        Socket socket;

        try {
            ss = new ServerSocket(port);
            while (true) {
                socket = ss.accept();
                new Thread(new SendResponseThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
