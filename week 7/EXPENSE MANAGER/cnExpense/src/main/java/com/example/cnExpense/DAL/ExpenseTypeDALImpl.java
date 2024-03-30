package com.example.cnExpense.DAL;

import java.util.List;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.ExpenseType;

import javax.persistence.*;

@Repository
public class ExpenseTypeDALImpl implements ExpenseTypeDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<ExpenseType> getAll() { 
		Session session = entityManager.unwrap(Session.class);
		
		List<ExpenseType> expenseTypes = session.createQuery("Select e from ExpenseType e", ExpenseType.class).getResultList();
		return expenseTypes;
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		ExpenseType expenseType = session.get(ExpenseType.class,id);
		session.delete(expenseType);
	}

	@Override
	public ExpenseType getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		ExpenseType expenseType = session.get(ExpenseType.class,id);
		return expenseType;
	}

	@Override
	public void saveExpenseType(ExpenseType expenseType) {
		Session session = entityManager.unwrap(Session.class);
		session.save(expenseType);
		
	}

}
