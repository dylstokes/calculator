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

}
