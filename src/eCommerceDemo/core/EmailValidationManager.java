package eCommerceDemo.core;

import eCommerceDemo.entities.concretes.User;

public class EmailValidationManager implements UserValidationService {

	@Override
	public void userToValidate(User user) {
		System.out.println(user.getFirstName() + " dogrulamaniz basarili.");
		
	}

	

}
