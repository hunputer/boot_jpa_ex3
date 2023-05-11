package com.example.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SendThread extends Thread{
    Socket socket = null;

    BufferedReader br = null;
    String name;

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
                String outputMsg = "a";
                out.println(outputMsg);
                out.flush();
                if("quit".equals(outputMsg))break;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
