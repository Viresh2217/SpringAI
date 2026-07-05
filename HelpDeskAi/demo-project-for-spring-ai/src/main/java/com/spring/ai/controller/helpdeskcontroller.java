package com.spring.ai.controller;

import com.spring.ai.service.helpDeskservice;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class helpdeskcontroller {

    @Autowired
    ChatClient chatClient;

    @Autowired
    helpDeskservice helpDeskservice;

    @PostMapping("/ai/chatboat")
    public ResponseEntity<String> getResponcefromModel(@RequestBody String query, @RequestHeader("ConversationId") String conversationId){
       return ResponseEntity.ok(helpDeskservice.getResponceFromAssistant(query, conversationId));
    }





}
