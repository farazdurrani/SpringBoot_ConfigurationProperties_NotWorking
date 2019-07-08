package com.example.demo.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	private ServiceOne newService;
	
	private ServiceTwo anotherService;
	
	@Autowired
	public void setNewService(ServiceOne newService) {
		this.newService = newService;
	}
	
	@Autowired
	public void setAnotherService(ServiceTwo anotherService) {
		this.anotherService = anotherService;
	}
	
	@GetMapping("/test")
	public String test() {
		return "test from new Controller";
	}
	
	@GetMapping("/serviceinjected")
	public String serviceInjectedTest() {
		return newService.message();
	}
	
	@GetMapping("testGoogle")
	public String googleServiceInjected() {
		return anotherService.callGoogle();
	}
}
