package com.lhu.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lhu.springboot.model.Student;

//public interface StudentDao extends CrudRepository<Student, Integer>{
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	List<Student> findByName(String name);
	List<Student> findByAgeGreaterThan(int age);
	
	@Query("from Student where name = ?1 and age = ?2")
	List<Student> findByAgeAndName(String name,int num);
	
}
