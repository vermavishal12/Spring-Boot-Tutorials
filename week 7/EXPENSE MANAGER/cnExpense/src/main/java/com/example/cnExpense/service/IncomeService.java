package com.example.cnExpense.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.IncomeDAL;
import com.example.cnExpense.DAL.UserDAL;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;



@Service
public class IncomeService {

	@Autowired
	IncomeDAL incomeDal;
	
	@Autowired
	UserDAL userDal;

	@Transactional
	public Income getIncomeById(Integer incomeid) {
		return incomeDal.getIncomeById(incomeid);
	}

	@Transactional
	public Income saveIncome(User user,Income income) {
		return incomeDal.saveIncome(user,income);
	}

}
