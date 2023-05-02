package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	public boolean existsByUserName(String userName);
	public boolean existsByUserNameAndPassword(String userName, String password);
}