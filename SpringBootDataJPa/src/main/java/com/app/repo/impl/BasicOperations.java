package com.app.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class BasicOperations implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//save method
		repo.save(new Product("PEN",6.8,"BLUE"));
		repo.save(new Product("PENCIL",5.8,"RED"));
		repo.save(new Product("MOBILE",5000.8,"BLACK"));
		repo.save(new Product("LAPTOP",20000.0,"WHITE"));
		
	}

}
