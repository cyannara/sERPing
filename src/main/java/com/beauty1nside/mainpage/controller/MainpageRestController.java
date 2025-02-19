package com.beauty1nside.mainpage.controller;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;
import com.beauty1nside.mainpage.dto.DocumentDTO;
import com.beauty1nside.mainpage.service.ApprovalService;
import com.beauty1nside.security.service.CustomerUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/mainpage/rest/*")
public class MainpageRestController {
  final ApprovalService approvalService;
  
  @GetMapping("/approval/list")
  public Object approvalList(@RequestParam(name = "perPage", defaultValue = "20", required = false) int perPage,
                             @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                             ApprovalSearchDTO dto,
                             Paging paging,
                             @AuthenticationPrincipal CustomerUser user) throws JsonProcessingException {
    
    paging.setPageUnit(perPage);
    paging.setPage(page);
    
    dto.setStart(paging.getFirst());
    dto.setEnd(paging.getLast());
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    if(dto.getInApprovalRequestDateStart() != null && !dto.getInApprovalRequestDateStart().isEmpty()) {
      LocalDate startDate = LocalDate.parse(dto.getInApprovalRequestDateStart());
      LocalDateTime startOfDay = startDate.atStartOfDay();
      String formattedStartDate = startOfDay.format(formatter);
      dto.setInApprovalRequestDateStart(formattedStartDate);
    }
    
    if(dto.getInApprovalRequestDateEnd() != null && !dto.getInApprovalRequestDateEnd().isEmpty()) {
      LocalDate endDate = LocalDate.parse(dto.getInApprovalRequestDateEnd());
      LocalDateTime endOfDay = endDate.atTime(23, 59, 59);
      String formattedEndDate = endOfDay.format(formatter);
      dto.setInApprovalRequestDateEnd(formattedEndDate);
    }
    
    Long companyNum = user.getUserDTO().getCompanyNum();
    paging.setTotalRecord(approvalService.count(dto, companyNum));
    
    GridArray grid = new GridArray();
    
    return grid.getArray(paging.getPage(), approvalService.count(dto, companyNum), approvalService.waitingList(dto, companyNum));
  }
  
  @GetMapping("/approval/{id}")
  public ApprovalDTO getApprovalContent(@PathVariable("id") Long approvalId,
                                   @AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    return approvalService.info(approvalId, companyNum);
  }
  
  @PostMapping("/approval/{id}/process/{processStr}")
  public int processApproval(@PathVariable("id") Long approvalId,
                             @PathVariable("processStr") String processStr,
                             @RequestBody String reason,
                              @AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    return approvalService.update(approvalId, processStr, companyNum, reason);
  }
  
  @GetMapping("/approval/type")
  public List<DocumentDTO> getApprovalType(@AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    return approvalService.documentList(companyNum);
  }
  
}
