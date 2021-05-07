package eCommerceDemo;


import eCommerceDemo.business.abstracts.LogInService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.LogInManager;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.EmailValidationManager;
import eCommerceDemo.core.RegexEmailValidatorAdapter;
import eCommerceDemo.core.SendEmailValidationManager;
import eCommerceDemo.core.SignUpWithGoogleAdapter;
import eCommerceDemo.dataAccess.concretes.HibernateUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		UserService userService= new UserManager(new HibernateUserDao(),
				new RegexEmailValidatorAdapter(), 
				new SendEmailValidationManager(), 
				new EmailValidationManager(),
				new SignUpWithGoogleAdapter());

		User user1 = new User(1,"Skyman", "Sky", "skyman@sky.com","123456");
		User user2 = new User(2,"Skymana", "Skya", "skyman@sky.com","123457");
		User user3 = new User(3,"Skymanb", "Skyb", "skymana@sky.com","123456");
		User user4 = new User(4,"Skymanc", "Skyc", "skymana@sky.com","123456");
		userService.add(user1);
		userService.add(user2);
		userService.add(user3);
		userService.add(user4);

		userService.userValidateByEmail(user2);

		userService.addWithSocialMedia(user3);
		
		LogInService logInService = new LogInManager(userService);
		
		logInService.logIn(user1.getEmail(),user1.getPassword()); // Giris basarili.
		logInService.logIn(user2.getEmail(),user2.getPassword()); // Bilgileriniz kontrol ediniz.

	}

}
