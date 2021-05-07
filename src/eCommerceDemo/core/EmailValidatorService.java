package eCommerceDemo.core;

import eCommerceDemo.entities.concretes.User;

public interface EmailValidatorService {
	boolean checkEmail(User user);
}
