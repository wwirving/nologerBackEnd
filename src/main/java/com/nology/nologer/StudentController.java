package com.nology.nologer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

	List<Student> students = new ArrayList<Student>();

	public StudentController(){
		String[] alexint = {"Sailing", "Walking"};
		Student alex = new Student("Alex","Fazan",31,"Bristol", alexint, "0");
		students.add(alex);
		String[] willint = {"Music", "Art"};
		Student will = new Student("Will","Irving",25,"Bristol", willint, "1");
		students.add(will);
		String[] mayint = {"Painting", "Coding"};
		Student may = new Student("May","Chung",24,"Scotland", mayint, "2");
		students.add(may);
		String[] sakeenint = {"Memes", "Anime"};
		Student sakeen = new Student("Sakeen","Zaman",23,"London", sakeenint, "3");
		students.add(sakeen);
		String[] edint = {"Skiing", "Tennis"};
		Student ed = new Student("Ed","Hughes",25,"London", edint, "4");
		students.add(ed);
		String[] clintint = {"Running", "Painting"};
		Student clint = new Student("Clint","McTribouy-Koy",22,"London", clintint, "5");
		students.add(clint);
	}
	//... we have no students

	// get students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return this.students;
	}

	// get single student by id
	@GetMapping("/students/{studentId}")
	@ResponseBody
	public Student getStudent(@PathVariable String studentId){
		for (Student student : students){
			if (studentId.equals(student.getId())){
				return student;
			}
		}
		return null;
	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student){
		System.out.println("the name is " + student.getFirstName());
		this.students.add(student);
		for (Student s : students){
			System.out.println(s.getFirstName());
		}
		return student;
	}

	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable String studentId){
		for (Student student : students) {
			if (studentId.equals(student.getId())) {
				students.remove(student);
			}
		}
	}



	// delete a student by id as well


}
