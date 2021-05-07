package eCommerceDemo.core;

import eCommerceDemo.entities.concretes.User;

public class SendEmailValidationManager implements SentValidationMessageService{
	public void sentEmail(User user) {
		System.out.println(user.getFirstName()+" "+user.getEmail() +" adresinize dogrulama emaili gonderilmistir.");
	}
}
