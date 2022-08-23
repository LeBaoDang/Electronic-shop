package com.poly.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.dao.AuthorityDAO;
import com.poly.entitys.Account;

import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired 
	AccountDAO acdao;
	
	@Autowired
	AuthorityDAO authodao;
	
	@Override
	public Account findById(String username) {
		return acdao.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		return acdao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return acdao.getAdministrators();
	}

	@Override
	public Account save(Account userRequest) throws SQLException {
		return acdao.save(userRequest);
	}

}
