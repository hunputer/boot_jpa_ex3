package com.example.api.controller;

import com.example.api.util.ChatClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("InChat")
    public void chatInput(){
        ChatClient client = new ChatClient();
        client.start();
    }



}
