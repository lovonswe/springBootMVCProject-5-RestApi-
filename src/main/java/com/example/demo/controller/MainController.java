package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Student> getStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/course/all")
	public List<Course> getCourses(){
		return courseRepo.findAll();
	}
}
