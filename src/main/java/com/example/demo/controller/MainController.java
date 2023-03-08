package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@RestController
public class MainController {
	
	@Autowired 
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;
	
	@GetMapping("/")
	public String hello() {
		return "Hello coders...";
	}
	
	@GetMapping("/student/all")
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/course/all")
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> findStudentById(@PathVariable("id") int id) {
		return studentRepo.findById(id);
	}
	
	@GetMapping("/course/{id}")
	public Optional<Course> findCourseById(@PathVariable("id") int id) {
		return courseRepo.findById(id);
	}
	
	
}
