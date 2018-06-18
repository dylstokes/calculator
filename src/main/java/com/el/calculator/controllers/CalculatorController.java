package com.el.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.el.calculator.models.Calculator;


@Controller
@RequestMapping("/")
public class CalculatorController {
	
	// future release: graceful default second values..
	private static final String DEF_SECOND = "-0.000001";
	
	@GetMapping("")
	public String showDefaultPage() {
		return "calculator";
	}
	
	@PostMapping("")
	public ModelAndView calculateNumber(@RequestParam("firstNumber") Double first, 
									    @RequestParam(
									    		value="secondNumber", 
									    		required=false, 
									    		defaultValue=CalculatorController.DEF_SECOND) 
												Double second, 
									    @RequestParam("operationsList") String operation) {
		return Calculator.process(first, second, operation);		
	}

	
	
	
}
