package br.com.fabioalvaro.pocwebsocket1.controllers;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;




@Controller
public class SocketController {

    @MessageMapping("/topico-geral")
    @SendTo("/topico-geral")
    public String sendCommand(@Payload String message) {
        // Logic to send the command to the WebSocket topic
        // Implement your code here
        System.out.println("Mensagem recebida: " + message);
        return message;
    }

    @MessageMapping("/hello")
    @SendTo("/hello")
    public String greeting(String message) throws Exception {
        System.out.println("/hello: " + message);
        return "Hello, " + message + "!";
    }

    @MessageMapping("/hello-json")
    @SendTo("/hello")
    public String greetingJson(@Payload MyJsonMessage jsonMessage) {
        String message = jsonMessage.getMessage();
        System.out.println("/hello-json: " + message);
        return "Hello, " + message + "!";
    }


    @MessageMapping("/greetings")
    @SendToUser("/queue/greetings")
    public String reply(@Payload String message,
    Principal user) {
    return  "Hello " + message;
    }


}
