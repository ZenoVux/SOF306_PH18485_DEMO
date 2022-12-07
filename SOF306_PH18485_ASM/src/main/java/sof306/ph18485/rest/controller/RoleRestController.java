package sof306.ph18485.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sof306.ph18485.entity.Role;
import sof306.ph18485.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping
	public List<Role> getAll() {
		return roleService.findAll();
	}
}
