package com.gold.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gold.backend.model.Empleado;
import com.gold.backend.model.User;
import com.gold.backend.repository.EmpleadoRepository;
import com.gold.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	  @Autowired
	    private UserRepository userRepository;

	  @Autowired
	    private EmpleadoRepository employeeRepository;
	  
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }

	    
	    public Optional<Empleado> findEmployeeByCode(String employeCode) {
	        return employeeRepository.findById(employeCode);
	    }
	    
	    public Optional<User> findUserByEmployeeCode(String employeCode) {
	        List<Optional<User>> users = userRepository.findByEmployeeEmployeCode(employeCode);
	        try {
	        	return users.get(0);
			} catch (Exception e) {
				// TODO: handle exception
				return Optional.empty();
			}
	    }
	  
	    public Optional<User> findUserByEmailAndPassword(String emailUser, String passwordUser) {
	        return userRepository.findByEmailUserAndPasswordUser(emailUser, passwordUser);
	    }
	  
}

