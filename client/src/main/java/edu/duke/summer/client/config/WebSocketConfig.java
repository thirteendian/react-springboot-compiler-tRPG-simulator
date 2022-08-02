package edu.duke.summer.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * A WebSocket Configuration for javascript Client in HTML
 * <p>
 *     Process:
 *     INPUT JSON -> OUTPUT JSON
 * <p>
 *     Process pair:
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //Broker Config
    //translate from sender to receiver
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //Return OUTPUT message destination, example: /topic/greetings
        config.enableSimpleBroker("/objectcreate");
        //The prefix of @MessageMapping in Controller, example: /app/hello as @MessageMapping(/hello)
        config.setApplicationDestinationPrefixes("/app");
    }

    //SockJS fallback Options, if WebSocket is not available
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }


}
