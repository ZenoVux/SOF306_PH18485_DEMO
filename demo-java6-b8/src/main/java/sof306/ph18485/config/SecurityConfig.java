package sof306.ph18485.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		Tắt csrf và cros
		http.csrf().disable().cors().disable();

//		Phân quyền
		http.authorizeRequests()
			.antMatchers("/order/**").authenticated()
			.antMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
			.antMatchers("/api/authorities").hasRole("DIRE")
			.anyRequest().permitAll();
		
//		Kiểm tra lỗi truy cập
		http.exceptionHandling()
			.accessDeniedPage("/security/unauthoried");

//		Thay đổi trang đăng nhập
		http.formLogin()
			.loginPage("/security/login/form")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/security/login/success", false)
			.failureUrl("/security/login/error");
		
		http.rememberMe()
			.tokenValiditySeconds(86400);
		
//		Đăng xuất
		http.logout()
			.logoutUrl("/security/logout")
			.logoutSuccessUrl("/security/logout/success")
			.addLogoutHandler(new SecurityContextLogoutHandler());
		
//		Đăng nhập bằng MXH
//		http.oauth2Login()
//			.loginPage("/auth/login/form")
//			.defaultSuccessUrl("/oauth2/login/success")
//			.failureUrl("/auth/login/error")
//			.authorizationEndpoint()
//			.baseUri("/oauth2/authorization");
	}
	
//	Cho phép truy xuất api từ bên ngoài
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}
