package com.codingninjas.jpaqueries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingninjas.jpaqueries.entities.Grade;
import com.codingninjas.jpaqueries.entities.Student;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

	
	@Query(value = "SELECT AVG(grade.marks) FROM grade WHERE grade.student_id = ?1", nativeQuery = true)
	double getAverageGradesByStudentId(@Param("id") int id);
	
	/*
	   Write a Native Query to fetch the average of grades of a given
	   Student.
	 */
}
