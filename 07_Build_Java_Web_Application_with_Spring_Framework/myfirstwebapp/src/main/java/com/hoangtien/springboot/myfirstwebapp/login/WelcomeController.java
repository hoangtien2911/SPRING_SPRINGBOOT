package com.hoangtien.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
//	/login => com.hoangtien.springboot.myfirstwebapp.login.LoginController => login.jsp

	// http://localhost:8080/login?name=Ranga
//	@RequestParam

	// you would want anything to be available to your JSP, you can add it to the
	// model
	// Model call ModelMap

	// GET POST

//	@Autowired
	
//	035 step 29 comment
//	private AuthenticationService authenticationService;
//
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());	
		System.out.println(model.get("name"));
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

//	035 step 29 comment
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		if (authenticationService.authenticate(name, password)) {
//
//			model.put("name", name);			
//
//			// Authentication
//			// name - in28minutes
//			// password - dummy
//			return "welcome";
//		}		
//		return "login";
//	}
}
