package rover;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

	public boolean validateInput(String input, String regex) {

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean checkRange(int maxX, int maxY, int x, int y) {
		
		if(x>=0 && x<=maxX && y>=0 && y<=maxY) {
			return true;
		}
		return false;
	}


}
