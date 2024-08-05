package com.fabioalvaro.websocket.chat;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;


@RestController
@RequestMapping("/comando")
public class ComandoController {
       @Autowired
    private SimpMessagingTemplate template;

    @PostMapping("/send")
    public void sendGreeting(@RequestBody HelloMessage message) {

        String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        
        Greeting greeting =  new Greeting(timestamp,"Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");

        template.convertAndSend("/topic/greetings", greeting);
       
    }
}
