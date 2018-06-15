package com.el.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class CalculatorController {
	
	@GetMapping("")
	public String showDefaultPage() {
		return "calculator";
	}
	
	@PostMapping("")
	public ModelAndView calculateNumber(@RequestParam("firstNumber") int first, 
									    @RequestParam("secondNumber") int second, 
									    @RequestParam("operationsList") String operation) {
		
		int result = 0;
		switch(operation) {
		
		case "+": result = add(first,second);
		break;
		
		case "-": result = subtract(first,second);
		break;
		
		case "*": result = multiply(first,second);
		break;
		
		case "/": result = divide(first,second);
		break;
		
		}
		
		ModelAndView mv = new ModelAndView("calculator");
		mv.addObject("calculation",result);
		return mv;
		
	}

	
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
