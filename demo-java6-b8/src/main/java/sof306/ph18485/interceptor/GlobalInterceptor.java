package sof306.ph18485.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sof306.ph18485.service.CategoryService;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler,
			ModelAndView modelAndView) throws Exception {
		req.setAttribute("categories", categoryService.findAll());
	}

}
