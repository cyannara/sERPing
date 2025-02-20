package com.beauty1nside.stdr.controller;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.stdr.dto.DocumentDTO;
import com.beauty1nside.security.service.CustomerUser;
import com.beauty1nside.stdr.dto.DocumentSearchDTO;
import com.beauty1nside.stdr.service.StdrDeptService;
import com.beauty1nside.stdr.service.DocumentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/stdr/rest/*")
public class StdrRestController {
  final DocumentService documentService;
  final StdrDeptService stdrDeptService;
  
  @GetMapping("document")
  public Object getDocList(@RequestParam(name = "perPage", defaultValue = "20", required = false) int perPage,
                           @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                           DocumentSearchDTO dto,
                           Paging paging,
                           @AuthenticationPrincipal CustomerUser user) throws JsonProcessingException  {
    
    paging.setPageUnit(perPage);
    paging.setPage(page);
    
    dto.setStart(paging.getFirst());
    dto.setEnd(paging.getLast());
    
    Long companyNum = user.getUserDTO().getCompanyNum();
    dto.setCompanyNum(companyNum);
    paging.setTotalRecord(documentService.count(dto));
    
    GridArray grid = new GridArray();
    
    return grid.getArray(paging.getPage(), documentService.count(dto), documentService.documentList(dto));
  }
  
  @GetMapping("/document/{id}")
  public DocumentDTO getApprovalContent(@PathVariable("id") Long documentId,
                                        DocumentDTO dto,
                                        @AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    dto.setCompanyNum(companyNum);
    dto.setDocumentId(documentId);
    
    return documentService.info(dto);
  }
  
  @PostMapping("document")
  public Object insertDocument(@RequestBody DocumentDTO dto, @AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    dto.setCompanyNum(companyNum);
    
    return documentService.insert(dto);
  }
  
  
  @GetMapping("dept")
  public Object getHqDeptList(DocumentDTO dto, @AuthenticationPrincipal CustomerUser user) {
    Long companyNum = user.getUserDTO().getCompanyNum();
    dto.setCompanyNum(companyNum);
    return stdrDeptService.hqDeptList(dto);
  }
}
