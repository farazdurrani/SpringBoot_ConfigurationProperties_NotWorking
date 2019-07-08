package com.example.demo.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceTwo {
	
	private RestTemplate restTemplate;
	
	public String callGoogle() {
		System.err.println(this.restTemplate.getForObject("http://www.google.com", String.class));
		return "real google call";
	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
