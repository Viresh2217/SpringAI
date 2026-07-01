package com.spring.ai.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


public interface Chatservice {

    public Flux<String> ChatTemplate(String query, String userId);

    public String ChatTemplateRag(String query);

    public String saveDataToVectorDb();
}
