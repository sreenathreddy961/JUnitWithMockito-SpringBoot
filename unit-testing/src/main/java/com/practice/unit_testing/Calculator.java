package com.practice.unit_testing;

import com.practice.unit_testing.service.CalculatorService;

public class Calculator {
	
	private CalculatorService calculatorService;
	
	
	public void setCalculatorService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}


	public int sumUpTheArray() {
		
		int[] inputArray = calculatorService.fetchAllData();
		int summedResult = 0;
		for (int inputValue : inputArray) {
			summedResult += inputValue;
		}
		System.out.println(summedResult);
		return summedResult;
	}
}
