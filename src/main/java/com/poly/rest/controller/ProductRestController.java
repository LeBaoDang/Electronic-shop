package com.poly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entitys.Product;
import com.poly.service.ProductsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductsService productsService;
	
	@GetMapping()
	public List<Product> getAll(){
		return productsService.findAll();
	}
	
	// lấy 1 sản phẩm theo id
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return productsService.findById(id);
	}
	
	// post
	@PostMapping
	public Product create(@RequestBody Product product) {
		return productsService.create(product);
	}
	
	//put
	@PutMapping("{id}")
	public Product update(@PathVariable("id") Integer id,
			@RequestBody Product product) {
		return productsService.update(product);
	}
	
	// delete
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 productsService.delete(id);
	}
	
}
