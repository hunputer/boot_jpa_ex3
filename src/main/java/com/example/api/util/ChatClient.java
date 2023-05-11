package com.example.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {
    private SendThread sendThread = null;

    public SendThread getSendThread() {
        return sendThread;
    }

    public void setSendThread(SendThread sendThread) {
        this.sendThread = sendThread;
    }

    public void start(){
        Socket socket = null;
        BufferedReader in = null;

        try{
            socket = new Socket("localhost", 8000);

            String name = "user" + (int)(Math.random()*10);
            sendThread = new SendThread(socket, name);
            sendThread.start();

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
