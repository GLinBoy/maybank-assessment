package com.glinboy.test.maybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	@ResponseBody
	public String welcomeAsHTML() {
		return "Welcome to MayBank Assessment by Hojjat Abedi.";
	}

}
