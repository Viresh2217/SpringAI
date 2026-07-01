package com.spring.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.vectorstore.VectorStore;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements Chatservice {



    @Value("classpath:/prompt/userPrompt.st")
    private Resource userMessage;

    @Value("classpath:/prompt/systemPrompt.st")
    private Resource systemMessage;

    private  ChatClient chatClient;
    private  EmbeddingModel embeddingModel;
    private  VectorStore vectorStore;

    public ChatServiceImpl(ChatClient.Builder builder,
                           ChatMemory chatMemory,
                           VectorStore vectorStore,
                           EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
        this.vectorStore = vectorStore;
        this.chatClient = builder
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        QuestionAnswerAdvisor.builder(vectorStore).build(),
                        new SimpleLoggerAdvisor()
                )
                .build();
    }


    @Override
    public String saveDataToVectorDb() {
        List<String> list = Helper.getData();

        // Just wrap text into Document with metadata
        List<Document> documentList = list.stream()
                .map(text -> new Document(text, Map.of("source", "helper")))
                .toList();
        float[] vector = embeddingModel.embed("test");
        System.out.println("Embedding size: " + vector.length);
        // VectorStore will generate embeddings internally
        this.vectorStore.add(documentList);

        return "Data saved in table";
    }






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


    // Calling RAG with ETL(Extract--Transform--Load)
    @Override
    public String ChatTemplateRag(String query) {

        saveDataToVectorDb();

        var advisor= RetrievalAugmentationAdvisor.builder()
                .documentRetriever(VectorStoreDocumentRetriever.builder().vectorStore(this.vectorStore).topK(3).similarityThreshold(0.5).build())
                .queryAugmenter(ContextualQueryAugmenter.builder().allowEmptyContext(true).build())
                .build();

        return chatClient.prompt(query).advisors(advisor).user(usr->usr.text(userMessage)).call().content();
    }


}
