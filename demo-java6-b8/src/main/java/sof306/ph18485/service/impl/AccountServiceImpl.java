package sof306.ph18485.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Account;
import sof306.ph18485.repository.AccountRepository;
import sof306.ph18485.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account findByUsername(String username) {
		Optional<Account> optional = accountRepo.findByUsername(username);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Account> getAdministrators() {
		return accountRepo.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return accountRepo.findAll();
	}

}
