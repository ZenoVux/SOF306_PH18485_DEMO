package sof306.ph18485.service;

import java.util.List;

import sof306.ph18485.entity.Account;

public interface AccountService {
	
	Account findByUsername(String username);

	List<Account> getAdministrators();

	List<Account> findAll();
	
}
