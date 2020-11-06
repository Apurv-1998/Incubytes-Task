package string.calculator;

public class StringCalculator {
	
	public StringCalculator(){
		
	}
	
	
	public int Add(String s) {
		
		//Splitting the string for comma(,)
		
		if(s.equals(" ")||s.equals(""))
			return 0;
		
		String[] str = s.split("\\,");
		
		if(str.length==1)
			return Integer.parseInt(str[0]);
		
		return Integer.parseInt(str[0])+Integer.parseInt(str[1]);
		
		
	}

}
