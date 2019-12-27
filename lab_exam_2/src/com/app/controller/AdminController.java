package com.app.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Student;
import com.app.service.Iservice;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private Iservice service;
	@GetMapping("/register")
	public String showRegisterForm(Student s)
	{
	   System.out.println("in showRegister form");	
	   return "/admin/register";
	   
	}
	@PostMapping("/register")
	public String processRegisterForm(Student s,HttpSession hs )
	{
	  	
		String page= service.registerStudents(s,hs);
		//flashMap.addFlashAttribute("mesg", service.registerStudents(s));
		hs.setAttribute("mesg", page);
		hs.setAttribute("mesg1", page);
		if(page.equals("/admin/register"))
		{
			return "/admin/register";
		}
		
		return "redirect:/courses/list";
			
	}
	

}
