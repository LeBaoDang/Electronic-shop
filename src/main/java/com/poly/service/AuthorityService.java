package com.poly.service;


import java.util.List;


import com.poly.entitys.Authority;


public interface AuthorityService {

	public List<Authority> findAuthoritiesOfAdministrators();

	public List<Authority> findAll();

	public Authority create(Authority auth);

	public void delete(Integer id);

	public void register(String username);
}
