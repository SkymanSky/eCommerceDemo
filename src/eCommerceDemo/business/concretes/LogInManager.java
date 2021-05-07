package eCommerceDemo.business.concretes;

import java.util.List;

import eCommerceDemo.business.abstracts.LogInService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class LogInManager implements LogInService{
	
	private UserService userService;
	
	public LogInManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void logIn(String email, String password) {

		List<User> usersInMemory = userService.getAll();
		
		for (User userCheck : usersInMemory) {
			if(userCheck.getEmail()==email && userCheck.getPassword()==password) {
				System.out.println(userCheck.getFirstName()+" : Giris basarili.");
			}else if(userCheck.getEmail()!=email && userCheck.getPassword()!=password){
				System.out.println(userCheck.getFirstName()+" : Bilgilerinizi kontrol ediniz.");
			}
		}
		
	}



	

}
