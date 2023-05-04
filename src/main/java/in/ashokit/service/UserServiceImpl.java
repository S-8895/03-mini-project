package in.ashokit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bind.LoginForm;
import in.ashokit.bind.RegistrationForm;
import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String login(LoginForm form) {
		
        User entity= userRepo.findByEmailAndPwd(form.getEmail(),form.getPwd());		
		if(entity == null) {
			return "Invalid Credential";
		}
			
		return "Success";
	}
	
	
	@Override
	public boolean registration(RegistrationForm form) {
		
		User user = userRepo.findByEmail(form.getEmail());
		
		if(user!=null) {
			return false;
		}
		  

		//TODO:Copy data from Binding obj to Entity
		
		User entity = new User();
		
		BeanUtils.copyProperties(form, entity);
		
		//TODO:INSERT RECORD
		userRepo.save(entity);
		
		return true;
	}
	
}
