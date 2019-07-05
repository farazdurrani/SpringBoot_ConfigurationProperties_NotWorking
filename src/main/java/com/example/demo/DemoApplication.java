package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Value("${taco.orders.pageSize}")
	private String pageSize;

	@GetMapping("/myName")
	public String myName() {
		return pageSize;
	}
	
	int i = 0;
	
	@Scheduled(fixedRate = 2000L)
	public void scheduled() {
		System.err.println(++i + "-" + pageSize);
	}
}
