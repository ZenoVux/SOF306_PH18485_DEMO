package sof306.ph18485.controllers;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import sof306.ph18485.beans.Student;

@Controller
public class HomeController {
	
	@GetMapping("/home/index")
	public String hello(Model model) throws Exception {
		model.addAttribute("message", "Xin chao");
		ObjectMapper mapper = new ObjectMapper();
		String path = "D:\\FPOLY\\FALL22\\BLOCK2\\SOF306\\Labs\\demo-java6\\src\\main\\java\\sof306\\ph18485\\beans\\student.json";
		Student student = mapper.readValue(new File(path), Student.class);
		model.addAttribute("sv", student);
		return "home/index";
	}
	
}
