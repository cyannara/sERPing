package com.beauty1nside.chat.controller;

import com.beauty1nside.chat.dto.MessageDTO;
import com.beauty1nside.chat.dto.RoomDTO;
import com.beauty1nside.chat.service.ChatService;
import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.security.service.CustomerUser;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/chat/*")
public class ChatRestController {
  final ChatService chatService;
  
  @GetMapping("/employees")
  public List<EmpDTO> getEmpList(@AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    return chatService.empList(companyNum);
  }
  
  @PostMapping("/start")
  public Map<Long, List<MessageDTO>> startChat(@RequestBody EmpDTO empDTO,
                                               @AuthenticationPrincipal CustomerUser user) {
    RoomDTO roomDTO = new RoomDTO();
    roomDTO.setCompanyNum(user.getUserDTO().getCompanyNum());
    roomDTO.setEmployeeNum1(user.getUserDTO().getCompanyNum());
    roomDTO.setEmployeeNum2(empDTO.getEmployeeNum());
    
    return chatService.startChat(roomDTO);
  }
}
