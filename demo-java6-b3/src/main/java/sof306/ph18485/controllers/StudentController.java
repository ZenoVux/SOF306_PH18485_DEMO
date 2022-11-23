package sof306.ph18485.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import sof306.ph18485.beans.Student;

@Controller
public class StudentController {
	
	@GetMapping("/student/form")
	public String form(Model model) {
		Student student = new Student();
		model.addAttribute("sv", student);
		return "student/form";
	}
	
	@GetMapping("/student/save")
	public String save(Model model, @Validated @ModelAttribute("sv") Student sv, Errors errors) {
		if(errors.hasErrors()) {
			model.addAttribute("messgae","Vui lòng sửa các lỗi sau");
			return "student/form";
		}
		return "student/success";
	}
}
