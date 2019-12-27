package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.app.service.Iservice;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private Iservice service;

	@GetMapping("/list")
	public String showList(HttpSession hs) {
		hs.setAttribute("course_list", service.getAllCourse());
		return "/courses/list";
	}

}
