package com.example.cnExpense.service;

import java.util.List;

import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.UserDAL;
import com.example.cnExpense.entities.User;



@Service
public class UserService {

	@Autowired
	private UserDAL userDal;
	
	@Transactional
	public List<User> getAllUser() {
		List<User> allUser = userDal.getAllUser();
		if(allUser == null) {
			
		}
		return allUser;
	}

	@Transactional
	public User getUserById(int id) {
		User user = userDal.getUserById(id);
		return user;
	}

	@Transactional
	public User saveUser(User newUser) {
//		User user = userDal.getUserById(newUser.getId());
//		if(user != null) {
//			
//		}
		
		return userDal.saveUser(newUser);
	}

	@Transactional
	public boolean checkUserExist(User user) {
		return userDal.checkUserExist(user);
	}

	@Transactional
	public List<User> getFilteredUserListByType(String incomeType, String expenseType) {
		List<User> allUserList = userDal.getFilteredUserListByType(incomeType, expenseType);
		if(allUserList == null) {
			
		}
		return allUserList;
	}

	@Transactional
	public List<User> getFilteredUserListByCalendar(String day, String month, String year) {
		List<User> allUserList = userDal.getFilteredUserListByCalendar(day, month, year);
		
		if(allUserList == null) {
			
		}
		return allUserList;
	}

	@Transactional
	public User findUser(User user) {
		return userDal.findUser(user);
	}

}
