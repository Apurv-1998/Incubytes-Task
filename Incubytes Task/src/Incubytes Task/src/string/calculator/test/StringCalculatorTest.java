package string.calculator.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import string.calculator.StringCalculator;

class StringCalculatorTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testCommas() {
		StringCalculator calc = new StringCalculator();
		int ans = calc.Add("1,12");
		
	//	System.out.println(ans);
		
		assertEquals(13, ans);
	}
	
	@Test
	void testNewLine() {
		StringCalculator calc = new StringCalculator();
		int ans = calc.Add("1,\n12,13");
		
	//	System.out.println(ans);
		
		assertEquals(26, ans);
	}
	
	@Test
	void testCustomDelimeter() {
		StringCalculator calc = new StringCalculator();
		int ans = calc.Add("//;\\n1;2");
		
	//	System.out.println(ans);
		
		assertEquals(3, ans);
	}
	
	@Test()
	void testNegativeValues() {
		StringCalculator calc = new StringCalculator();
		
		assertThrows(IllegalArgumentException.class, ()->{
			Integer.toString(calc.Add("//;\\n1;-2"));
		});
	}
	

}
