package com.el.calculator.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.web.servlet.ModelAndView;

import com.el.calculator.util.OperationMapper;

public class Calculator {
	
	private static ArrayList<String> history;
	private static final Double DEF_SECOND_DBL = -0.000001;
	private static final Double DEF_ROOT = 2.0;
	private static final Double DEF_LOG = 10.0;
	
	public static ModelAndView process(double first, double second, String operation) {
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
	
	private static ArrayList<String> getHistory() {
		if(history == null) {
			history = new ArrayList<String>();
		}
		
		return history;
	}

	private static void addToHistory(double first, double second, String operation) {
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
	
	private static double defaultSecond(double a, String method) {
		if(equals(a, DEF_SECOND_DBL)) {
			switch(method) {
			case "logarithm": return DEF_LOG;
			case "root": return DEF_ROOT;
			}
		}
		return a;
	}
	
	public static double add(double first, double second) {
		 return first + second;
	}
	
	public static double subtract(double first, double second) {
		return first - second;
	}
	
	public static double multiply(double first, double second) {
		return first * second;
	}
	
	public static double divide(double first, double second) {
		if(second == 0) {
			return 0;
		}
		return first / second;
	}
	
	public static double exponent(double number, double power) {
		return Math.pow(number, power);
	}
	
	public static double root(double number, double power) {
		if(equals(power, DEF_SECOND_DBL)) {
			power = DEF_ROOT;
		}
		return Math.pow(number, (1/power));
	}
	
	public static double logarithm(double base, double number) {
		if(equals(base, DEF_SECOND_DBL)) {
			base = DEF_LOG;
		}
		return Math.log(number) / Math.log(base);
	}
	
	public static double naturalLog(double number) {
		return Math.log(number);
	}

	public static double sine(double first) {
		return Math.sin(first);
	}
	public static double cosine(double first) {
		return Math.cos(first);
	}
	public static double tangent(double first) {
		return Math.tan(first);
	}
	public static double cotangent(double first) {
		return (1 / Math.tan(first));
	}
	public static double secant(double first) {
		return (1 / Math.cos(first));
	}
	public static double cosecant(double first) {
		return (1 / Math.sin(first));
	}
	
	public static boolean equals(double a, double b) {
		double eps = 0.0001;
		return (a+eps)>b && (a-eps)<b;
	}
	
}
