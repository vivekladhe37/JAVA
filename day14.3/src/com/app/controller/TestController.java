package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/numbers")
public class TestController {
	public TestController() {
		System.out.println("in constr " + getClass().getName());
	}

	@GetMapping
	public  List<Integer> test1() {
		System.out.println("in test1");
		return Arrays.asList(12, 34, 56, 78);
	}
}
