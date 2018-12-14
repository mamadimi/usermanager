package com.mamadimi.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mamadimi.models.LoginUser;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showRegisterForm(@RequestParam(value = "error",required = false) String error,
			@RequestParam(value = "logout",	required = false) String logout, Locale locale, Model model) {
		
		model.addAttribute("loginUser", new LoginUser());
		
		if (error != null) {
			model.addAttribute("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addAttribute("message", "Logged out from User Manager successfully.");
		}

		return "loginForm";
	}

}
