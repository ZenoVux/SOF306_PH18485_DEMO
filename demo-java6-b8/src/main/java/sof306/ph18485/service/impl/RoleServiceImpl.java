package sof306.ph18485.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Role;
import sof306.ph18485.repository.RoleRepository;
import sof306.ph18485.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

}
