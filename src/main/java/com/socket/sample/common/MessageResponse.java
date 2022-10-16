package com.socket.sample.common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter @ToString
public class MessageResponse {
    private String to;
    private String from;
    private String status;
    private String message;
}
