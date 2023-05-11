package com.example.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SendThread extends Thread{
    private String chatContent;

    Socket socket = null;

    BufferedReader br = null;
    String name;

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public SendThread(Socket socket, String name){
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run(){
        try{
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println(name);
            out.flush();

            while(true){
                String outputMsg = getChatContent();
                if(outputMsg != null && "".equals(outputMsg)){
                    out.println(outputMsg);
                    out.flush();
                    if("quit".equals(outputMsg))break;
                    outputMsg = "";
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
