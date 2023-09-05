package com.shankarit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shankarit.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
