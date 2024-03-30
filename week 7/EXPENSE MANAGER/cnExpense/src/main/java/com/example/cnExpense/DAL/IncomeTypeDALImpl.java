package com.example.cnExpense.DAL;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnExpense.entities.IncomeType;



@Repository
public class IncomeTypeDALImpl implements IncomeTypeDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		IncomeType incomeType = session.get(IncomeType.class, id);
		session.save(incomeType);
	}

	@Override
	public List<IncomeType> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<IncomeType> incomeTypes = session.createQuery("Select i from IncomeType i", IncomeType.class).getResultList();
		return incomeTypes;
	}

	@Override
	public IncomeType getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		IncomeType incomeType = session.get(IncomeType.class, id);
		return incomeType;
	}

	@Override
	public void saveIncomeType(IncomeType incomeType) {
		Session session = entityManager.unwrap(Session.class);
		session.save(incomeType);
		
	}

}
