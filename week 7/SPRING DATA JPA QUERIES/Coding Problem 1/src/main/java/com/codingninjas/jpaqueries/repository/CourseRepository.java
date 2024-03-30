package com.codingninjas.jpaqueries.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.jpaqueries.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByName(String course);
	
	/*
	 * Write a JPQL Query which returns the List of courses_name by the student id'
	 */
}
