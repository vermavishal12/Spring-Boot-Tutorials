package com.codingninjas.jpaqueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingninjas.jpaqueries.entities.Course;
import com.codingninjas.jpaqueries.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAllByCourses_name(String course);

}
