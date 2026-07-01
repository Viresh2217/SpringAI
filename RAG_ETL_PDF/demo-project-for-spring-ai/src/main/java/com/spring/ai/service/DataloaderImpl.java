package com.spring.ai.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.JsonReader;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DataloaderImpl implements Dataloader {

     @Value("classpath:sample_data.json")
     private Resource Jsonresource;

     @Value("classpath:sportDetails.pdf")
     private Resource pdfresource;





    @Override
    public List<Document> loadDocumentFromJson() {

        JsonReader jsonReader = new JsonReader(Jsonresource, "project");
        return jsonReader.read();
    }

    @Override
    public List<Document> loadDocumentFromPdf() {

        PagePdfDocumentReader pdfDocumentReader = new PagePdfDocumentReader(pdfresource, PdfDocumentReaderConfig.builder()
                .withPageTopMargin(0).withPageExtractedTextFormatter(ExtractedTextFormatter.builder().withNumberOfTopTextLinesToDelete(0).build()).build());


        return pdfDocumentReader.read();
    }
}
