package sof306.ph18485.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/login/submit")
	public String submit() {
		return "form";
	}
}
