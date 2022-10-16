package com.socket.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GreenChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
        log.info("#### preSend message : {}", message);
        if (StompCommand.CONNECT.equals(headerAccessor.getCommand())) {

            log.info("#### preSend Authorization : {}", headerAccessor.getNativeHeader("Authorization"));
            log.info("connected ");
            // TODO -  JWT 검증
        }
        return message;
    }
}
