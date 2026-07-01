package com.spring.ai.service;

import reactor.core.publisher.Flux;


public interface Chatservice {

     Flux<String> ChatTemplate(String query, String userId);

     String ChatTemplateRag(String query);

     String saveDataToVectorDb();

     void jsonDataloaderToDb();

     void pdfDataLoaderToDb();

}
