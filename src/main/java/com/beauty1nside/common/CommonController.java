package com.beauty1nside.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/common/*")
public class CommonController {

	@GetMapping("/chart")
	public String template1() {
		return "/pages/charts/chartjs";
	}
	
	@GetMapping("/documentation")
	public String template2() {
		return "/pages/documentation/documentation";
	}
	
	@GetMapping("/forms")
	public String template3() {
		return "/pages/forms/basic_elements";
	}
	
	@GetMapping("/icons")
	public String template4() {
		return "/pages/icons/mdi";
	}
	
	@GetMapping("/error404")
	public String template5() {
		return "/pages/samples/error-404";
	}
	
	@GetMapping("/error500")
	public String template6() {
		return "/pages/samples/error-500";
	}
	
	@GetMapping("/login")
	public String template7() {
		return "/pages/samples/login";
	}
	
	@GetMapping("/register")
	public String template8() {
		return "/pages/samples/register";
	}
	
	@GetMapping("/tables")
	public String template9() {
		return "/pages/tables/basic-table";
	}
	
	@GetMapping("/buttons")
	public String template10() {
		return "/pages/ui-features/buttons";
	}
	
	@GetMapping("/dropdowns")
	public String template11() {
		return "/pages/ui-features/dropdowns";
	}
	
	@GetMapping("/typography")
	public String template12() {
		return "/pages/ui-features/typography";
	}
	
}
