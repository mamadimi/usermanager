package com.mamadimi.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mamadimi.models.User;
import com.mamadimi.services.UserService;
import com.mamadimi.validators.UserValidator;

@Controller
public class RegisterController {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(Locale locale, Model model) {
		model.addAttribute("user", new User());

		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewUser(@ModelAttribute("user") @Validated User user, BindingResult result) {

		if (result.hasErrors()) {
			return "registerForm";
		}
		
		userService.save(user);
		
		return "redirect:/login";
	}
}
