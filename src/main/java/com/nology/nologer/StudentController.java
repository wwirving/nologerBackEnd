package com.nology.nologer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

	public StudentRepository repository = new StudentRepository();

	@GetMapping("/students")
	public ResponseEntity<Student> getStudents(){
		return new ResponseEntity(this.repository.findAll(),  HttpStatus.OK);
	}


	// get single student by id
	@GetMapping("/students/{courseId}")
	public ResponseEntity getCourse(@PathVariable String studentId) {
		Student student = this.repository.findById(studentId);

		if (student != null){
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student){
		this.repository.students.add(student);
		return student;
	}

	@DeleteMapping("/students/{studentId}")
	public ResponseEntity deleteStudent(@PathVariable String studentId){
		boolean result = this.repository.deleteById(studentId);

		if (result){
			return new ResponseEntity("Success, student removed!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
