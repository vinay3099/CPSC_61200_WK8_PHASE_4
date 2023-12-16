package com.example.ecommerce.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecommerce.Ecommerce.model.Cart;
import com.example.ecommerce.Ecommerce.model.Product;
import com.example.ecommerce.Ecommerce.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CartController {

	
	@Autowired
    private ProductService productService;
	
	
	@GetMapping("/addToCart")
    public ModelAndView addToCart(@RequestParam("id") String productId, HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("userName");
		productService.addToCart(productId,userName);
        List<Product> products = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("productdetails");
        return modelAndView;
    }
	
	
	@GetMapping("/loadCart")
    public ModelAndView loadCart(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("userName");
		List<Product> products = productService.loadCart(userName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("cart");
        return modelAndView;
    }
	
	
	@GetMapping("/removeFromCart")
    public ModelAndView removeFromCart(@RequestParam("id") String productId,HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("userName");
		List<Product> products = productService.removeFromCart(userName,productId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("cart");
        return modelAndView;
    }
	
	
}
