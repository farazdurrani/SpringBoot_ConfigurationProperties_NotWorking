package com.example.demo.testmapinjection;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestMapInjection {
	
	@Bean
	public Map<String, Person> personMap(){
		Map<String, Person> map = new HashMap<>();
		Person p1 = new Person("faraz",1);
		Person p2 = new Person("saad",2);
		map.put("key1",p1);
		map.put("key2",p2);
		return map;
	}

}
