package string.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		String[] strs = null;

		for (String s : list) {

			if (s.equals(" ") || s.equals(""))
				continue;

			// System.out.println("String Before Work "+s);

			if (s.startsWith("//")) {
				
				
				//Matching -> //[delimiter]\n[numbers…]
				if (Pattern.compile("\\/\\/(.)\\\\\\\\n(.*)").matcher(s).matches()) {
					
					Matcher m1 = Pattern.compile("\\/\\/(.)\\\\\\\\n(.*)").matcher(s);
					
					String delimiter = m1.group(1);
					String num = m1.group(2);
					strs = num.split(delimiter);

					sum += sumStringArray(strs);

				} 
				//Matching -> //[delimiter]\n
				else if (Pattern.compile("\\/\\/\\[[^\\]]*\\]\\\\n(.*)").matcher(s).matches()) {
					
					Matcher m2 = Pattern.compile("\\/\\/(.)\\\\\\\\n(.*)").matcher(s);

					System.out.println("Here -> " + m2.groupCount());

					String delimiter = m2.group(1);

					System.out.println(delimiter);

					sum += calculateString(delimiter);
				} 
				//Any other delimiter starting with //
				else {
					if(checkNewLineBetweenCharacters(s.trim()))
						sum+= calculateString(s);
				}
			} else if (checkNewLineBetweenCharacters(s.trim())) {
				sum += calculateString(s);
			}
		}

		if (negatives.size() != 0)
			throw new IllegalArgumentException("Negative Values Not Allowed -> " + negatives);

		return sum;

	}

	int calculateString(String s) {
		int sum = 0;
		String ans = "";

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
				ans += s.charAt(i);
			} else {
				if (!ans.equals("") && !ans.equals(" ")) {
					if (ans.charAt(0) == '-') {
						negatives.add(ans);
					} else {
						if (Integer.parseInt(ans) <= 1000)
							sum += Integer.parseInt(ans);
					}
				}
				ans = "";
			}
		}

		if (!ans.equals("") && !ans.equals(" ")) {
			if (ans.charAt(0) == '-') {
				negatives.add(ans);
			} else {
				if (Integer.parseInt(ans) <= 1000)
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

	int sumStringArray(String[] s) {

		int sum = 0;

		for (int i = 0; i < s.length; i++) {
			if (Integer.parseInt(s[i]) < 0)
				negatives.add(s[i]);
			else if (!Character.isDigit(s[i].charAt(0)))
				sum += Integer.parseInt(s[i]);
		}

		return sum;
	}

}
