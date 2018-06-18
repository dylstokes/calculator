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
	// future release: graceful default second values..
	private static final Double DEF_SECOND_DBL = -0.000001;
	private static final String DEF_SECOND = "-0.000001";
	private static final Double DEF_ROOT = 2.0;
	private static final Double DEF_LOG = 10.0;
	
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
									    @RequestParam(
									    		value="secondNumber", 
									    		required=false, 
									    		defaultValue=CalculatorController.DEF_SECOND) 
												Double second, 
									    @RequestParam("operationsList") String operation) {
		
		second = defaultSecond(second, operation);
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
		
		case "sine": result = String.valueOf(sine(first));
		break;
		
		case "root": result = String.valueOf(root(first, second));
		break;
		
		case "cosine": result = String.valueOf(cosine(first));
		break;
		
		case "tangent": result = String.valueOf(tangent(first));
		break;
		
		case "cotangent": result = String.valueOf(cotangent(first));
		break;
		
		case "secant": result = String.valueOf(secant(first));
		break;
		
		case "cosecant": result = String.valueOf(cosecant(first));
		break;
		
		case "logarithm": result = String.valueOf(logarithm(first, second));
		break;
		
		case "naturallog": result = String.valueOf(naturalLog(first));
		break;
		
		default: result = "Invalid Operation";
		break;
		
		}
		
		addToHistory(first, second, operation);
		
		ModelAndView mv = new ModelAndView("calculator");
		mv.addObject("calculation", result);
		mv.addObject("history", 
				String.join("\n", 
						getHistory()
							.stream()
							.map(f -> {
								return String.format("<ul>%s</ul>", f);
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
			formula = String.format("%s(%f)", operation.substring(0, 3), first);
			break;
		case "logarithm":
			formula = String.format("%s[%f](%f)", operation.substring(0, 3), first, second);
			break;
		case "naturallog":
			formula = String.format("ln(%f)", first);
			break;
		case "root":
			formula = String.format("%f ^ (1/%f)", first, second);
			break;
		default:
			formula = "Invalid formula";
		}
		
		getHistory().add(formula);
		
	}
	
	private double defaultSecond(double a, String method) {
		if(equals(a, CalculatorController.DEF_SECOND_DBL)) {
			switch(method) {
			case "logarithm": return CalculatorController.DEF_LOG;
			case "root": return CalculatorController.DEF_ROOT;
			}
		}
		return a;
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
		if(equals(power, CalculatorController.DEF_SECOND_DBL)) {
			power = CalculatorController.DEF_ROOT;
		}
		return Math.pow(number, (1/power));
	}
	
	public double logarithm(double base, double number) {
		if(equals(base, CalculatorController.DEF_SECOND_DBL)) {
			base = CalculatorController.DEF_LOG;
		}
		return Math.log(number) / Math.log(base);
	}
	
	public double naturalLog(double number) {
		return Math.log(number);
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
	
	private boolean equals(double a, double b) {
		System.out.printf("First  value: %f", a);
		System.out.printf("Second value: %f", b);
		double eps = 0.0001;
		return (a+eps)<b && (a-eps)>b;
	}
	
	
}
