package com.fabioalvaro.websocket.service;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.fabioalvaro.websocket.chat.Greeting;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class MessageService {

    @Autowired
    private SimpMessagingTemplate template;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Gson gson = new Gson();

      public static String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Gera um número entre 1 e 100
        double dividedNumber = randomNumber / 1000.0;
        return String.valueOf(dividedNumber); // Converte o número para String e retorna
    }
    

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        String message = generateRandomNumber();
        String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println("Sending message: " + message);
        System.out.println("Sending timestamp: " + timestamp);
        Greeting greeting =  new Greeting(timestamp, message);
        try {
          String greetingJson = objectMapper.writeValueAsString(greeting);
          template.convertAndSend("/topic/greetings", greetingJson);
        } catch (JsonProcessingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

      //  // template.convertAndSend("/topic/greetings", greeting);

      //   // Cria o objeto Map com os campos nome e idade
      //   Map<String, Object> personMap = new HashMap<>();
      //   personMap.put("timestamp", timestamp);
      //   personMap.put("content", message);
      // //  String personJson = objectMapper.writeValueAsString(personMap);
      //  // Converte o Map para JSON
      //  String personJson = gson.toJson(personMap);

      //  // template.convertAndSend("/topic/public", personJson);
      //  template.convertAndSend("/topic/greetings", personJson);
    }


}