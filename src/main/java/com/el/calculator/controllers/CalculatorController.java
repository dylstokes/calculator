package com.el.calculator.controllers;

public class CalculatorController {

	
	public double add(double first, double second) {
		 return first + second;
	}
	
	public double subtract(double first, double second) {
		return first - second;
	}
	
	public double multiply(double first, double second) {
		return first * second;
	}
	
	public double divide(double first, double second) {
		if(second == 0) {
			return 0;
		}
		return first / second;
	}
	
	public double exponent(double number, double power) {
		return Math.pow(number, power);
	}
	
}
