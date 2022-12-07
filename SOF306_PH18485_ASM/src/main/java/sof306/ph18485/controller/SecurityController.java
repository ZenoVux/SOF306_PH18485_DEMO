package sof306.ph18485.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sof306.ph18485.service.UserService;

@Controller
public class SecurityController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginForm() {
		return "security/login";
	}

	@GetMapping("/login/error")
	public String loginError(RedirectAttributes redirect) {
		redirect.addFlashAttribute("message", "Sai thông tin đăng nhập");
		return "redirect:/login";
	}

	@GetMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Không có quyền truy xuất");
		return "security/login";
	}

	@GetMapping("/security/logout/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "security/login";
	}
	
	@RequestMapping("/oauth2/login/success")
	public String successOAuth2(OAuth2AuthenticationToken oauth2) {
//		System.out.println(oauth2.getAuthorizedClientRegistrationId());
//		System.out.println(oauth2.getPrincipal().getAttributes());
		userService.loginFromOAuth2(oauth2);
		return "redirect:/";
	}
}
