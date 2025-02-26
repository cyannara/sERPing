package com.beauty1nside.chat.service.impl;

import com.beauty1nside.chat.dto.MessageDTO;
import com.beauty1nside.chat.dto.RoomDTO;
import com.beauty1nside.chat.mapper.ChatMapper;
import com.beauty1nside.chat.service.ChatService;
import com.beauty1nside.hr.dto.EmpDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
  private final ChatMapper chatMapper;
  
  @Override
  public List<EmpDTO> empList(Long companyNum) {
    return chatMapper.empList(companyNum);
  }
  
  @Override
  public List<MessageDTO> startChat(RoomDTO roomDTO) {
    RoomDTO dto = chatMapper.getChatRoom(roomDTO);

    if (dto == null) {
      try {
        int isInserted = chatMapper.insertChatRoom(roomDTO);
        if (isInserted == 1) {
          return List.of(); // return empty list(immutable)
        } else {
          log.error("fail to make new chat room");
          return null;
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }

    } else {
      return chatMapper.getMsgList(dto.getRoomId());
    }
  }
}
