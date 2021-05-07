package eCommerceDemo.core;

import eCommerceDemo.RegexEmailValidator.RegexEmailValidatorManager;
import eCommerceDemo.entities.concretes.User;

public class RegexEmailValidatorAdapter implements EmailValidatorService{

	@Override
	public boolean checkEmail(User user) {
		RegexEmailValidatorManager manager = new RegexEmailValidatorManager();
		if(manager.checkEmail(user)) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
