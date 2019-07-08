package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.springboottest.ServiceOne;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc 
public class TestMockMvcAndMockInjection {

	@MockBean
	private ServiceOne newService;

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testEndpoint() throws Exception {
		given(newService.message()).willReturn("Message from Service Class");
		this.mvc.perform(get("/serviceinjected")).andExpect(status().isOk()).andExpect(content().string("Message from Service Class"));
	}
	
}
