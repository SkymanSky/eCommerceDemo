package eCommerceDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		System.out.println("Kullanici Hibernate ile eklendi: "+user.getFirstName()+" "+user.getLastName());
		users.add(user);
	}

	@Override
	public List<User> getAll() {
		//System.out.println("Kullanicilar Hibernate ile listelendi");

		
		return users;
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanici Hibernate ile guncellendi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanici Hibernate ile silindi: "+user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public User getById(int id) {
		System.out.println("Kullanici Hibernate ile getirildi: ");
		return null;
	}

	@Override
	public boolean checkEmailExists(User user) {
		for (User userChecked : users) {
			if(userChecked.getEmail()==user.getEmail()) {
				return true;
			}
		}
		return false;
	}

}
