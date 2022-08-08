package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entitys.Product;
import com.poly.service.ProductsService;

@Controller
public class ProductController {
	
	@Autowired
	ProductsService ProductService;
	
	// ham số cid là tùy chọn nếu chọn hiểu thị theo loại ko thì hiển thị tât cả
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		
		// lọc theo loại nếu có, không thì chọn tất cả
		if(cid.isPresent()) {
			List<Product> list = ProductService.findByCatergoryid(cid.get());
			model.addAttribute("items",list);
		}else {
			List<Product> list = ProductService.findAll();
			model.addAttribute("items",list);
		}
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		Product item = ProductService.findById(id);
		model.addAttribute("item",item);
		return "product/detail";
	}
}
