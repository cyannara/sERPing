package com.beauty1nside.chat.service.impl;

import com.beauty1nside.chat.dto.MessageDTO;
import com.beauty1nside.chat.dto.RoomDTO;
import com.beauty1nside.chat.mapper.ChatMapper;
import com.beauty1nside.chat.service.ChatService;
import com.beauty1nside.hr.dto.EmpDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<Long, List<MessageDTO>> returnValue = new HashMap<>();
    
    log.info("startChat dto={}", dto);
    
    if (dto == null) {
      try {
        Long roomId = chatMapper.insertChatRoom(roomDTO);
        
        return returnValue.put(roomId, List.of());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    } else {
      log.info("dto.getRoomId(){}", dto.getRoomId());
      log.info("returnValue={}", returnValue.put(dto.getRoomId(), chatMapper.getMsgList(dto.getRoomId())));
      return returnValue.put(dto.getRoomId(), chatMapper.getMsgList(dto.getRoomId()));
    }
  }
}
