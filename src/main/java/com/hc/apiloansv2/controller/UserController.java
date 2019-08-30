/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.apiloansv2.controller;

import com.hc.apiloansv2.exception.ResourceNotFoundException;
import com.hc.apiloansv2.model.User;
import com.hc.apiloansv2.repository.UserRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
/**
 *
 * @author mario
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
	private UserRepository userRepository;
    
    @GetMapping("/users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
    
    @GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
    
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
    
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Integer userId, @Valid @RequestBody User userRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
		user.setSurname(userRequest.getSurname());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        user.setDistrict(userRequest.getDistrict());
        user.setProvince(userRequest.getProvince());
        user.setDepartment(userRequest.getDepartment());
        user.setUserType(userRequest.getUserType());
        user.setReg_status(userRequest.getReg_status());
        
		final User updatedUser = userRepository.save(user);
        return updatedUser;
    }
    
    @DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser( @PathVariable(value = "id") Integer userId) {

		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        user.setReg_status("*");
        userRepository.save(user); // instead of -> userRepository.delete(usertype); 
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted, changed to status (*)", Boolean.TRUE);

		return response;
	}
}
