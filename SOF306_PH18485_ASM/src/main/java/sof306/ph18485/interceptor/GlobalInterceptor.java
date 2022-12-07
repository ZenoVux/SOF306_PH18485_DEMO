package sof306.ph18485.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sof306.ph18485.entity.Account;
import sof306.ph18485.service.AccountService;
import sof306.ph18485.service.CategoryService;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AccountService accountService;

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler,
			ModelAndView modelAndView) throws Exception {
		String username = req.getRemoteUser();
		req.setAttribute("account", accountService.findByUsername(username));
		req.setAttribute("categories", categoryService.findAll());
	}

}
