package com.example.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {

    public void start(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(8000);
            while(true){
                System.out.println("채팅 프로그램 시작");
                socket = serverSocket.accept();

                RecieveThread recieveThread = new RecieveThread(socket);
                recieveThread.run();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class RecieveThread extends Thread{
    static List<PrintWriter> list =
            Collections.synchronizedList(new ArrayList<PrintWriter>());
    Socket socket = null;
    BufferedReader br = null;
    PrintWriter pw = null;

    public RecieveThread(Socket socket){
        this.socket = socket;
        try{
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        String name = "";
        try{
            name = br.readLine();
            System.out.println("["+name+"] 새 연결 생성");
            sendAll("["+name+"]님이 들어왔습니다");

            while(br != null){
                String inputMsg = br.readLine();
                if("quit".equals(inputMsg)) break;
                sendAll(name + ">>" + inputMsg);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            sendAll("["+name+"]님이 나갔습니다");
            list.remove(pw);
            try{
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void sendAll(String str){
        for(PrintWriter out : list){
            out.println(str);
            out.flush();
        }
    }
}
