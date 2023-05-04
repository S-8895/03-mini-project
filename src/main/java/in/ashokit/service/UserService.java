package in.ashokit.service;

import in.ashokit.bind.LoginForm;
import in.ashokit.bind.RegistrationForm;

public interface UserService {

	public String login(LoginForm form);
	
	public boolean registration(RegistrationForm form);
	
}
