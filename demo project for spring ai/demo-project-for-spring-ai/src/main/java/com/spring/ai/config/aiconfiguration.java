package com.spring.ai.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.openai.OpenAiChatOptions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class aiconfiguration {


    @Bean
    public ChatMemory chatMemory(JdbcChatMemoryRepository jdbcChatMemoryRepository){
        return MessageWindowChatMemory.builder().chatMemoryRepository(jdbcChatMemoryRepository).build();
    }





    @Bean
    @Qualifier("aibean")
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {

        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

        return builder.defaultAdvisors(new SimpleLoggerAdvisor(),messageChatMemoryAdvisor)
                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
                .defaultOptions(OpenAiChatOptions.builder().temperature(0.3).model("qwen/qwen3-32b"))
                .build();
    }




}

