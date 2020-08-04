package com.project.convention.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.convention.model.User;
import com.project.convention.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("/")
	public String init(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/login")
	public String display(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String loginValidity(@ModelAttribute(name="user") User user, Model model) {
		if (userService.verifyUser(user)) {
//		if("admin".equalsIgnoreCase(user.geUsername()) && "admin".equalsIgnoreCase(user.getPassword())) {
			return "redirect:/convention";
		}
		model.addAttribute("error", true);
		return "login";
	}

}
