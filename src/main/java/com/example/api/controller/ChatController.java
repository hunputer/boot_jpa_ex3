package com.example.api.controller;

import com.example.api.util.ChatClient;
import com.example.api.util.SendThread;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {

    ChatClient client = null;

    @GetMapping("inChat")
    public void chatInput(){
        client = new ChatClient();
        client.start();
    }

    @GetMapping("chatting")
    @ResponseBody
    public void chatting(Model model){
        client.getSendThread().setChatContent((String)model.getAttribute("chatContents"));
    }



}
