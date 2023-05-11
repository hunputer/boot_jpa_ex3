package com.example.api.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public void start(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(8000);
            while(true){

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class RecieveThread extends Thread{

}
