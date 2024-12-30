package com.springboot.StudentManagementSystem.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.StudentManagementSystem.entity.Student;
import com.springboot.StudentManagementSystem.repository.StudentRepository;
import com.springboot.StudentManagementSystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student) {
	
		return studentRepository.save(student);
	}
	@Override
	public Student getStudentById(int id) {
		
		return studentRepository.findById(id).get();
	}
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		
		studentRepository.deleteById(id);
		
	}

}
