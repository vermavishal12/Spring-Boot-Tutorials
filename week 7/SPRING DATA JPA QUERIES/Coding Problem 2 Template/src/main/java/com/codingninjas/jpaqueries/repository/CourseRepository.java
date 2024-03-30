package com.codingninjas.jpaqueries.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.jpaqueries.entities.Course;
import com.codingninjas.jpaqueries.entities.Student;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByName(String course);

	@Query("Select c.name from Course c where :student MEMBER OF c.students")
	List<String> getCoursesByStudentId(@Param("student")Student student);
	
	/*
	 * Write a JPQL Query which returns the List of courses_name by the student id'
	 */
}
