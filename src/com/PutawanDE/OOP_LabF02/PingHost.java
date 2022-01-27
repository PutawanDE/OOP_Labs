package com.PutawanDE.OOP_LabF02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingHost {
    protected String host;
    protected int port;
    protected int timeout;

    public PingHost(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    public boolean startPing() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
