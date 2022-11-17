package sof306.ph18485;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user1").password(pe.encode("123")).roles("GUEST")
			.and().withUser("user2").password(pe.encode("123")).roles("GUEST", "USER")
			.and().withUser("user3").password(pe.encode("123")).roles("GUEST", "USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
		http.authorizeRequests()
			.antMatchers("/hello").hasAnyRole("GUEST", "USER", "ADMIN")
			.anyRequest().permitAll();
//		http.httpBasic();
		
		http.formLogin()
			.loginPage("/login/form")
			.loginProcessingUrl("/login/submit")
			.defaultSuccessUrl("/hello", false)
			.usernameParameter("username")
			.passwordParameter("password");
		http.rememberMe()
			.rememberMeParameter("remember");
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/hello")
			.addLogoutHandler(new SecurityContextLogoutHandler());
	}
}
