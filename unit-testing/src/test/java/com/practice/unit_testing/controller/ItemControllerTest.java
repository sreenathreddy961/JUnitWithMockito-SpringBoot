package com.practice.unit_testing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.practice.unit_testing.model.Item;
import com.practice.unit_testing.service.ItemService;
	
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private ItemService itemService;
	
	String actualResult = "{\"id\": 1,\"itemName\":\"Table\",\"itemPrice\":10,\"itemQuantity\":100}";
	
	@Test
	public void dummyItemtest() throws Exception {
		
		String expectedResult = "{\"id\": 1,\"itemName\":\"Table\",\"itemPrice\":10,\"itemQuantity\":100}";
		RequestBuilder request = MockMvcRequestBuilders
													.get("/dummy-item")
													.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc
								.perform(request)
								.andExpect(status().isOk())
								.andExpect(content().json(expectedResult))
								.andReturn();
	}
	
	@Test
	public void jsonAssertTest () throws JSONException {
		
		String expectedResult = "{\"id\": 1,\"itemName\":\"Table\",\"itemPrice\":10,\"itemQuantity\":100}";
		JSONAssert.assertEquals(expectedResult, actualResult, true);
	}
	
	@Test
	public void jsonAssertWithOutEscapeCharactersTest () throws JSONException {
		
		String expectedResult = "{id: 1, itemName:Table, itemPrice:10, itemQuantity:100}";
		JSONAssert.assertEquals(expectedResult, actualResult, true);
	}
	
	@Test
	public void itemFromServiceLayerTest () throws Exception {
		
		
		String expectedResult = "{id: 2, itemName: Chair, itemPrice:5, itemQuantity:50}";
		when(itemService.fetchAllItems()).thenReturn(new Item(2, "Chair", 5, 50));
		
		RequestBuilder request = MockMvcRequestBuilders
													.get("/item-from-service")
													.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc
								.perform(request)
								.andExpect(status().isOk())
								.andExpect(content().json(expectedResult))
								.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void itemFromDBTest () throws Exception {
		
		String expectedResult = "[{id: 1, itemName: Table, itemPrice:10, itemQuantity:100}, {id: 2, itemName: Chair, itemPrice:5, itemQuantity:50}]";
		when(itemService.fetchAllItemsFromDB()).thenReturn(Arrays.asList(
																		new Item(1, "Table", 10, 100),
																		new Item(2,  "Chair",  5, 50)));
		
		RequestBuilder request = MockMvcRequestBuilders
													.get("/items-from-db")
													.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
													.andExpect(status().isOk())
													.andExpect(content().json(expectedResult))
													.andReturn();
		System.out.println(result.getResponse().getContentAsString());
		
	}

}
