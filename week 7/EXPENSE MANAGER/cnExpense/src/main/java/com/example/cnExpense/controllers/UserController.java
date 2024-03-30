package com.example.cnExpense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cnExpense.entities.User;
import com.example.cnExpense.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	UserService userService;
	
	@GetMapping("/allUsers")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User newUser) {
		return userService.saveUser(newUser);
	}
	
	@PostMapping("/checkUserExist")
	public boolean checkUserExist(@RequestBody User user) {
		return userService.checkUserExist(user);
	}
	
	@PostMapping("/find")
	@ResponseBody
	public User findUser(@RequestBody User newUser) {
		return userService.findUser(newUser);
	}
	
	@GetMapping("/filteredUserListByCalendar")
	public List<User> getFilteredUserListByCalendar(@RequestParam(value = "day", required = false)
		String day,@RequestParam(value = "month", required = false)
		String month,@RequestParam(value = "year", required = false) 
		String year) {
		
		return userService.getFilteredUserListByCalendar(day,month,year);
	}
	
	@GetMapping("/filteredUserListByType")
	public List<User> getFilteredUserListByType(@RequestParam(value = "incomeType", required = false) 
		String incomeType,@RequestParam(value = "expenseType", required = false) 
		String expenseType) {
		
		return userService.getFilteredUserListByType(incomeType,expenseType);
	}
	
	
}
