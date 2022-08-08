package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entitys.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
