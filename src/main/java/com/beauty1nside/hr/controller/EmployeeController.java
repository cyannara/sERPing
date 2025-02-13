package com.beauty1nside.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beauty1nside.hr.service.EmployeeService;

import groovy.util.logging.Log4j2;
import lombok.AllArgsConstructor;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping("/hr/*")
public class EmployeeController {
	private final EmployeeService employeeService;
	
    @GetMapping("/employees")
    public String employeeList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "/hr/employee";  // resources/templates/employee.html 를 렌더링
    }


}
