package com.spring.ai.service;

import jakarta.annotation.Resources;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatServiceImpl implements Chatservice {


    @Autowired
    @Qualifier("aibean")
    public ChatClient chatClient;


    @Value("classpath:/prompt/userPrompt.st")
    private Resource userMessage;

    @Value("classpath:/prompt/systemPrompt.st")
    private Resource systemMessage;





    @Override
    public Flux<String> ChatTemplate(String query, String userId) {



        return chatClient
                .prompt(query)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,userId))
                .user(usr->usr.text(userMessage).param("concept",query))
                .system(systemMessage)
                .stream()
                .content();

    }
}
