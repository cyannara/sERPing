package com.beauty1nside.chat.mapper;

import com.beauty1nside.chat.dto.MessageDTO;
import com.beauty1nside.chat.dto.RoomDTO;
import com.beauty1nside.hr.dto.EmpDTO;

import java.util.List;

public interface ChatMapper {
  List<EmpDTO> empList(Long companyNum);
  RoomDTO getChatRoom(RoomDTO roomDTO);
  Long insertChatRoom(RoomDTO roomDTO);
  List<MessageDTO> getMsgList(Long roomId);
  void insertMsg(MessageDTO messageDTO);
  MessageDTO getMsgJustSent(Long roomId);
  
}
