package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IEmployeeService service;

	@GetMapping("/register")
	public String showRegisterForm(Employee e) {
		System.out.println("In showRegisterForm");
		return "/admin/register";

	}

	@PostMapping("/register")
	public String processRegisterForm(Employee e, HttpSession hs) {
		System.out.println("In processRegisterForm" + e);
		String url = service.registerEmployee(e,hs);
		String msg=(String) hs.getAttribute("msg1");
		hs.setAttribute("msg1", msg);
		hs.setAttribute("mesg", url);
		if (url.equals("/admin/register")) {

			return "redirect:/admin/register";
		}
		return "redirect:/departments/list";

	}
}
