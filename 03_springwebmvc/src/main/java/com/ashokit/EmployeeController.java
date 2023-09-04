package com.ashokit;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class EmployeeController {
	
	EmployeeController()
	{
		System.out.println("inside the default constructor of EmployeeController");
	}
	
	@RequestMapping("/show")
	public String showPages(Model m)
	{
		m.addAttribute("msg","Welcome App:"+ new Date());
		m.addAttribute("shankar","Hello shankar");
		return "Home";
	}
}
