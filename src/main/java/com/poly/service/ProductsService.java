package com.poly.service;

import java.util.List;

import com.poly.entitys.Product;

public interface ProductsService {
	
	List<Product> findAll();

	Product findById(Integer id);


	List<Product> findByCatergoryid(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

}
