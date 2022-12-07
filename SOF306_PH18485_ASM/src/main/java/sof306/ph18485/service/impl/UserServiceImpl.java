package sof306.ph18485.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Account;
import sof306.ph18485.service.AccountService;
import sof306.ph18485.service.UserService;

@Service
public class UserServiceImpl implements UserService  {

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

	@Override
	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
		String platform = oauth2.getAuthorizedClientRegistrationId();
		String username = oauth2.getName();
		Account account = accountService.findByUsername(username);
		if (account == null) {
			String fullname = "";
			if (platform.equals("google")) {
				fullname = oauth2.getPrincipal().getAttribute("given_name");
			} else if (platform.equals("facebook")) {
				fullname = oauth2.getPrincipal().getAttribute("name");
			}
			String email = oauth2.getPrincipal().getAttribute("email");
			account = new Account();
			account.setUsername(username);
			account.setFullname(fullname);
			account.setPassword(Long.toHexString(System.currentTimeMillis()));
			account.setEmail(email);
			account.setPhoto("");
			
			accountService.create(account);
		}
		String password = account.getPassword();
		UserDetails user = User.withUsername(username).password(pe.encode(password)).roles("GUEST").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
