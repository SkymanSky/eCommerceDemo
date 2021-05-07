package eCommerceDemo.business.abstracts;

import java.util.List;

import eCommerceDemo.entities.concretes.User;

public interface UserService {
	void add(User user);
	List<User> getAll();
	User getById(int id);
	void delete(User user);
	void update(User user);
	void userValidateByEmail(User user);
	void addWithSocialMedia(User user);
	
	
}
