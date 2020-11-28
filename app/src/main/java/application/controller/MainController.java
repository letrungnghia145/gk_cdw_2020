package application.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import application.model.Member;
import application.service.ServiceImpl;

@Controller
//@PropertySource(value = {"classpath:message.properties"}, encoding = "UTF-8")
public class MainController {
	@Autowired
	private ServiceImpl service;

	@GetMapping({ "/", "/index", "/home" })
	public String getHomepage(Model model) {
		model.addAttribute("members", service.getMembers());
		return "member-list";
	}

	@GetMapping("/register")
	public String registry() {
		return "register";
	}

	@PostMapping("/register")
	public String registry(String email, String password, String name, String birthday, boolean male, String degree,
			String address, String phone, RedirectAttributes redirectAttributes) {
		Member member = new Member(email, password, name, new Date(), male, degree, address, phone);
		redirectAttributes.addFlashAttribute("member", service.addMember(member));
		return "redirect:/hello";
	}

	@GetMapping("/hello")
	public String getHello(Model model) {
		return "hello";
	}

	@GetMapping("/member-detail")
	public String getMemberDetail() {
		return "member-detail";
	}
}
