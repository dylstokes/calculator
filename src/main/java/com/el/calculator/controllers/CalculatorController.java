package com.el.calculator.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.el.calculator.util.OperationMapper;


@Controller
@RequestMapping("/")
public class CalculatorController {
	
	private static ArrayList<String> history;
	
	private ArrayList<String> getHistory() {
		if(CalculatorController.history == null) {
			CalculatorController.history = new ArrayList<String>();
		}
		
		return CalculatorController.history;
	}
	
	@GetMapping("")
	public String showDefaultPage() {
		return "calculator";
	}
	
	@PostMapping("")
	public ModelAndView calculateNumber(@RequestParam("firstNumber") Double first, 
									    @RequestParam("secondNumber") Double second, 
									    @RequestParam("operationsList") String operation) {
		
		addToHistory(first, second, operation);
		
		String result = "";
		
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
		
		case "sine": result = String.valueOf(sine(first,second));
		break;
		
		case "cosine": result = String.valueOf(cosine(first,second));
		break;
		
		case "tangent": result = String.valueOf(tangent(first,second));
		break;
		
		case "cotangent": result = String.valueOf(cotangent(first,second));
		break;
		
		case "secant": result = String.valueOf(secant(first,second));
		break;
		
		case "cosecant": result = String.valueOf(cosecant(first,second));
		
		default: result = "Invalid Operation";
		break;
		
		}
		
		ModelAndView mv = new ModelAndView("calculator");
		mv.addObject("calculation", result);
		mv.addObject("history", 
				String.join("\n", 
						getHistory()
							.stream()
							.map(f -> {
								return String.format("<br>%s</br>", f);
							}).collect(Collectors.toList())));
		return mv;
		
	}

	private void addToHistory(double first, double second, String operation) {
		String formula;
		switch(operation) {
		case "addition":
		case "subtraction":
		case "multiplication":
		case "division":
		case "exponent":
			formula = String.format("%f %s %f", first, OperationMapper.get(operation), second);
			break;
		case "sine":
		case "cosine":
		case "tangent":
		case "cotangent":
		case "cosecant":
		case "secant":
		case "logarithm":
			formula = String.format("%s(%f)", first, operation.substring(0, 3));
			break;
		case "root":
			formula = String.format("%f ^ (1/%f)", first, second);
		default:
			formula = "Invalid formula";
		}
		
		getHistory().add(formula);
		
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
	
	public double root(double number, double power) {
		return Math.pow(number, (1/power));
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
