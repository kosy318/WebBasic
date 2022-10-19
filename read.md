package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// ��û�ϰ� mapping�Ǵ� ���� ã�´�. HandlerMapping
	// http://localhost:8080/mvc
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		String city = "seoul";
		
		// request���� �߻��� data�� view���� ������ �� �ְ�
		// map������ ������ ���� �ڷᱸ��
		model.addAttribute("city", city);
		model.addAttribute("code", "a12345");
		return "home"; // return�ϴ� ���� ������ view�� �̸�
	}
	
	// http://localhost:8080/mvc/test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		String msg = "hello world!";
		
		model.addAttribute("msg", msg);
		return "test"; // return�ϴ� ���� ������ view�� �̸�
	}
	
}
