package com.beauty1nside.chat.service;

import com.beauty1nside.chat.dto.MessageDTO;
import com.beauty1nside.chat.dto.RoomDTO;
import com.beauty1nside.hr.dto.EmpDTO;

import java.util.List;

public interface ChatService {
  List<EmpDTO> empList(Long companyNum);
  
  List<MessageDTO> startChat(RoomDTO roomDTO);
}
