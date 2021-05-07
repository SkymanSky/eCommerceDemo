package eCommerceDemo.core;

import eCommerceDemo.entities.concretes.User;

public interface SentValidationMessageService {
	void sentEmail(User user);
}
