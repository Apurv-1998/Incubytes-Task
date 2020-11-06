package string.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	public StringCalculator(){
		
	}
	
	
	public int Add(String... str) {
		
		
		List<String> list = new ArrayList<>();
		
		for(String s: str) {
			list.add(s);
		}
		
		if(list.size()==0)
			return 0;
		
		int sum = 0;
		
		for(String s:list) {
			
			if(s.equals(" ")||s.equals(""))
				continue;
			
			String[] strs = s.split("\\,");
			
			if(strs.length==1)
				sum+=Integer.parseInt(strs[0]);
			else
				sum+=Integer.parseInt(strs[0])+Integer.parseInt(strs[1]);;
		}
		
		return sum;
		
	}

}
