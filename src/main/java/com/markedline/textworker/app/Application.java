package com.markedline.textworker.app;

import com.markedline.textworker.server.Server;

public class Application {
    public static void main(String[] args) {
        Server myServer = new Server(8000);
        myServer.start();
    }
}
