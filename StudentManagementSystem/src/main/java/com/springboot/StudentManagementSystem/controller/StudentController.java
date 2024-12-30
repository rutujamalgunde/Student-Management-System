package com.springboot.StudentManagementSystem.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.StudentManagementSystem.entity.Student;
import com.springboot.StudentManagementSystem.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listOfStudents( Model model ) {
		
		model.addAttribute("students", studentService.getAllStudents());
		
		return "students";
	}
	
	@GetMapping("/students/new")
	public String newStudent(Model model) {
		
		//Create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "NewStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/update/{id}")
	public String updateStudent(@PathVariable int id, Model model) {
		
		model.addAttribute("student", studentService.getStudentById(id));
		System.out.println(studentService.getStudentById(id));
		return "updateStudent";
		
	}
	
	@PostMapping("/students/id")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		
		Student existingStudent = studentService.getStudentById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setStandard(student.getStandard());
		existingStudent.setDivision(student.getDivision());
		
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteStudentById(@PathVariable int id) {
		
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
	

}
