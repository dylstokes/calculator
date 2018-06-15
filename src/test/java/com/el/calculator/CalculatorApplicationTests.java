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
		assertEquals(cc.add(5, 2), 7);
		assertEquals(cc.add(2, 5), 7);
		assertEquals(cc.add(6, -2), 4);
		assertEquals(cc.add(0, 0), 0);
		assertEquals(cc.add(1, 2), 3);
		assertEquals(cc.add(3, 4), 7);
		assertEquals(cc.add(3589172, 2873410), 6462582);
		assertEquals(cc.add(5280, 1200), 6480);
		assertEquals(cc.add(120, 240), 360);
		assertEquals(cc.add(10, 10), 20);
	}
	
	@Test
	public void multiplyTest() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.multiply(6, 3), 18);
		assertEquals(cc.multiply(-9, 4), -36);
		assertEquals(cc.multiply(200, -450), -90000);
		assertEquals(cc.multiply(-35, -50), 1750);
		assertEquals(cc.multiply(0, 654), 0);
  }
    
  @Test
	public void subTests() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.subtract(0, 0), 0);
		assertEquals(cc.subtract(0, 1), -1);
		assertEquals(cc.subtract(5, 3), 2);
		assertEquals(cc.subtract(78643, 323), 78320);
		assertEquals(cc.subtract(-77, 3), -80);
	}
	
	@Test
	public void exponentTests() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.exponent(0, 0), 1);
		assertEquals(cc.exponent(1, 1), 1);
		assertEquals(cc.exponent(78, 4), 37015056);
		assertEquals(cc.exponent(-5, 2), 25);
	}
	
  @Test
	public void divideTest() {
		CalculatorController cc = new CalculatorController();
		assertEquals(cc.divide(1, 1), 1);
		assertEquals(cc.divide(2, 2), 1);
		assertEquals(cc.divide(4, 2), 2);
		assertEquals(cc.divide(16, 4), 4);
		assertEquals(cc.divide(350, 5), 70);
		assertEquals(cc.divide(-452, -2), 226);
		assertEquals(cc.divide(-798, 3), -266);
		assertEquals(cc.divide(5930, 5), 1186);
		assertEquals(cc.divide(10950, 0), 0);
	}

}
