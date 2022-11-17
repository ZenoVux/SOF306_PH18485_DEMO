package sof306.ph18485.controllers;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import sof306.ph18485.beans.Student;

@Controller
public class StudentController {

	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext servletContext;

	@GetMapping("/student")
	public String student(Model model, @RequestParam("index") Optional<Integer> index) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		File path = ResourceUtils.getFile("classpath:sof306/ph18485/beans/students.json");
		TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
		};
		List<Student> list = mapper.readValue(path, typeReference);
		int i = index.orElse(0);
		model.addAttribute("n", i);
		model.addAttribute("sv", list.get(i));
		return "scope/student";
	}
}
