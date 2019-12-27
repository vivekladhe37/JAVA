package com.app.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency
	@Autowired
	private IUserService service;

	public UserController() {
		System.out.println("in constr of user controller");
	}

	// request handling method to show login form
	@GetMapping("/login") // @RequestMapping + method =get
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";// separation of view layer
	}

	// request handling method to process login form
	@PostMapping("/login") // @RequestMapping + method =post
	public String processLoginForm(@RequestParam(name = "email") String em, @RequestParam String password, Model map,HttpSession hs,RedirectAttributes flashMap) {
		System.out.println("in process login form " + em + " " + password);
		// invoke service's method
		try {
			hs.setAttribute("user_dtls", service.authenticateUser(em, password));
			flashMap.addFlashAttribute("mesg", "Login Successful");

		} catch (RuntimeException e) {
			// add err mesg in model map
			map.addAttribute("mesg", "Invalid login , pls retry....");
			return "/user/login";// forward view
		}
		// login success
		return "redirect:/vendor/details";// redirect view : clnt pull : send redirect + URL rewriting if needed in the
								// absence of cookies.
	}

}
