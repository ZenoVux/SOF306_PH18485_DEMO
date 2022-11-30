package sof306.ph18485.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/login";
	}

	@GetMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "security/login";
	}

	@GetMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/login";
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
}
