package com.markedline.textworker.server;

import com.markedline.textworker.exchange.UserRequestHandler;
import com.markedline.textworker.exchange.impl.UserRequestHandlerImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private final Socket socket;
    private final UserRequestHandler handler = new UserRequestHandlerImpl();
    private ObjectInputStream reader = null;
    private ObjectOutputStream writer = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    private void close() throws IOException {
        if (socket != null) socket.close();
        if (reader != null) reader.close();
        if (writer != null) writer.close();
    }

    public void open() throws IOException {
        reader = new ObjectInputStream(socket.getInputStream());
        writer = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                handler.handle(reader, writer);
            }
        } catch (Exception e) {
            System.out.println("Internal server exception: " + e.getMessage());
        } finally {
            try {
                close();
            } catch (IOException e) {
                System.out.println("Error closing socket/reader/writer: " + e.getMessage());
            }
        }
    }
}
