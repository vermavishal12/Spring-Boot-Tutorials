package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@PostMapping("/save/{incomeId}")
	@ResponseBody
	public Income saveByIncomeId(@PathVariable Integer incomeId, @RequestBody Expense expense ) {
		return expenseService.saveByIncomeId(incomeId, expense);
	}
}
