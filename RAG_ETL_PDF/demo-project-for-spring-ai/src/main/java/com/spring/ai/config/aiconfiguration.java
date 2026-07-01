package com.spring.ai.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


//
@Configuration
public class aiconfiguration {

//    @Bean
//    public VectorStore vectorStore(DataSource dataSource, EmbeddingModel embeddingModel) {
//        return new MariaDbVectorStore(dataSource, embeddingModel);
//    }
////
//
//
//     private Logger logger = LoggerFactory.getLogger(aiconfiguration.class);
//
//
////    @Bean
////    public ChatMemory chatMemory(JdbcChatMemoryRepository jdbcChatMemoryRepository){
////        logger.info("chatMemory called {}",ChatMemory.class);
////        return MessageWindowChatMemory.builder().chatMemoryRepository(jdbcChatMemoryRepository).build();
////    }
//
//
////    @Bean
////    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
////        return new JdbcTemplate(dataSource);
////    }
//
//
//
////    @Bean
////    @Qualifier("aibean")
////    public ChatClient chatClient(ChatClient.Builder builder) {
////
////       // MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
////
////        return builder
////                .build();
////    }
//
////    @Bean
////    public ChatMemory chatMemory() {
////        InMemoryChatMemoryRepository inMemoryChatMemoryRepository = new InMemoryChatMemoryRepository();
////        return MessageWindowChatMemory.builder().maxMessages(10).chatMemoryRepository(inMemoryChatMemoryRepository).build();
////    }
//
////    @Bean
////    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
////
////        this.logger.info("ChatMemoryImplementation class: " + chatMemory.getClass().getName());
////        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
////        return builder
////                .defaultAdvisors(messageChatMemoryAdvisor, new SimpleLoggerAdvisor())
////                .defaultOptions(OllamaChatModel.builder().modelManagementOptions( ModelManagementOptions.builder()..build()))
//////                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
////                .defaultOptions(OpenAiChatOptions.builder()
////                        .model("codellama:latest")
////                        .temperature(0.7)
////                        .maxTokens(200)
////                        .build())
////                .build();
////    }
//
//
//
//
//    // Embedding client for vectorization
////    @Bean
////    @Qualifier("embeddingClient")
////    public EmbeddingClient embeddingClient(OpenAiEmbeddingClient.Builder builder) {
////        return builder
////                .defaultOptions(OpenAiEmbeddingOptions.builder()
////                        .model("llama-3.1-8b-instant")
////                        .build())
////                .build();
////    }
//
//

//    @Bean
//    public VectorStore vectorStore(DataSource dataSource, EmbeddingModel embeddingModel) {
//        // JdbcVectorStore works with any JDBC database, including MariaDB
//        return new JdbcVectorStore(dataSource, embeddingModel);
//    }
}

