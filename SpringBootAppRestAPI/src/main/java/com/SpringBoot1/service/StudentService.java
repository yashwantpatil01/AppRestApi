package com.SpringBoot1.service;

import java.util.List;

import com.SpringBoot1.model.Student;

public interface StudentService {
	Student saveStudent(Student std);
	
	List<Student> getAllStudents();
	
	Student getStudentById(Long id);
	
	Student updateStudentById(Student std, Long id);
	
	void deleteStudentById(Long id);

}
