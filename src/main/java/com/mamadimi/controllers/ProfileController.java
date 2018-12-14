package com.mamadimi.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mamadimi.services.UserService;

@Controller
public class ProfileController {

	@Autowired
	UserService userService;


	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showRegisterForm(Locale locale, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		model.addAttribute("user", userService.getUserByEmail(auth.getName()));

		return "profile";
	}

}
