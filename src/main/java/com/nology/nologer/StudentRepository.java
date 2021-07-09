package com.nology.nologer;

import java.util.List;
import java.util.ArrayList;

public class StudentRepository {

	public List<Student> students = new ArrayList<>();

	public StudentRepository(){
		this.students.add(new Student("Alex","Fazan",31,"Bristol", new String[]{"skiing", "tennis"}));
	}

	// find student by ID
	public Student findById(String studentId){
		for (Student s : this.students){
			if(s.getId().equals(studentId)){
				return s;
			}
		}
		return null;
	}

	// find all students
	public List<Student> findAll(){
		return this.students;
	}

	// delete student by id
	public boolean deleteById(String studentId){
		for (Student s : this.students){
			if (s.getId().equals(studentId)){
				return this.students.remove(s);
			}
		}
		return false;
	}
}
