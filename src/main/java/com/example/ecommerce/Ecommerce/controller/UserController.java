package com.example.ecommerce.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecommerce.Ecommerce.model.Product;
import com.example.ecommerce.Ecommerce.model.UserInfo;
import com.example.ecommerce.Ecommerce.service.ProductService;
import com.example.ecommerce.Ecommerce.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@Controller
public class UserController {
	@Autowired
	private UserService userService;


	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ProductService productService;


	@GetMapping("/registration")
	public ModelAndView showRegistrationForm(Model model) {
		model.addAttribute("user", new UserInfo());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@ModelAttribute("user") @Valid UserInfo user, BindingResult bindingResult, Model model) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
			return modelAndView;
		}

		if (userService.isUserAlreadyPresent(user)) {
			modelAndView.addObject("message", "Username already exists!");
			modelAndView.setViewName("registration");
			return modelAndView;
		}

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		modelAndView.addObject("message", "User registration successful!");
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView showLoginForm(@ModelAttribute("user") @Valid UserInfo user,HttpServletRequest request) {
		UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
		request.getSession().setAttribute("userName", userDetails.getUsername());
		List<Product> products = productService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", products);
		modelAndView.setViewName("productdetails");
		return modelAndView;
	}

	// other controller 


}

