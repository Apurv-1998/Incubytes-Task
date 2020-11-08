package string.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	private List<String> negatives;

	public StringCalculator() {

	}

	public int Add(String... str) {

		List<String> list = new ArrayList<>();
		
		negatives = new ArrayList<>();

		for (String s : str) {
			list.add(s);
		}

		if (list.size() == 0)
			return 0;

		int sum = 0;

		for (String s : list) {

			if (s.equals(" ") || s.equals(""))
				continue;

			// System.out.println("String Before Work "+s);

			if (s.startsWith("//")&&checkNewLineBetweenCharacters(s.trim())) {

				
				String[] strs = s.split("\\;");
				
				for(int i=0;i<strs.length;i++) {
					if(checkNewLineBetweenCharacters(strs[i])) {
						sum+= calculateString(strs[i]);
					}
				}
				
			}
			else if (checkNewLineBetweenCharacters(s.trim())) {
				sum+= calculateString(s);
			}
		}
		
		if(negatives.size()!=0)
			throw new IllegalArgumentException("Negative Values Not Allowed -> "+negatives);

		return sum;

	}
	
	int calculateString(String s) {
		int sum=0;
		String ans = "";
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))||s.charAt(i)=='-') {
				ans += s.charAt(i);
			}
			else {
				if (!ans.equals("") && !ans.equals(" ")) {
					if(ans.charAt(0)=='-') {
						negatives.add(ans);
					}
					else {
						sum += Integer.parseInt(ans);
					}
				}
				ans = "";
			}
		}

		if (!ans.equals("") && !ans.equals(" ")) {
			if(ans.charAt(0)=='-') {
				negatives.add(ans);
			}
			else {
				sum += Integer.parseInt(ans);
			}
		}
		return sum;
	}

	boolean checkNewLineBetweenCharacters(String s) {

		List<Integer> index = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'n')
				index.add(i);
		}

		// System.out.println(index);

		if (index.size() == 0)
			return true;

		if (index.get(index.size() - 1) == s.length() - 1)
			return false;

		for (int i = index.get(index.size() - 1); i < s.length(); i++)
			if (Character.isDigit(s.charAt(i)))
				return true;

		return false;

	}

	void printArray(String[] s) {

		// System.out.println("After work length "+s.length);
		for (int i = 0; i < s.length; i++)
			System.out.print(s[i] + " ");
		System.out.println();
	}

}
