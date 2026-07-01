package com.spring.ai.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DataTransformerImpl implements DataTransformer{


    @Override
    public List<Document> transformer(List<Document> documentList) {

        TokenTextSplitter tokenTextSplitter = new TokenTextSplitter(300, 400, 10, 5000, true);

        return tokenTextSplitter.transform(documentList);
    }
}
