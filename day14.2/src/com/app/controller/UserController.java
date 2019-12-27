package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.app.pojos.Vendor;
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
	public String processLoginForm(@RequestParam(name = "email") String em, @RequestParam String password, Model map,
			HttpSession hs, RedirectAttributes flashMap) {
		System.out.println("in process login form " + em + " " + password);
		// invoke service's method
		try {
			Vendor v = service.authenticateUser(em, password);
			// login success
			// save user dtls under sesison scope
			hs.setAttribute("user_dtls", v);
			flashMap.addFlashAttribute("mesg", "Login Successful");
			// check for role
			if (v.getRole().equals("vendor"))
				return "redirect:/vendor/details";// redirect view : clnt pull : send redirect + URL rewriting if needed
			//adming login
			return "redirect:/admin/list";

		} catch (RuntimeException e) {
			// add err mesg in model map
			map.addAttribute("mesg", "Invalid login , pls retry....");
			return "/user/login";// forward view
		}
	}

	// request hadnling method for user logout
	@GetMapping("/logout")
	public String logoutUser(HttpSession hs, Model map, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in user logout");
		map.addAttribute("dtls", hs.getAttribute("user_dtls"));
		// invalidate session
		hs.invalidate();
		// set HTTP response refresh header --to auto navigate the clnt to root of web
		// app
		response.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/user/logout";
	}

}
