package com.beauty1nside.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
//@RequestMapping("/common/*")
public class CommonController {
	@GetMapping("/example.html")
	public String template0() {
		return "/example";
	}
	
	@GetMapping("/pages/charts/chartjs.html")
	public String template1() {
		return "/pages/charts/chartjs";
	}
	
	@GetMapping("/pages/documentation/documentation.html")
	public String template2() {
		return "/pages/documentation/documentation";
	}
	
	@GetMapping("/pages/forms/basic_elements.html")
	public String template3() {
		return "/pages/forms/basic_elements";
	}
	
	@GetMapping("/pages/icons/mdi.html")
	public String template4() {
		return "/pages/icons/mdi";
	}
	
	@GetMapping("/pages/samples/error-404.html")
	public String template5() {
		return "/pages/samples/error-404";
	}
	
	@GetMapping("/pages/samples/error-500.html")
	public String template6() {
		return "/pages/samples/error-500";
	}
	
	@GetMapping("/pages/samples/login.html")
	public String template7() {
		return "/pages/samples/login";
	}
	
	@GetMapping("/pages/samples/register.html")
	public String template8() {
		return "/pages/samples/register";
	}
	
	@GetMapping("/pages/tables/basic-table.html")
	public String template9() {
		return "/pages/tables/basic-table";
	}
	
	@GetMapping("/pages/ui-features/buttons.html")
	public String template10() {
		return "/pages/ui-features/buttons";
	}
	
	@GetMapping("/pages/ui-features/dropdowns.html")
	public String template11() {
		return "/pages/ui-features/dropdowns";
	}
	
	@GetMapping("/pages/ui-features/typography.html")
	public String template12() {
		return "/pages/ui-features/typography";
	}
	
}
