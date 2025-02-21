package com.beauty1nside.mainpage.controller;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;
import com.beauty1nside.stdr.dto.DocumentDTO;
import com.beauty1nside.mainpage.service.ApprovalService;
import com.beauty1nside.security.service.CustomerUser;
import com.beauty1nside.utils.DateTimeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
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
@RequestMapping("/api/mainpage/*")
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
    
    if(dto.getInApprovalRequestDateStart() != null && !dto.getInApprovalRequestDateStart().isEmpty()) {
      dto.setInApprovalRequestDateStart(DateTimeUtils.formatStartOfDay(dto.getInApprovalRequestDateStart()));
    }
    
    if(dto.getInApprovalRequestDateEnd() != null && !dto.getInApprovalRequestDateEnd().isEmpty()) {
      dto.setInApprovalRequestDateEnd(DateTimeUtils.formatEndOfDay(dto.getInApprovalRequestDateEnd()));
    }
    
    Long companyNum = user.getUserDTO().getCompanyNum();
    paging.setTotalRecord(approvalService.count(dto, companyNum));
    
    GridArray grid = new GridArray();
    
    return grid.getArray(paging.getPage(), approvalService.count(dto, companyNum), approvalService.waitingList(dto, companyNum));
  }
  
  @GetMapping("/approval/list/{employeeNum}")
  public Object approvalMyList(@PathVariable("employeeNum") Long employeeNum,
                              @RequestParam(name = "perPage", defaultValue = "20", required = false) int perPage,
                             @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                             ApprovalSearchDTO dto,
                             Paging paging,
                             @AuthenticationPrincipal CustomerUser user) throws JsonProcessingException {
    
    paging.setPageUnit(perPage);
    paging.setPage(page);
    
    dto.setStart(paging.getFirst());
    dto.setEnd(paging.getLast());
    
    if(dto.getInApprovalRequestDateStart() != null && !dto.getInApprovalRequestDateStart().isEmpty()) {
      dto.setInApprovalRequestDateStart(DateTimeUtils.formatStartOfDay(dto.getInApprovalRequestDateStart()));
    }
    
    if(dto.getInApprovalRequestDateEnd() != null && !dto.getInApprovalRequestDateEnd().isEmpty()) {
      dto.setInApprovalRequestDateEnd(DateTimeUtils.formatEndOfDay(dto.getInApprovalRequestDateEnd()));
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
  
  @PostMapping("/approval/process")
  public ResponseEntity<Map<String, Object>> processApproval(@RequestBody ApprovalDTO dto,
                                                             @AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    dto.setCompanyNum(companyNum);
    
    Map<String, Object> response = new HashMap<>();
    int isSuccess = approvalService.update(dto);
    response.put("message", isSuccess == 1 ? "success" : "fail");
    return ResponseEntity.ok(response);
  }
  
  @GetMapping("/approval/type")
  public List<DocumentDTO> getApprovalType(@AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    return approvalService.documentList(companyNum);
  }
  
}
