package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.entitys.Account;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired 
	AccountDAO acdao;
	
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

}
