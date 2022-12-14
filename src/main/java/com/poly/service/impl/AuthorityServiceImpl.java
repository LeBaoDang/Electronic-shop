package com.poly.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.dao.AuthorityDAO;

import com.poly.entitys.Account;
import com.poly.entitys.Authority;

import com.poly.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityDAO dao;
	
	@Autowired
	AccountDAO acdao;
	
	
	public List<Authority> findAll(){
		return dao.findAll();
	}
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		// lấy ra tài khoản admins
		List<Account> accounts = acdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

	@Override
	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void register(String username) {
		dao.register(username);
	}
		
}
