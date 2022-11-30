package sof306.ph18485.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Account;
import sof306.ph18485.entity.Authority;
import sof306.ph18485.repository.AccountRepository;
import sof306.ph18485.repository.AuthorityRepository;
import sof306.ph18485.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepo;
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountRepo.getAdministrators();
		return authorityRepo.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return authorityRepo.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return authorityRepo.save(auth);
	}

	@Override
	public void delete(Integer id) {
		authorityRepo.deleteById(id);
	}

}
