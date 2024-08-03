package br.com.fabioalvaro.pocwebsocket1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import br.com.fabioalvaro.pocwebsocket1.websocket.ServerWebSocketHandler;


@Configuration

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry.addHandler(webSocketHandler(), "/websocket");    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new ServerWebSocketHandler();
    }

    

    // @Override
    // public void registerStompEndpoints(StompEndpointRegistry registry) {
    //     System.out.println("===================================");
    //     System.out.println(" [registry]Configurando");
    //     System.out.println(registry);
    //     registry.addEndpoint("/websocket");
    
    //     System.out.println("===================================");
    // }


    // @Override
    // public void configureMessageBroker(MessageBrokerRegistry config) {
    //     System.out.println("===================================");
    //     System.out.println(" [config] CONECTANDO NO WEBSOCKET");
    //     System.out.println(" /app/topico-geral");
    //     System.out.println(config);
    //     //canais que estou disponibilizando....
    //     config.setApplicationDestinationPrefixes("/app");
    //     config.enableSimpleBroker("/topico-geral","/banana123");
   
    // }


    
}