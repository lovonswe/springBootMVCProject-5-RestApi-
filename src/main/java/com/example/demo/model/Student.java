package com.example.demo.model;

import java.util.List;
/*import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;*/
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table (name="students")
public class Student {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@jakarta.persistence.ManyToMany(cascade = jakarta.persistence.CascadeType.MERGE, fetch=jakarta.persistence.FetchType.EAGER)
	@jakarta.persistence.JoinTable(name="course_enrolled", joinColumns=@jakarta.persistence.JoinColumn(name="sid"), inverseJoinColumns = @jakarta.persistence.JoinColumn(name="cid"))
	private List<Course> courses;
	
	public Student() {
		super();
	}

	public Student(int id, String name, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}	
}
