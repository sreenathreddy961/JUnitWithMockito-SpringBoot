package com.practice.unit_testing.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldCalculatorTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorldBasic() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
							.get("/hello-world")
							.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andReturn();
		assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
}
