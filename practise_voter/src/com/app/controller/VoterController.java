package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.ServiceImpl;


@Controller
@RequestMapping("/voter")
public class VoterController {
   @Autowired
	private ServiceImpl service;
	public VoterController()
	{
		System.out.println("in voter controller");
	}
	
	@GetMapping("/login")
	public String showForm()
	{
	 System.out.println("in show form");
	 return "/voter/login";
	}
	@PostMapping("/login")
	public String  processForm(@RequestParam String email,@RequestParam String password,Model map,HttpSession hs,RedirectAttributes flashmap)
	{
		try
		{
		System.out.println("in post of voter");
		hs.setAttribute("voter_details", service.authenticateVoter(email, password));
		flashmap.addFlashAttribute("msg","login successfull");
		}
		catch(RuntimeException e)
		{
			return "/voter/login";
		}
		return "redirect:/voter/candidatelist";
	
}
	
	
}
