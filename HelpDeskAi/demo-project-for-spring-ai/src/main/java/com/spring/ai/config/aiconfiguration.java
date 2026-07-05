package com.spring.ai.config;

import com.spring.ai.tool.HelpDeskTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class aiconfiguration {

    Logger LOGGER= LoggerFactory.getLogger(aiconfiguration.class);

    @Autowired
    private HelpDeskTool helpDeskTool;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, JdbcChatMemoryRepository jdbcChatMemoryRepository){

        var chatMemory= MessageWindowChatMemory.builder()
                .chatMemoryRepository(jdbcChatMemoryRepository)
                .maxMessages(15)
                .build();
        LOGGER.info("ChatClient bean created.");
        LOGGER.info("chat memory bean created. {}", chatMemory.getClass().getName());
        return builder
                .defaultTools(helpDeskTool)
                .defaultSystem("Summerize the response within 400 words.")
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultOptions(ChatOptions.builder().model("gpt-4o-mini").temperature(0.7).build())
                .build();


    }


}
