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
			
			//System.out.println("String Before Work "+s);
			
			if(checkNewLineBetweenCharacters(s.trim())) {
				String ans="";
				for(int i=0;i<s.length();i++) {
					if(Character.isDigit(s.charAt(i)))
						ans+=s.charAt(i);
					else {
						if(!ans.equals("")&&!ans.equals(" "))
							sum+=Integer.parseInt(ans);
						ans = "";
					}
				}
				
				if(!ans.equals("")&&!ans.equals(" "))
					sum+=Integer.parseInt(ans);
			}
		}
		
		return sum;
		
	}
	
	boolean checkNewLineBetweenCharacters(String s) {
		
		List<Integer> index = new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)=='n')
				index.add(i);
		}
		
	//	System.out.println(index);
		
		if(index.size()==0)
			return true;
		
		if(index.get(index.size()-1)==s.length()-1)
			return false;
		
		for(int i=index.get(index.size()-1);i<s.length();i++)
			if(Character.isDigit(s.charAt(i)))
				return true;
		
		return false;
		
	}
	
	void printArray(String[] s) {
		
	//	System.out.println("After work length "+s.length);		
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
		System.out.println();
	}

}
