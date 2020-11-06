import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import string.calculator.StringCalculator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine().trim();
		
		
		StringCalculator stringCalculator = new StringCalculator();
		
		System.out.println("Addition Result of "+s+" is "+stringCalculator.Add(s));
		
	}

}
