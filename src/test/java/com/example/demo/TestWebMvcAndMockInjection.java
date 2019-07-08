package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.springboottest.MyRestController;
import com.example.demo.springboottest.ServiceOne;
import com.example.demo.springboottest.ServiceTwo;

@RunWith(SpringRunner.class)
@WebMvcTest(MyRestController.class) //No need to @AutoConfigureMockMvc as @WebMvcTest already does it for us.
public class TestWebMvcAndMockInjection {

	@MockBean
	private ServiceTwo anotherService;
	
	@MockBean
	private ServiceOne newService;
	
	@Autowired
	private MyRestController newController;
	
	@Test
	public void testMocks() {
		given(anotherService.callGoogle()).willReturn("real google call");
//		anotherService is already injected into NewController
		String result = newController.googleServiceInjected();
		assertThat(result).isEqualTo("real google call");
	}

}
