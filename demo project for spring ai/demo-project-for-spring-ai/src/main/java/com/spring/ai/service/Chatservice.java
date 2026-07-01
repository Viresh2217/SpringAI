package com.spring.ai.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


public interface Chatservice {

    public Flux<String> ChatTemplate(String query, String userId);
}
