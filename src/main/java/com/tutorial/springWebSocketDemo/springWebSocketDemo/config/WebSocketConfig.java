package com.tutorial.springWebSocketDemo.springWebSocketDemo.config;

import com.tutorial.springWebSocketDemo.springWebSocketDemo.Handler.DemoWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig  implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getWebSocketHandler(),"/stocks").setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler getWebSocketHandler(){
        return new DemoWebSocketHandler();
    }
}
