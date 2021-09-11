package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Customer;


public interface UsersRepository extends JpaRepository<Customer, Integer>{

}
