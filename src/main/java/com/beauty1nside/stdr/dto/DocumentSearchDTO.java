package com.beauty1nside.stdr.dto;

import lombok.Data;

@Data
public class DocumentSearchDTO extends DocumentDTO {
  private int start;
  private int end;
  private int pageUnit;
}
