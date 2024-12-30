package com.springboot.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.StudentManagementSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
