package com.el.calculator.controllers;

public class CalculatorController {

	
	public int add(int first, int second) {
		 return first + second;
	}
	
	public int subtract(int first, int second) {
		return first - second;
	}
	
	public int multiply(int first, int second) {
		return first * second;
	}
	
	public int divide(int first, int second) {
		if(second == 0) {
			return 0;
		}
		return first / second;
	}
	
	/*
	 * NOTE WE WILL HAVE TO USE DOUBLE
	 */
	public int exponent(int number, int power) {
		return (int) Math.pow(number, power);
	}
	
}
