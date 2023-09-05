package com.shankarit.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankarit.entity.Product;
import com.shankarit.repository.ProductRepository;
import com.shankarit.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	public ProductService productService;
	
	
	
	@RequestMapping("/welcome")
	public String adminProductSave(Model model)
	{
		productService.saveProductService();
		model.addAttribute("msg","Hello shankar Apple product is saved successfully!");
		return "welcome";
	}
}
