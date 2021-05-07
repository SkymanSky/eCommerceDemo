package eCommerceDemo.RegexEmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.entities.concretes.User;

public class RegexEmailValidatorManager {

	
	public boolean checkEmail(User user) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());

		if (matcher.matches()) {
			return true;
		} else {
			return false;

		}

	}

}
