package sof306.ph18485.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Account;
import sof306.ph18485.service.AccountService;

@Service
public class UserServiceImpl implements UserDetailsService  {

	@Autowired
	private AccountService accountService;
	private PasswordEncoder pe = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountService.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException(username + " không tồn tại");
		}
		String password = pe.encode(account.getPassword());
		String[] roles = account.getAuthorities()
				.stream()
				.map(authority -> authority.getRole().getId())
				.collect(Collectors.toList())
				.toArray(new String[0]);
		return User.withUsername(username).password(password).roles(roles).build();
	}
}
