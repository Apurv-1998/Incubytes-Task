import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import string.calculator.StringCalculator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner input = new Scanner(System.in);
		
		List<String> list = new ArrayList<>();
		
		while(input.hasNext()) {
			
			String s = input.next().trim();
			
			if(s.length()==0)
				break;
			
			list.add(s);
			
			System.out.println(list);
			
		}
		
		String[] str = new String[list.size()];
		
		for(int i=0;i<str.length;i++)
			str[i] = list.get(i);
		
		
		StringCalculator stringCalculator = new StringCalculator();
		
		System.out.println("Addition Result of "+list+" is "+stringCalculator.Add(str));
		
	}

}
