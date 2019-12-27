package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IVendorDao dao;

	public AdminController() {
		System.out.println("in admin controller constr");
	}

	// request handling method to list the vendors
	@GetMapping("/list")
	public String listVendors(Model map) {
		System.out.println("in list vendors");
		map.addAttribute("vendor_list", dao.listAllVendors());
		return "/admin/list";
	}

	// request handling method to delete vendor dtls
	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in delete vendor " + vid);
		flashMap.addFlashAttribute("mesg", dao.deleteVendor(vid));
		return "redirect:/admin/list";
	}

	// request handling method to show reg form
	@GetMapping("/register")
	// SC invokes
	// Vendor v=new Vendor(); getters
	// pojo --view layer
	// map.addAttribute("vendor",v);
	public String showRegForm(Vendor v) {
		System.out.println("show reg form " + v);
		return "/admin/register";
	}

	// req handling method to process reg form

	@PostMapping("/register")
	// Vendor v=new Vendor();getters
	// are there any rq params(path) matching with pojo prop setters
	// invokes ALL matching setters
	// map.addAttribute("vendor",v);
	public String registerVendor(Vendor transientVendor, RedirectAttributes flashMap) {
		System.out.println("in process reg form " + transientVendor);
		flashMap.addFlashAttribute("mesg", dao.registerVendor(transientVendor));
		return "redirect:/admin/list";
	}

}
