package com.spring.ai.service;

import org.springframework.ai.document.Document;

import java.util.List;

public interface DataTransformer {

 List<Document> transformer(List<Document> documentList);


}
