package com.example.cnExpense.service;

import java.util.List;

import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnExpense.DAL.IncomeTypeDAL;

import com.example.cnExpense.entities.IncomeType;

@Service
public class IncomeTypeService {

	@Autowired
	IncomeTypeDAL incomeTypeDal;
	
	@Transactional
	public void delete(int id) {
		incomeTypeDal.delete(id);
		
	}

	@Transactional
	public List<IncomeType> getAll() {
		return incomeTypeDal.getAll();
	}

	@Transactional
	public IncomeType getById(int id) {
		return incomeTypeDal.getById(id);
	}

	@Transactional
	public void saveExpenseType(IncomeType incomeType) {
		incomeTypeDal.saveIncomeType(incomeType);
		
	}

	
}
