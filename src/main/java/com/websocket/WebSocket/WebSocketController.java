package com.websocket.WebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebSocketController {

    @Autowired private TopicosRepository tRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Iterable<Topicos> greeting(Topicos msg) {
        tRepository.save(msg);
        return tRepository.findAll();
    }

    @MessageMapping("/resposta")
    @SendTo("/topic/greetings")
    public Iterable<Topicos> resp() {
        return tRepository.findAll();
    }
}
