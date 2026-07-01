package com.spring.ai.config;

import com.spring.ai.service.Chatservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class APIController {

    @Autowired
    public Chatservice chatservice;

 //
   @GetMapping("/ai/chat")
   public ResponseEntity<Flux<String>> Aichatboat(@RequestParam(value = "q", required = true) String query, @RequestHeader("userID") String UserID){

       return ResponseEntity.ok(chatservice.ChatTemplate(query,UserID));

   }

   @GetMapping("/ai/rag")
    public ResponseEntity ChatBoat(@RequestParam(value="q") String query){
       return ResponseEntity.ok(chatservice.ChatTemplateRag(query));
   }
    @GetMapping("/ai/vectordb")
    public ResponseEntity ChatBoatvectorBody(){
        return ResponseEntity.ok(chatservice.saveDataToVectorDb());
    }

}
