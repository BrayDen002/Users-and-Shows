package com.bradend.ExamBelt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bradend.ExamBelt.models.Show;
import com.bradend.ExamBelt.models.User;
import com.bradend.ExamBelt.services.ShowService;
import com.bradend.ExamBelt.services.UserService;



@Controller
public class ShowController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ShowService showServ;
	
	
//	GET IDEA DATA
	
//	GET ROUTES
	@GetMapping("/shows")
	public String ideaDash(@ModelAttribute("showObj") Show emptyObj, Model model) {
//		CHECKS IF A USER IS LOGGED
//		Long user_id = (Long) session.getAttribute("user_id");
//    	User u = userServ.findUserById(user_id);
//    	model.addAttribute("user", u);
		List<User> userId = userServ.allUsers();
		model.addAttribute("user", userId);
//		GRAB Idea FROM DATABASE
		List<Show> allIdea = showServ.allShows();
//		PASS Idea TO THE JSP
		model.addAttribute("shows", allIdea);
		return "newShow.jsp";
	}
	
//	EDIT/UPDATE
	@GetMapping("/shows/{id}/edit")
	public String edit(@PathVariable("id") Long show_id, Model model) {
//		CHECKS IF A USER IS LOGGED
//		Long user_id = (Long) session.getAttribute("user_id");
//    	User u = userServ.findUserById(user_id);
//    	model.addAttribute("user", u);
		Show oneShow = showServ.findShows(show_id);
		model.addAttribute("showObj",oneShow);
		return "editShow.jsp";
	}
	
//	VIEW SHOW
	@GetMapping("/shows/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
//		CHECKS IF A USER IS LOGGED
//		Long user_id = (Long) session.getAttribute("user_id");
//    	User u = userServ.findUserById(user_id);
//    	model.addAttribute("user", u);
//    	GET USER INFO 
		User currentUser = userServ.findUserById(id);
    	model.addAttribute("users", currentUser);
//    	GET SHOW INFO
    	Show showOne = showServ.findShows(id);
    	model.addAttribute("shows", showOne);
    	return "viewShow.jsp";
	}
//	DELETE IDEA
	@GetMapping("/shows/{id}/delete")
	public String showDelete(@PathVariable("id") Long id, Model model) {
//		CHECKS IF A USER IS LOGGED IN
//		Long user_id = (Long) session.getAttribute("user_id");
//    	User u = userServ.findUserById(user_id);
//    	model.addAttribute("user", u);
		Show delShow = showServ.findShows(id);
		model.addAttribute("showObj",delShow);
		showServ.deleteIdeas(id);
		return "redirect:/home";
	}
	
	
	
//	POST ROUTES
	@PostMapping("/shows")
	public String create(@Valid @ModelAttribute("showObj")Show filledShow, BindingResult result) {
		if(result.hasErrors()) {
			return "newShow.jsp";
		}
		showServ.saveIdeas(filledShow);
		return "redirect:/home";
	}
	
//	EDIT/UPDATE
	@PostMapping("/shows/{id}/edit")
	public String update(@Valid @ModelAttribute("showObj")Show filledShow, BindingResult result) {
//		IF VALIDATIONS FAIL, RE-RENDER JSP
		if(result.hasErrors()) {
			return "editShow.jsp";
		}
//		IF VALIDATIONS PASS, UPDATE THE SHOW
		else {
			showServ.saveIdeas(filledShow);
			return "redirect:/home";
		}
	}
	
	
}
