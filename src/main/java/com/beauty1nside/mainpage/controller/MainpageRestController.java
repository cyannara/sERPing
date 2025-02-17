package com.beauty1nside.mainpage.controller;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;
import com.beauty1nside.mainpage.service.ApprovalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/mainpage/rest/*")
public class MainpageRestController {
  final ApprovalService approvalService;
  
  @GetMapping("/approval/list")
  public Object approvalList(@RequestParam(name = "perPage", defaultValue = "10", required = false) int perPage,
                             @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                             ApprovalSearchDTO dto, Paging paging) throws JsonProcessingException {
    
    paging.setPageUnit(perPage);
    paging.setPage(page);
    
    dto.setStart(paging.getFirst());
    dto.setEnd(paging.getLast());
    
    paging.setTotalRecord(approvalService.count(dto));
    
    GridArray grid = new GridArray();
    return grid.getArray(paging.getPage(), approvalService.count(dto), approvalService.list(dto));
  }
}
