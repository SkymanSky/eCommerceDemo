package eCommerceDemo.core;

import eCommerceDemo.SignUpWithGoogle.SignUpWithGoogleManager;
import eCommerceDemo.entities.concretes.User;

public class SignUpWithGoogleAdapter implements SocialMediaSignUpService {

	@Override
	public void signUpWithGoogle(User user) {
		SignUpWithGoogleManager signUpWithGoogleManager = new SignUpWithGoogleManager();
		signUpWithGoogleManager.signUpWithGoogle(user);
		
	}
	
}
