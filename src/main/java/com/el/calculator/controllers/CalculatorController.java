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
	
	public double sine(double first) {
		return Math.sin(first);
	}
	public double cosine(double first) {
		return Math.cos(first);
	}
	public double tangent(double first) {
		return Math.tan(first);
	}
	public double cotangent(double first) {
		return (1 / Math.tan(first));
	}
	public double secant(double first) {
		return (1 / Math.cos(first));
	}
	public double cosecant(double first) {
		return (1 / Math.sin(first));
	}
	
	
	
	
}
