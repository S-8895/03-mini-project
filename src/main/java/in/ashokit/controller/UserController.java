package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.bind.LoginForm;
import in.ashokit.bind.RegistrationForm;
import in.ashokit.service.UserService;


@Controller
public class UserController {
    @Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	   public String logInPage(Model model) {
		   
			model.addAttribute("loginForm", new LoginForm());
			
			return "login"; 
	   }
	
	
	@PostMapping("/login")
	   public String logIn(@ModelAttribute("loginForm") LoginForm loginform , Model model) {
		   
		String status = userService.login(loginform);
		model.addAttribute("succMsg", status);
		
		model.addAttribute("errMsg", status);
			return "login"; 
	   }
	
	
	
	
	
	@GetMapping("/signup")
	   public String signUpPage(Model model) {
		
		model.addAttribute("user", new RegistrationForm());
		   return "registration"; 
	   }
	
	
	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute("user") RegistrationForm form,Model model) {
		
		boolean status = userService.registration(form);
		
		if(status) {
			model.addAttribute("succmsg", "Account created successfully");
		}else {
		 
			model.addAttribute("errmsg", "choose unique email");
		}
		
		return "registration";
	}
	
	
	
	
	
	
}
