package com.spring.ai.service;

import com.spring.ai.tool.HelpDeskTool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class helpDeskServiceImpl implements helpDeskservice{

    @Autowired
   private ChatClient chatClient;

    @Autowired
   private HelpDeskTool helpDeskTool;


   @Value("classpath:/systemhelpdeskprmopt.st")
   private  Resource systemPrompt;


    @Override
    public String getResponceFromAssistant(String query, String conversationId) {

        return chatClient
                .prompt(query)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .tools(helpDeskTool)
                .system(systemPrompt)
                .user(query)
                .call()
                .content();
    }
}
