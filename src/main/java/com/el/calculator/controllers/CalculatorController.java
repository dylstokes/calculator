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
		
		String result = "";
		System.out.println("Operation = " + operation);
		switch(operation) {
		
		case "addition": result = String.valueOf(add(first,second));
		break;
		
		case "subtraction": result = String.valueOf(subtract(first,second));
		break;
		
		case "multiplication": result = String.valueOf(multiply(first,second));
		break;
		
		case "division": result = String.valueOf(divide(first,second));
		break;
		
		case "exponent": result = String.valueOf(exponent(first,second));
		break;
		
		default: result = "Invalid Operation";
		break;
		
		}
		
		
		
		ModelAndView mv = new ModelAndView("calculator");
		mv.addObject("calculation",result);
		return mv;
		
	}

	
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
