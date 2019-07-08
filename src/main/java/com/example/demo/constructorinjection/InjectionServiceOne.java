package com.example.demo.constructorinjection;

import org.springframework.stereotype.Service;

@Service
public class InjectionServiceOne {
	
	public String method() {
		return "xyz";
	}

}
