package com.poly.service;


import java.sql.SQLException;
import java.util.List;

import com.poly.entitys.Account;

public interface AccountService {
	public List<Account> findAll();
	public Account findById(String username);
	public List<Account> getAdministrators();
	public Account save(Account userRequest) throws SQLException;
	
}	
