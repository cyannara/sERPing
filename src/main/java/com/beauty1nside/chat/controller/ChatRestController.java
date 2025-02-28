package com.beauty1nside.chat.controller;

import com.beauty1nside.chat.dto.MessageDTO;
import com.beauty1nside.chat.dto.RoomDTO;
import com.beauty1nside.chat.service.ChatService;
import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.security.service.CustomerUser;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
  
  @GetMapping("/start/{employeeNum}")
  public Map<Long, List<MessageDTO>> startChat(@PathVariable(name="employeeNum") Long employeeNum,
                                               @AuthenticationPrincipal CustomerUser user) {
    RoomDTO roomDTO = new RoomDTO();
    roomDTO.setCompanyNum(user.getUserDTO().getCompanyNum());
    roomDTO.setEmployeeNum1(user.getUserDTO().getEmployeeNum());
    roomDTO.setEmployeeNum2(employeeNum);
    
    return chatService.startChat(roomDTO);
  }
  
  @PostMapping("/msg")
  public ResponseEntity<Map<String, Object>> sendMsg(@RequestBody MessageDTO messageDTO,
                                                     @AuthenticationPrincipal CustomerUser user) {
    messageDTO.setEmployeeNum(user.getUserDTO().getEmployeeNum());
    
    MessageDTO dto = chatService.sendMsg(messageDTO);
    Map<String, Object> response = new HashMap<>();
    response.put("data", dto);
    return ResponseEntity.ok(response);
  }
}
