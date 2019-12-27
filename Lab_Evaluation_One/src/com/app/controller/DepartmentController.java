package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IEmployeeService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/list")
	public String showDepartmentForm(HttpSession hs)
	{
		System.out.println("In showDepartmentForm");
		System.out.println(service.getDepartments());
		hs.setAttribute("departmemt_list",service.getDepartments());
		return "/departments/list";
		
	}
	
}
