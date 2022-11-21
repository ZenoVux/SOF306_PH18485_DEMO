package sof306.ph18485;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig2 {

//	@Bean
//	public BCryptPasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
//        UserDetails user = User.withUsername("user1")
//            .password(pe.encode("123"))
//            .roles("USER")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//	
////	@Bean
////	public AuthenticationManager authenticationManager(
////			AuthenticationManagerBuilder auth) throws Exception {
////		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
////		auth.inMemoryAuthentication().withUser("user1").password(pe.encode("123")).roles("GUEST")
////			.and().withUser("user2").password(pe.encode("123")).roles("GUEST", "USER")
////			.and().withUser("user3").password(pe.encode("123")).roles("GUEST", "USER", "ADMIN");
////		return auth.build();
////	}
//	
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().cors().disable();
//		http.authorizeRequests().anyRequest().authenticated();
//		http.httpBasic();
//		return http.build();
//	}
}
