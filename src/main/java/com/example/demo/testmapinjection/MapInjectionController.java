package com.example.demo.testmapinjection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapInjectionController {
	
	private Map<String,Person> personMaps;

	@Autowired
	public void setPersonMaps(Map<String,Person> personMaps) {
		this.personMaps = personMaps;
	}
	
	@GetMapping("/personmap")
	public Map<String,Person> personMap(){
		return personMaps;
	}

}
