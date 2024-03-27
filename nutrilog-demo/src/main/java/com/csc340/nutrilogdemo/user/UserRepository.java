package com.csc340.nutrilogdemo.user;

import org.springframework.data.repository.CrudRepository;

import com.csc340.nutrilogdemo.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
