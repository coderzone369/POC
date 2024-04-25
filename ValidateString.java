package javaRegexExpressionValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateString {

	static String expression = "";
	static String regexPattern = "";

	public static void main(String[] args) {
		System.out.println(isStringValid(""));
		System.out.println(validate("", ""));

	}

	public static boolean validate(String expression, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(expression);
		return matcher.matches();
	}

	public static boolean isStringValid(String expression) {
		if(expression == null) {
			return false;
		}
		expression.trim();
		if (expression.isEmpty()) {
			return false;
		}
		return true;
	}

}
