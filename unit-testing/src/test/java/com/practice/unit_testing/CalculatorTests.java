package com.practice.unit_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practice.unit_testing.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
public class CalculatorTests {
	
	@InjectMocks
	Calculator calculator;
	
	@Mock
	CalculatorService mockedCalculatorService;

	@Test
	void testSumUpTheArray() {
		
		when(mockedCalculatorService.fetchAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, calculator.sumUpTheArray());
		
	}

}
