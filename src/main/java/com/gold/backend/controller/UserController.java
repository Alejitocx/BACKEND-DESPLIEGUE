package com.gold.backend.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gold.backend.model.Empleado;
import com.gold.backend.model.User;
import com.gold.backend.repository.EmpleadoRepository;
import com.gold.backend.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://frontend-despliuegue-fk7-git-main-alejandro-grandas-projects.vercel.app/")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private UserService userService;
	@Autowired
	private EmpleadoRepository EmpleadoRepositorio;
	
	

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> createUser(
            @RequestParam("employe_code") String employeCode,
            @RequestParam("email_user") String emailUser,
            @RequestParam("password_user") String passwordUser) {

        Optional<Empleado> empleado = EmpleadoRepositorio.findById(employeCode);
        if (!empleado.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Employee code not found.");
        }

        Optional<User> userModel = userService.findUserByEmployeeCode(employeCode);
        if (userModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("User already exists in the database");
        }

        User newUser = new User();
        newUser.setEmailUser(emailUser);
        newUser.setPasswordUser(passwordUser);
        newUser.setEmployee(empleado.get());

        userService.saveUser(newUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body("User created successfully.");
    }



    @GetMapping("/findUser")
    public ResponseEntity<String> findUserByEmailAndPassword(
            @RequestParam("email_user") String emailUser,
            @RequestParam("password_user") String passwordUser) {

        // Verify if the user exists with the provided email and password
        Optional<User> user = userService.findUserByEmailAndPassword(emailUser, passwordUser);
        if (user.isPresent()) {
            return ResponseEntity.ok("User found");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Invalid email or password");
        }
    }
}