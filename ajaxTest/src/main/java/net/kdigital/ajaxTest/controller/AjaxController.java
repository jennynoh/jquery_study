package net.kdigital.ajaxTest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.kdigital.ajaxTest.dto.CustomerDTO;

@Controller
public class AjaxController {

	@GetMapping("/ajaxForm1")
	public String form1() {
		return "ajax_form_1";
	}
	
	@GetMapping("/ajaxReq1")
	@ResponseBody
	public String ajaxReq1() {
		System.out.println("ajax 요청 도착");
		return "success"; // html 페이지가 아닌 data를 의미한다 
	}
	
	@PostMapping("/ajaxReq2")
	@ResponseBody
	public String ajaxReq2(
			@RequestParam(name="username") String username
			, @RequestParam(name="email") String email) {
		System.out.println(username+", "+email);
		return "success";
	}
	
	@PostMapping("/ajaxReq3")
	@ResponseBody
	public Map<String, String> ajaxReq3(
			@RequestParam Map<String, String> map
			) {
		return map;
	}
	
	@GetMapping("/ajaxReq4")
	@ResponseBody
	public List<CustomerDTO> ajaxReq4() {
		List<CustomerDTO> list = Arrays.asList(
				new CustomerDTO("홍길동", "hong@naver.com")
				, new CustomerDTO("홍두동", "two@naver.com")
				, new CustomerDTO("홍세동", "three@naver.com")
				, new CustomerDTO("홍네동", "fourg@naver.com")
				, new CustomerDTO("홍오동", "five@naver.com")
				);
		return list;
	}
}
