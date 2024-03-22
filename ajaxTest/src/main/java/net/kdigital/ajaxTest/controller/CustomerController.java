package net.kdigital.ajaxTest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import net.kdigital.ajaxTest.dto.CustomerDTO;
import net.kdigital.ajaxTest.service.CustomerService;

@Controller
@RequiredArgsConstructor
public class CustomerController {
	public final CustomerService service;
	
	@PostMapping("/insert")
	@ResponseBody   // 데이터가 반환되는 것임 
	// 전달 dto: customerNum 없는 데이터
	// 반환 dto: DB에 저장되어 customerNum값을 가진 데이터 
	public CustomerDTO insert(@ModelAttribute CustomerDTO customerDTO) {
		CustomerDTO dto = service.insert(customerDTO);
		System.out.println("반환된 dto: "+dto.toString());
		return dto;
	}
	
	@GetMapping("/selectAll")
	@ResponseBody
	public List<CustomerDTO> selectAll() {
		List<CustomerDTO> list = service.selectAll();
		return list;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestParam(name="customerNum") Long customerNum) {
		return service.delete(customerNum);
	}
	

}
