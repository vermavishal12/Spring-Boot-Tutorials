package com.example.cnExpense.DAL;

import java.util.List;

import com.example.cnExpense.entities.ExpenseType;

public interface ExpenseTypeDAL {


	List<ExpenseType> getAll();

	void delete(int id);

	ExpenseType getById(int id);

	void saveExpenseType(ExpenseType expenseType);

}
