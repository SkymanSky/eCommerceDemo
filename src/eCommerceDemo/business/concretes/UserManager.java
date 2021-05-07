package eCommerceDemo.business.concretes;


import java.util.List;

import eCommerceDemo.SignUpWithGoogle.SignUpWithGoogleManager;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.EmailValidatorService;
import eCommerceDemo.core.SentValidationMessageService;
import eCommerceDemo.core.UserValidationService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;
import eCommerceDemo.core.SocialMediaSignUpService;

public class UserManager implements UserService{

	private UserDao userDao;
	private EmailValidatorService emailValidatorService;
	private SentValidationMessageService sentValidationMessageService;
	private UserValidationService userValidationService;
	private SocialMediaSignUpService socialMediaSignUpService;

	public UserManager( UserDao userDao,
						EmailValidatorService emailValidatorService,
						SentValidationMessageService sentValidationMessageService,
						UserValidationService userValidationService,
						SocialMediaSignUpService socialMediaSignUpService
						) {
		super();
		this.userDao = userDao;
		this.emailValidatorService=emailValidatorService;
		this.sentValidationMessageService = sentValidationMessageService;
		this.userValidationService=userValidationService;
		this.socialMediaSignUpService = socialMediaSignUpService;
	}

	@Override
	public void add(User user) {
		
		if(user.getFirstName().length()>2 && user.getLastName().length()>2 && user.getPassword().length()>=6 && user.getEmail().length()>1) {
			
			if(!emailValidatorService.checkEmail(user)) {
				
				System.out.println("Email adresiniz dogru formatta degil");
				return;
				
			}
			
			if(!userDao.getAll().isEmpty() && userDao.checkEmailExists(user)) {
				System.out.println("Email adresi ile kullanici var.");
				return;
			}
			
				userDao.add(user);
				sentValidationMessageService.sentEmail(user);
				
			
		}else {
			System.out.println("Gerekli alanlari doldurmadiniz. Kontrol ediniz.");
		}
		
	}

	@Override
	public List<User> getAll() {

		return userDao.getAll();

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public User getById(int id) {
		userDao.getById(id);
		return null;
	}

	@Override
	public void userValidateByEmail(User user) {
		userValidationService.userToValidate(user);
		
	}

	@Override
	public void addWithSocialMedia(User user) {
		socialMediaSignUpService.signUpWithGoogle(user);
		
		
	}

}
