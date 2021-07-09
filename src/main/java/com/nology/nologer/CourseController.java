package com.nology.nologer;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CourseController {

	public CourseRepository repository = new CourseRepository();

	@GetMapping("/courses")
	public ResponseEntity <Course> getCourses(){
		return new ResponseEntity(this.repository.findAll(),  HttpStatus.OK);
	}

	//get single course by ID
	@GetMapping("/course/{courseId}")
	public ResponseEntity getCourse(@PathVariable String courseId) {
		Course course = this.repository.findById(courseId);

		if (course != null){
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/courses")
	public Course createCourse(@RequestBody Course course){
		this.repository.courses.add(course);
		return course;
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity deleteCourse(@PathVariable String courseId){
		boolean result = this.repository.deleteById(courseId);

		if (result){
			return new ResponseEntity("Success, course removed!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
