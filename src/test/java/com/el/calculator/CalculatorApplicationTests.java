package com.el.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.el.calculator.controllers.CalculatorController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void addTest() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.add(5, 2), 7, 0.001);
		assertEquals(cc.add(2, 5), 7, 0.001);
		assertEquals(cc.add(6, -2), 4, 0.001);
		assertEquals(cc.add(0, 0), 0, 0.001);
		assertEquals(cc.add(1, 2), 3, 0.001);
		assertEquals(cc.add(3, 4), 7, 0.001);
		assertEquals(cc.add(3589172, 2873410), 6462582, 0.001);
		assertEquals(cc.add(5280, 1200), 6480, 0.001);
		assertEquals(cc.add(120, 240), 360, 0.001);
		assertEquals(cc.add(10, 10), 20, 0.001);
	}
	
	@Test
	public void multiplyTest() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.multiply(6, 3), 18, 0.001);
		assertEquals(cc.multiply(-9, 4), -36, 0.001);
		assertEquals(cc.multiply(200, -450), -90000, 0.001);
		assertEquals(cc.multiply(-35, -50), 1750, 0.001);
		assertEquals(cc.multiply(0, 654), 0, 0.001);
  }
    
  @Test
	public void subTests() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.subtract(0, 0), 0, 0.001);
		assertEquals(cc.subtract(0, 1), -1, 0.001);
		assertEquals(cc.subtract(5, 3), 2, 0.001);
		assertEquals(cc.subtract(78643, 323), 78320, 0.001);
		assertEquals(cc.subtract(-77, 3), -80, 0.001);
	}
	
	@Test
	public void exponentTests() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.exponent(0, 0), 1, 0.001);
		assertEquals(cc.exponent(1, 1), 1, 0.001);
		assertEquals(cc.exponent(78, 4), 37015056, 0.001);
		assertEquals(cc.exponent(-5, 2), 25, 0.001);
	}
	
  @Test
	public void divideTest() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.divide(1, 1), 1, 0.001);
		assertEquals(cc.divide(2, 2), 1, 0.001);
		assertEquals(cc.divide(4, 2), 2, 0.001);
		assertEquals(cc.divide(16, 4), 4, 0.001);
		assertEquals(cc.divide(350, 5), 70, 0.001);
		assertEquals(cc.divide(-452, -2), 226, 0.001);
		assertEquals(cc.divide(-798, 3), -266, 0.001);
		assertEquals(cc.divide(5930, 5), 1186, 0.001);
		assertEquals(cc.divide(10950, 0), 0, 0.001);
	}

}
