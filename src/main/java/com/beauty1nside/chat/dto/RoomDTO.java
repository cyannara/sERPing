package com.beauty1nside.chat.dto;

import com.beauty1nside.hr.dto.EmpDTO;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoomDTO {
  private Long roomId;
  private Long companyNum;
  private Date createdAt;
  private Long employeeNum1;
  private Long employeeNum2;
  
//  @Size(min = 2, max = 2, message = "only 2 members")
//  private List<Object> empList;
//
//  public void setEmpList(List<Object> empList) {
//    if (empList == null || empList.size() != 2) {
//      throw new IllegalArgumentException("only 2 members");
//    }
//    this.empList = empList;
//  }
}
