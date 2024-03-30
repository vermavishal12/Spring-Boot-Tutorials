package com.example.cnExpense.DAL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.ExpenseType;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.IncomeType;
import com.example.cnExpense.entities.User;

import javax.persistence.*;

@Repository
public class UserDALImpl implements UserDAL{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<User> getAllUser() {
		Session session = entityManager.unwrap(Session.class);
		List<User> allUsers = session.createQuery("select u from User u", User.class).getResultList();
		return allUsers;
	}

	@Override
	public User getUserById(int id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public User saveUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
		return user;
	}

	@Override
	public boolean checkUserExist(User user) {
		boolean userExist=false;
		for (User everyUser: getAllUser()) {
			if (everyUser.getUsername().equalsIgnoreCase(user.getUsername())) {
				userExist = true;
			}
		}
		return userExist;
	}

	@Override
	public List<User> getFilteredUserListByType(String incomeType, String expenseType) {
		Session session = entityManager.unwrap(Session.class);
		List<User> allUsers = session.createQuery("select u from User u", User.class).getResultList();
		
		List<User> reqUser = new ArrayList<>();
		for(User users : allUsers) {
			boolean isIncome = false, isExpense = false;
			for(Income income : users.getIncomes()) {
				for(IncomeType incomeTypes : income.getIncomeTypes()) {
					if(incomeTypes.getName().equalsIgnoreCase(incomeType)) {
						isIncome = true;
						break;
					}
				}
				if(isIncome)
					break;
			}
			
			for(Expense expense : users.getExpenses()) {
				for(ExpenseType expenseTypes :expense.getExpenseTypes()) {
					if(expenseTypes.getName().equalsIgnoreCase(expenseType)) {
						isExpense = true;
						break;
					}
				}
				if(isExpense)
					break;
			}

			if(isExpense&&isIncome) {
				reqUser.add(users);
			}
		}
		
		return reqUser;
	}

	@Override
	public List<User> getFilteredUserListByCalendar(String day, String month, String year) {
		Session session = entityManager.unwrap(Session.class);
		List<User> userList = session.createQuery(
				"Select u from User u", User.class).getResultList();
	
		List<User> reqUser = new ArrayList<> ();
		for(User user : userList) {
			List<Income> incomeList = user.getIncomes();
			for(Income income: incomeList) {
				
				reqUser.add(user);
			}
		}
		
		return reqUser;
	}

	@Override
	public User findUser(User newUser) {
		Session session = entityManager.unwrap(Session.class);
		for(User user:getAllUser())
		{
			if(user.getUsername()!=null && user.getUsername().equalsIgnoreCase(newUser.getUsername()))
			{
				return user;
			}
		}
		return null;
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
	}

}
