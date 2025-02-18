package com.beauty1nside.mainpage.controller;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;
import com.beauty1nside.mainpage.service.ApprovalService;
import com.beauty1nside.security.service.CustomerUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/mainpage/rest/*")
public class MainpageRestController {
  final ApprovalService approvalService;
  
  @GetMapping("/approval/list")
  public Object approvalList(@RequestParam(name = "perPage", defaultValue = "10", required = false) int perPage,
                             @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                             ApprovalSearchDTO dto,
                             Paging paging,
                             @AuthenticationPrincipal CustomerUser user) throws JsonProcessingException {
    
    paging.setPageUnit(perPage);
    paging.setPage(page);
    
    dto.setStart(paging.getFirst());
    dto.setEnd(paging.getLast());
    
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
  
  @GetMapping("/approval/{id}/process/{processStr}")
  public int processApproval(@PathVariable("id") Long approvalId,
                                     @PathVariable("processStr") String processStr,
                                        @AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    log.info("approvalService.update(approvalId, processStr, companyNum): {}", approvalService.update(approvalId, processStr, companyNum));
    return approvalService.update(approvalId, processStr, companyNum);
  }
  
}
