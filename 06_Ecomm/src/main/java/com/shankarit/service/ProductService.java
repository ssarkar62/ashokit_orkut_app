package com.shankarit.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankarit.entity.Product;
import com.shankarit.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	public ProductRepository repo;
	
	public void saveProductService()
	{
		Product p=new Product();
		p.setName("Apple phone");
		p.setActive(true);
		p.setDescription("product 1 desc");
		p.setImageUrl("product.jpg");
		p.setPrice(new BigDecimal(1000000));
		repo.save(p);
		
	}
	
}
