package com.ashokit.repo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.model.Product;
import com.ashokit.repo.ProductRepository;
@Component
public class BasicOperations implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;

	BasicOperations()
	{
		super();
		System.out.println("super class constructor executed");
		
	}
	@Override
	public void run(String... args) throws Exception {
		
		//save method
		repo.save(new Product("PEN" , 6.8, "BLUE"));
		repo.save(new Product("PENCIL" , 5.8, "RED"));
		repo.save(new Product("LAPTOP" , 5000.8, "BLACK"));
		repo.save(new Product("KEYBOARD" , 2000.8, "GRAY"));
		
		//Find method-1
		/*
		 * Optional<Product> p=repo.findById(3); if(p.isPresent()) {
		 * System.out.println(p.get());
		 * 
		 * }else { System.out.println("No Data Found"); }
		 */
		
		//Find method-2
	//	repo.findAll().forEach((System.out::println));
		 
		//Delete method-by specific id
		repo.deleteById(3);
		
		//delete all rows one by one in sequence order
		repo.deleteAll();
		
		//delete all rows in batch (single query fired)
		repo.deleteAllInBatch();
		
	
		
	}

}
