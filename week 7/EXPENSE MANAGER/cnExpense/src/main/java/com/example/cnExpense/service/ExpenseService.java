package com.example.cnExpense.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.ExpenseDAL;
import com.example.cnExpense.DAL.IncomeDAL;
import com.example.cnExpense.DAL.UserDAL;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;

import javax.transaction.*;



@Service
public class ExpenseService {

	@Autowired
	ExpenseDAL expenseDal;
	
	@Autowired
	IncomeDAL incomeDal;
	
	@Autowired
	UserDAL userDal;
	
	@Transactional
	public Income saveByIncomeId(int incomeId, Expense expense) {
		// TODO Auto-generated method stub
		Income income=new Income();
		income.setId(incomeId);
		return expenseDal.saveExpense(income,expense);
	}
	
	
}
