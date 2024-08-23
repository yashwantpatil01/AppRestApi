package com.SpringBoot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot1.model.Student;
import com.SpringBoot1.service.StudentService;
import com.SpringBoot1.service.impl.StudentServiceImpl;
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService stdser;

	public StudentController(StudentService stdser) {
		super();
		this.stdser = stdser;
	}
	//http://localhost:9898/student/save
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student std){
		return new ResponseEntity<Student>(stdser.saveStudent(std), HttpStatus.CREATED) ;
	}
	// http://localhost:9898/student/get
	@GetMapping("/get")
	public List<Student> getAllStudent(){
		return stdser.getAllStudents();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
		return new ResponseEntity<Student>(stdser.getStudentById(id), HttpStatus.OK);
		
	}
	
	//http://localhost:9898/student/update/2
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable("id") Long id, @RequestBody Student std){
		return new ResponseEntity<Student>(stdser.updateStudentById(std, id), HttpStatus.OK);
		
	}
	// http://localhost:9898/student/delete/2
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
		stdser.deleteStudentById(id);
		return new ResponseEntity<String>("Student is removed", HttpStatus.OK);
	}
	
	
}


/*
//build update employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp){
		return new ResponseEntity<Employee>(empser.updateEmployee(emp, id), HttpStatus.OK);
	}
	
	//build delete employee Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		//delete employee by id
		empser.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted sucessfully!. ",HttpStatus.OK);
	}
*/