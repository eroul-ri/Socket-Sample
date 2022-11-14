package com.socket.sample.controller;

import com.socket.sample.common.MessageResponse;
import com.socket.sample.common.MessageSample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class WebSocketSampleController {

    /**
     * 샘플 응답 작성
     * @param message
     * @return
     */
    @MessageMapping("info")
    @SendTo("/subscribe/sample")
    public MessageResponse sendMessage(MessageSample message) {
        log.info("#### DATA :::: MessageSample {}", message);

        /**
         * 로직 작성 후 응답구조생성
         */
        return new MessageResponse("toUser", "fromUser", String.valueOf(HttpStatus.OK), "return", LocalDateTime.now());
    }
}
