package com.example.demo.springboottest;

import org.springframework.stereotype.Service;

@Service
public class ServiceOne {
	public String message() {
		return "Message from Service Class";
	}
}
