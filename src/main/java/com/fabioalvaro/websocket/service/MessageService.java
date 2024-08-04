package com.fabioalvaro.websocket.service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.fabioalvaro.websocket.chat.Greeting;
import com.google.gson.Gson;

@Service
public class MessageService {

    @Autowired
    private SimpMessagingTemplate template;

    private final Gson gson = new Gson();

      public static String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Gera um número entre 1 e 100
        double dividedNumber = randomNumber / 1000.0;
        return String.valueOf(dividedNumber); // Converte o número para String e retorna
    }
    

    @Scheduled(fixedRate = 500)
    public void sendMessage() {
        String message = generateRandomNumber();
        Greeting greeting =  new Greeting("Hello, " + message);
        template.convertAndSend("/topic/greetings", greeting);

        // Cria o objeto Map com os campos nome e idade
        Map<String, Object> personMap = new HashMap<>();
        personMap.put("nome", "John Doe");
        personMap.put("idade", 30);
      //  String personJson = objectMapper.writeValueAsString(personMap);
       // Converte o Map para JSON
        String personJson = gson.toJson(personMap);

        template.convertAndSend("/topic/public", personJson);
    }
}