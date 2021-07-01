package com.nology.nologer;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CourseController {

	List<Course> courses = new ArrayList<Course>();

	public CourseController(){
		Course creativeCoding = new Course("CZ441","Creative Coding");
		courses.add(creativeCoding);
	}

	@GetMapping("/courses")
	public List <Course> getCourses(){
		return this.courses;
	}

	@GetMapping("/courses/{courseId}")
	@ResponseBody
	public Course getCourse(@PathVariable String courseId){
		for (Course course : courses){
			if (courseId.equals(course.getCourseId())){
				return course;
			}
		}
		return null;
	}

	@PostMapping("/courses")
	public Course createCourse(@RequestBody Course course){
		this.courses.add(course);
		return course;
	}

	@DeleteMapping("/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId){
		for (Course course : courses){
			if (course.getCourseId().equals(courseId)){
				this.courses.remove(course);
			}
		}
	}


}
