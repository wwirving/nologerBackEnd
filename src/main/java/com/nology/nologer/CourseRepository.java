package com.nology.nologer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;


public class CourseRepository {

	// TEMPORARY: Keep the courses stored in a list
	public List<Course> courses =new ArrayList<>();

	public CourseRepository(){
		this.courses.add(new Course("239429","Web Development"));
	}


	// find course by ID
	public Course findById(String courseId){
		for (Course c : this.courses) {
			if(c.getCourseId().equals(courseId)){
				return c;
			}
		}
		return null;
	}

	// find all courses
	public List<Course> findAll(){
		return this.courses;
	}

	// delete course by Id
	public boolean deleteById(String courseId){
		for (Course c : this.courses) {
			if(c.getCourseId().equals(courseId)){
				return this.courses.remove(c);
			}
		}
		return false;
	}
}
