package com.example.cnExpense.DAL;

import java.util.List;

import com.example.cnExpense.entities.IncomeType;

public interface IncomeTypeDAL {

	void delete(int id);

	List<IncomeType> getAll();

	IncomeType getById(int id);

	void saveIncomeType(IncomeType incomeType);

}
