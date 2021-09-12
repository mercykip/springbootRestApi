package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.User;


public interface UsersRepository extends JpaRepository<User, Integer>{

}
