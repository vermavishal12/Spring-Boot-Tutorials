package com.example.cnExpense.service;

import java.util.List;

import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.ExpenseTypeDAL;
import com.example.cnExpense.entities.ExpenseType;

@Service
public class ExpenseTypeService {

	@Autowired
	ExpenseTypeDAL expenseTypeDal;
	
	@Transactional
	public void delete(int id) {
		expenseTypeDal.delete(id);
		
	}

	@Transactional
	public List<ExpenseType> getAll() {
		return expenseTypeDal.getAll();
	}

	@Transactional
	public ExpenseType getById(int id) {
		return expenseTypeDal.getById(id);
	}

	@Transactional
	public void saveExpenseType(ExpenseType expenseType) {
		expenseTypeDal.saveExpenseType(expenseType);
		
	}

}
