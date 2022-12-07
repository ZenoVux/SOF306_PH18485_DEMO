package sof306.ph18485.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sof306.ph18485.interceptor.GlobalInterceptor;
import sof306.ph18485.interceptor.LoggedInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private GlobalInterceptor globalInterceptor;
	@Autowired
	private LoggedInterceptor loggedInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/api/**", "/admin/**", "/assets/**");
		registry.addInterceptor(loggedInterceptor)
			.addPathPatterns("/login", "/register");
	}
}
