package com.PutawanDE.OOP_LabF05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendResponseThread extends Thread {
    private Socket socket;

    public SendResponseThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            String ip_port = bf.readLine();
            String name = bf.readLine();
            System.out.println("Client: " + ip_port + " from " + name);


            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println("Received with thanks_" + name);
            pr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
