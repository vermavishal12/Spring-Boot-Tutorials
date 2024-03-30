package com.example.cnExpense.DAL;

import java.util.List;
import com.example.cnExpense.entities.User;

public interface UserDAL {
	
	public List<User> getAllUser();

	public User getUserById(int id) ;
	
	public User saveUser(User newUser);

	public boolean checkUserExist(User user);

	public List<User> getFilteredUserListByType(String incomeType, String expenseType);

	public List<User> getFilteredUserListByCalendar(String day, String month, String year) ;
	
	public User findUser(User newUser) ;

	public void delete(int userId);

}
