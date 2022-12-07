package sof306.ph18485.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface UserService extends UserDetailsService {

	void loginFromOAuth2(OAuth2AuthenticationToken oauth2);

}
