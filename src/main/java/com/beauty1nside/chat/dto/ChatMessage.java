package com.beauty1nside.chat.dto;

import lombok.Data;

@Data
public class ChatMessage {
  private String content;
  private String sender;
  private Long senderEmpNum;
//  private MessageType type;
//
//  public enum MessageType {
//    CHAT,
//    JOIN,
//    LEAVE
//  }
}
