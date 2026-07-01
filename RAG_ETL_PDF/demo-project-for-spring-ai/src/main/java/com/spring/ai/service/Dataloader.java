package com.spring.ai.service;


import org.springframework.ai.document.Document;

import java.util.List;

public interface Dataloader {

    public List<Document> loadDocumentFromJson();

    public List<Document> loadDocumentFromPdf();


}
