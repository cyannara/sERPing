package com.beauty1nside.stdr.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping("/standard/*")

public class StdrController {
  @ModelAttribute
  public void setAttributes(Model model) {
    model.addAttribute("menu", "standard");
  }
  
  @GetMapping("/product")
  public String product() {
    return "stdr/product";
  };
  
  @GetMapping("/store")
  public String store() {
    return "stdr/store";
  };
  
  @GetMapping("/doc")
  public String doc() {
    return "stdr/doc";
  };
  
}
