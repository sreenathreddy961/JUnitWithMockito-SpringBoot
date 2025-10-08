package com.practice.unit_testing.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.skyscreamer.jsonassert.JSONAssert;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() throws JSONException {
		
		String result = testRestTemplate.getForObject("/items-from-db", String.class);
		
		JSONAssert.assertEquals("["
				+ "{id:1, itemName:Table}, "
				+ "{id:2, itemName:Chair},"
				+ "{id:3, itemName:Bed}, "
				+ "{id:4, itemName:Sofa}, "
				+ "{id:5, itemName:'Smart TV'}"
				+ "]"
				, result, false);
	}
}
