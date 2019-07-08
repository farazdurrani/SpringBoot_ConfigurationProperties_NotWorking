package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestTestRestTemplate {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testRestTemplate() throws Exception {
		String result = this.restTemplate.getForObject("/serviceinjected", String.class);
		assertThat(result).isEqualTo("Message from Service Class");
	}

}
