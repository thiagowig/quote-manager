package br.com.zaul.manager.quote.business.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLParser implements Parser {

	private static final String URL_REGEX = "((([A-Za-z]{3,9}:(?:\\/\\/)?)(?:[-;:&=\\+\\$,\\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\\+\\$,\\w]+@)[A-Za-z0-9.-]+)((?:\\/[\\+~%\\/.\\w-_]*)?\\??(?:[-\\+=&;%@.\\w_]*)#?(?:[\\w]*))?)";
	
	private static final String LINK_PATTERN = "<a target=\"blank\" href=\"http://%s\">%s</a>";
	
	
	@Override
	public String parse(String value) {
		Pattern pattern = Pattern.compile(URL_REGEX);
		Matcher matcher = pattern.matcher(value);
		
		StringBuilder parsedValue = new StringBuilder(value);
		
		while(matcher.find()) {
			parsedValue = parsedValue.replace(matcher.start(), matcher.end(), String.format(LINK_PATTERN, matcher.group().replace("http://", ""), matcher.group()));
		}
		
		return parsedValue.toString();
	}

	@Override
	public String deparse(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
