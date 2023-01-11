package com.bradend.ExamBelt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bradend.ExamBelt.models.Show;
import com.bradend.ExamBelt.models.User;
import com.bradend.ExamBelt.services.ShowService;
import com.bradend.ExamBelt.services.UserService;
import com.bradend.ExamBelt.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private ShowService showServ;
	
	@GetMapping("/")
	public String dashboard() {
		return "redirect:/registration";
	}
	
	@GetMapping("/registration")
    public String registerForm(@ModelAttribute("userObj") User emprtyUser) {
        return "registrationPage.jsp";
    }
    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	User u = userServ.findUserById(user_id);
    	model.addAttribute("user", u);
//    	GETS SHOWS WHEN I VISIT HOME
    	List<Show> allShows = showServ.allShows();
    	model.addAttribute("shows", allShows);
    	
    	return "homePage.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
    
//    POST ROUTES
    @PostMapping("/registration")
    public String registerUser(
    		@Valid @ModelAttribute("userObj") User filledUser, BindingResult result, 
    		HttpSession session
    ) {
    	userValidator.validate(filledUser, result);
        // if result has errors, return the registration page (don't worry about validations just now)
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	else {
    		User newUser = userServ.registerUser(filledUser);
    		session.setAttribute("user_id", newUser.getId());
    		return "redirect:/home";
    	}
    }
    
    @PostMapping("/login")
    public String loginUser(
    		@RequestParam("email") String email, @RequestParam("password") String password, 
    		Model model, 
    		HttpSession session,
    		RedirectAttributes flashMessages
    ) {
        // if the user is authenticated, save their user id in session
    	if(userServ.authenticateUser(email, password)) {
    		User loggedUser = userServ.findByEmail(email);
    		session.setAttribute("user_id", loggedUser.getId());
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	else {
    		flashMessages.addFlashAttribute("error", "INVALID LOGIN");
    		return "redirect:/login";
    	}
    }
}
