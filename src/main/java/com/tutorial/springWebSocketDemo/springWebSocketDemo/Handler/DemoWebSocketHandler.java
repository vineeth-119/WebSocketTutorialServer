package com.tutorial.springWebSocketDemo.springWebSocketDemo.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.springWebSocketDemo.springWebSocketDemo.Entity;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class DemoWebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    private Random r = new Random();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        float oldPrice=0.0f;
        for(int i=0;i<500;i++){
            float currentPrice = 12+r.nextFloat();
            float roundPrice  = (float)(Math.round(currentPrice*100.00)/100.00);
            Entity et = new Entity("Amazon",roundPrice,"https://cdn.cdnlogo.com/logos/a/77/amazon-dark.svg");
            if(roundPrice>oldPrice){
                et.setIncrease(true);
            }
            oldPrice = roundPrice;

            TextMessage msg = new TextMessage(objectMapper.writeValueAsString(et));
            session.sendMessage(msg);
            Thread.sleep(1000);
        }
        sessions.add(session);

    }

}
