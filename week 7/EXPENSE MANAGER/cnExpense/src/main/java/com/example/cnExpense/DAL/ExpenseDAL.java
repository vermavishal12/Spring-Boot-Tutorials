package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;

public interface ExpenseDAL {
	public Income saveExpense(Income income, Expense expense);
}
