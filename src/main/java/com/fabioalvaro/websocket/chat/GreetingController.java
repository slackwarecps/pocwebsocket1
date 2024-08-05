package com.fabioalvaro.websocket.chat;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception {
    String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    Thread.sleep(3000); // simulated delay
    return new Greeting(timestamp,"Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }
  

}