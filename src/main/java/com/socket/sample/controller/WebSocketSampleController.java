package com.socket.sample.controller;

import com.socket.sample.common.MessageResponse;
import com.socket.sample.common.MessageSample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebSocketSampleController {

    /**
     *
     * @return
     */
    @MessageMapping("info")
    @SendTo("/subscribe/green/sample")
    public MessageResponse sendMessage2(MessageSample message) {
        log.info("#### DATA :::: MessageSample {}", message);

        /**
         * 로직 작성 후 응답구조생성
         */
        return new MessageResponse("to", "from", "200", "return");
    }

    /**
     * Exception Handle
     * @param exception
     * @return
     */
    @MessageExceptionHandler
    @SendTo("/subscribe/green/sys/errors")
    public String handleException(Throwable exception) {
        log.error("error : {}", exception);
        return exception.getMessage();
    }
}
