package string.calculator.test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
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
	void testCustomDelimeterFixedLength() {
		StringCalculator calc = new StringCalculator();
		int ans = calc.Add("//;\\n12;2");
		
		System.out.println(ans);
		
		assertEquals(14, ans);
	}
	
	@Test
	void testCustomDelimeterVariableLength() {
		StringCalculator calc = new StringCalculator();
		int ans = calc.Add("//[***]\\n1***2***3");
		
		System.out.println(ans);
		
		assertEquals(6, ans);
	}
	
	@Test()
	void testNegativeValues() {
		StringCalculator calc = new StringCalculator();
		
		try {
			
			calc.Add("-1,-2,3");
			fail("Exception Exceptied!");
			
		}catch(Exception e) {
			
		}
	}
	
	@Test()
	void testGreaterThanThousand() {
		StringCalculator calc = new StringCalculator();
		int ans = calc.Add("1,1001","1000,1001","1002,2");
		
	//	System.out.println(ans);
		
		assertEquals(1003, ans);
	}

}
