package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Value("${envvar}")
	private String envvar;
	
	@GetMapping("/printenv")
	public String printEnv() {
		return envvar;
	}
	
	@Autowired
	public Environment env;
	
	@PostMapping("setenv")
	public String setEnv(@RequestBody Map<String, String> map) {
		map.forEach((x,y)->{
			System.setProperty(x, y);
			envvar = y;
		});
		return "done";
	}
}
