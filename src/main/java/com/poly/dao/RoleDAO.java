package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entitys.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
