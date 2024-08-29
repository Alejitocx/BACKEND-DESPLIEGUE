package com.gold.backend.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gold.backend.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
	List<Optional<User>> findByEmployeeEmployeCode(String code);
	
    Optional<User> findByEmailUserAndPasswordUser(String emailUser, String passwordUser);

}

