package com.beauty1nside.chat.controller;

import com.beauty1nside.chat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
//  클라이언트가 /app/chat.sendMessage로 메시지를 보내면 실행됨.
  @MessageMapping("/chat.sendMessage/{roomId}")
//  받은 메시지를 /topic/public을 구독 중인 모든 사용자에게 전달
  @SendTo("/topic/public/{roomId}")
  public ChatMessage sendMessage(@DestinationVariable String roomId,
                                 @Payload ChatMessage chatMessage) {
     return chatMessage;
  }
  
  @MessageMapping("/chat.addUser/{roomId}")
  @SendTo("/topic/public/{roomId}")
  public ChatMessage addUser(@DestinationVariable String roomId,
                             @Payload ChatMessage chatMessage,
                             SimpMessageHeaderAccessor headerAccessor) {
    // 사용자 이름을 세션에 저장
    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    return chatMessage;
  }
  
  @GetMapping("/chat")
  public String chat() {
    return "/chat";
  }
}

